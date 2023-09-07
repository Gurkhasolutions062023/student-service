package com.gs.studentservice.controller;

import com.gs.studentservice.model.Student;
import com.gs.studentservice.service.StudentService;
import com.gs.studentservice.utils.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /// Read -- All the records from database

    @PostMapping(ApplicationConstants.endpoints)
    public ResponseEntity<?> createStudent(@RequestBody Student student){
      Student student1= studentService.createStudent(student);
      return new ResponseEntity<>(student1,HttpStatus.OK);


    }

    @GetMapping(ApplicationConstants.endpoints)
    public List<Student> getAllStudents(){

        String s="jdjdj";
        List<Student> students=studentService.getAllStudents();

        return students;
    }


    @GetMapping(ApplicationConstants.endpoints+"/{stdId}")
    public Student getStudentById(@PathVariable Long stdId ){
       return studentService.getUserById(stdId).get();

    }
    @DeleteMapping("/students/{stdId}")
    public Object deleteUserById(@PathVariable Long stdId){
        Map<String,String> info= new HashMap<>();
        String deleteMessage=studentService.deleteStudents(stdId);
        info.put("message",deleteMessage);
        return info;
    }

































}
