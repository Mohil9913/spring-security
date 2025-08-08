package org.mohil.springsecueitydemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.mohil.springsecueitydemo.model.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Mohil", "Mokaira"),
            new Student(2, "Ajay", "Verma"),
            new Student(3, "Navin", "Reddy")
    ));

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        students.add(student);
    }
}
