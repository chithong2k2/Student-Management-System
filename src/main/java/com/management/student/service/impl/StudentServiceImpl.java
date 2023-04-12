package com.management.student.service.impl;

import com.management.student.enity.Student;
import com.management.student.repository.StudentRepository;
import com.management.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository)
    {
        super();
        this.studentRepository=studentRepository;
    }
    @Override
    public List<Student> getAllStudent()
    {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }
    @Override
    public Student editStudent(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
