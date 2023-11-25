package com.andrii.graphql.service;

import com.andrii.graphql.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getStudents();
    Student getStudentById(Long id);
    Student save(Student student);
    Student deleteStudentById(Long id);

}
