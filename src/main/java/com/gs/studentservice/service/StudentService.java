package com.gs.studentservice.service;
import com.gs.studentservice.model.Student;
import com.gs.studentservice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    /// create a service name >> account-service
    //create controller
    // create a service class
    //create a model object
     ///Long id-->accountId
    // stdId Long
    // payementMonth --->String
    /// basePayment---> Integer
    // totalDue---> Integer


    // create a api -- postMapping
    // save accountDetails



    @Autowired
    private StudentRepo studentRepo;

    public Student createStudent(Student student) {
//        if(student.getEmail()=="abc@gmail"){
//            return;
//        }
       Student saveStudent = studentRepo.save(student);
       return saveStudent;

    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getUserById(Long stdId) {
        if(stdId==null){
            //throw some exception
            return null;
        }
      Optional<Student> studentById= studentRepo.findById(stdId);
        if(studentById.isPresent()){
            return studentById;
        }
        // throw some exception
        return null;

    }

    public String deleteStudents(Long stdId) {
        try {
           Optional<Student> student= studentRepo.findById(stdId);
           if(student.isPresent()) {
               studentRepo.deleteById(stdId);
               return "Student with id " + stdId + " deleted successfully.";
           }
           return "Student with id "+stdId+ " doesnot exit in db";
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
