package com.gs.studentservice.service;
import com.gs.studentservice.exception.StudentIdNotNull;
import com.gs.studentservice.exception.StudentNotFoundException;
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
            throw new StudentIdNotNull("Student Id cannot be null");
        }
      Optional<Student> studentById= studentRepo.findById(stdId);
        if(studentById.isPresent()){
            return studentById;
        }
        // throw some exception
        throw new StudentIdNotNull("Student Id cannot be found");

    }

    public String deleteStudents(Long stdId) {
        try {
           Optional<Student> student= studentRepo.findById(stdId);
           if(student.isPresent()) {
               studentRepo.deleteById(stdId);
               return "Student with id " + stdId + " deleted successfully.";
           }
           throw new StudentNotFoundException("Student with id " + stdId + " doesnot exit.");
        } catch (Exception e){
            e.printStackTrace();
            throw new StudentNotFoundException(e.getMessage());
        }



    }

    public Student updateStudent(Optional<Student> studentById, Student student) {
        Student currentStudent=studentById.get();
        currentStudent.setAddress(student.getAddress());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setFirstName(student.getFirstName());
        currentStudent.setLastName(student.getLastName());

        return studentRepo.save(currentStudent);

    }

    public Student getStudentByEmail(String email) {
       return studentRepo.findByEmail(email);

    }
}
