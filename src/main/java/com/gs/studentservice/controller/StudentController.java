package com.gs.studentservice.controller;

import com.gs.studentservice.model.Student;
import com.gs.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {
//// CRUD Operation
    // GEt--> READ -- @GetMapping
    // Post ---> Create -- @PostMapping
    // Put --> update --- @PutMapping

    //Delete-> Delete-->@DeleteMapping


    @Autowired
    private StudentService studentService;

    private String myName ="myname";

    private Integer myNumber=5;


    @GetMapping("/hello")
    public String getString(){
        String hello="Hello World";


        return hello;
    }

    // create operation-- help us to create a student record

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
      return studentService.createStudent(student);


    }























}
