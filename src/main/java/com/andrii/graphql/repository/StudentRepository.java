package com.andrii.graphql.repository;

import com.andrii.graphql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
