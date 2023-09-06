package com.gs.studentservice.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Table(name = "student_table")
@Table
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stdId;

    @Column()
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String address;



}
