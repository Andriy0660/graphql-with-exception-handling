package com.andrii.graphql.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import com.andrii.graphql.response.AddressResponse;
import com.andrii.graphql.response.StudentResponse;
import com.andrii.graphql.response.SubjectResponse;
import com.andrii.graphql.entity.Subject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {
    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse){
        List<SubjectResponse> learningSubjects = new ArrayList<>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }

        return learningSubjects;
    }
    public AddressResponse getAddress(StudentResponse studentResponse){
        return new AddressResponse(studentResponse.getStudent().getAddress());
    }

}
