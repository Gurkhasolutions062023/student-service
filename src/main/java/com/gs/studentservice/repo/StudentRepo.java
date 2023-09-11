package com.gs.studentservice.repo;

import com.gs.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    Student findByEmail(String email);

    @Query("select * from students where email= ? AND address=?")
    List<Student> getStudentByEmailAndAddress(String email, String address);
}
