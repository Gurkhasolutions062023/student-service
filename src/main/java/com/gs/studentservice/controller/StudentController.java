package com.gs.studentservice.controller;

import com.gs.studentservice.model.Student;
import com.gs.studentservice.service.StudentService;
import com.gs.studentservice.utils.ApplicationConstants;
import com.gs.studentservice.utils.StudentResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<?> createStudent(@RequestBody @Valid Student student){
      Student student1= studentService.createStudent(student);
      return new ResponseEntity<>(student1,HttpStatus.OK);


    }

    // Oauth --->

    // gooogle---> gmail --- verfied
    // username and password
    // signin with googgle or facebook
    // accessToken @ refereshToken



    @GetMapping(ApplicationConstants.endpoints)
    public ResponseEntity<?> getAllStudents(){
        StudentResponse<List<Student>> studentResponse= new StudentResponse<>();
        List<Student> students=studentService.getAllStudents();
        if(students.size()==0) {
            studentResponse.setStatus(HttpStatus.OK.value());
            studentResponse.setMessage("No students are available");
            return ResponseEntity.ok().body(studentResponse);
        }
        studentResponse.setStatus(HttpStatus.OK.value());
        studentResponse.setMessage(students.size()+" students are available");
        studentResponse.setData(students);
        return ResponseEntity.ok().body(studentResponse);

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

    @PutMapping("/students/{std_id}")
    public ResponseEntity<?> updateStudents(
            @RequestBody  @Valid Student student,
            @PathVariable Long std_id){
        Optional<Student> studentById = studentService.getUserById(std_id);
       if(student.getAddress()==null){
           return ResponseEntity.badRequest().body("address should not be null");
       }

        if(studentById.isPresent()){
          Student updatedStudent=  studentService.updateStudent(studentById,student);
          return ResponseEntity.ok().body(updatedStudent);

        }

        return ResponseEntity.badRequest().body("No user with id "+std_id+"  found");


    }

   @GetMapping(ApplicationConstants.endpoints+"/search")
    public ResponseEntity<?> getStudentByEmail(@RequestParam(required = true ) String email){
     return  ResponseEntity.ok().body(studentService.getStudentByEmail(email));
   }

































}
