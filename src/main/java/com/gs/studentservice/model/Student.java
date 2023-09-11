package com.gs.studentservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "first name cannot be blank")
    @NotNull(message = "first name cannot be null")
    private String firstName;

    @Column
    @NotBlank(message = "last name cannot be blank")
    @NotNull(message = "last name cannot be null")
    private String lastName;

    @Column
    @NotBlank(message = "last name cannot be blank")
    @NotNull(message = "last name cannot be null")
    @Email(message = "should be proper email")
    private String email;

    @Column
    @NotBlank(message = "last name cannot be blank")
    @NotNull(message = "last name cannot be null")
    private String address;



}
