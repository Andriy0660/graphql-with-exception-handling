package com.andrii.graphql.service;


import com.andrii.graphql.entity.Student;
import com.andrii.graphql.exception.BadRequestException;
import com.andrii.graphql.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class StudentJpaService implements StudentDAO{
    private final StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->
                new BadRequestException("The student with id " + id  + " is not present" ));
    }

    @Override
    public Student save(Student student) {
         return studentRepository.saveAndFlush(student);
    }

    @Override
    public Student deleteStudentById(Long id) {
        Student student = getStudentById(id);
        studentRepository.deleteById(id);
        return student;
    }


}
