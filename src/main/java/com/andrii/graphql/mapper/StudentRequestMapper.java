package com.andrii.graphql.mapper;

import com.andrii.graphql.entity.Student;
import com.andrii.graphql.request.StudentRequest;
import lombok.AllArgsConstructor;

import java.util.function.Function;
@AllArgsConstructor
public class StudentRequestMapper implements Function<StudentRequest, Student> {
    private Student student;
    @Override
    public Student apply(StudentRequest studentRequest) {
        AddressRequestMapper addressRequestMapper = new AddressRequestMapper(student);
        LearningSubjectsRequestMapper subjectsRequestMapper = new LearningSubjectsRequestMapper(student);
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setLearningSubjects(subjectsRequestMapper.apply(studentRequest.getLearningSubjects()));
        student.setAddress(addressRequestMapper.apply(studentRequest.getAddress()));
        return student;
    }
}
