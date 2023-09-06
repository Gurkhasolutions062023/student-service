package com.gs.studentservice.service;
import com.gs.studentservice.model.Student;
import com.gs.studentservice.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
