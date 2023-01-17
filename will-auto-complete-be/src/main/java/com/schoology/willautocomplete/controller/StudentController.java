package com.schoology.willautocomplete.controller;

import com.schoology.willautocomplete.entity.Student;
import com.schoology.willautocomplete.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/search")
    public List<Student> search(@RequestParam("q") String query) {
        return studentService.search(query);
    }
}
