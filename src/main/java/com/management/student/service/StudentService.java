package com.management.student.service;

import com.management.student.enity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    Student getStudentById(int id);
    Student editStudent(Student student);
    void deleteStudent(int id);
}
