package com.management.student.controller;

import com.management.student.enity.Student;
import com.management.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        super();
        this.studentService=studentService;
    }
    @GetMapping("/")
    public String listStudents(Model model)
    {
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students != null ? students : Collections.emptyList());
        return "index";
    }
    @GetMapping("/add")
    public String addStudent(Model model)
    {
        Student st=new Student();
        model.addAttribute("student",st);
        return "add_student";
    }
    @PostMapping("/")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model model)
    {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student,Model model)
    {
        Student st=studentService.getStudentById(id);
        st.setFirstName(student.getFirstName());
        st.setLastName(student.getLastName());
        st.setEmail(student.getEmail());

        studentService.editStudent(st);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id, @ModelAttribute("student") Student student,Model model)
    {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
