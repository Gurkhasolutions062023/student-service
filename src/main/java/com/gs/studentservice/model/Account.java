package com.gs.studentservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    private  String account;

    @Column
    private  int paymentMonth;

    @Column
    private  int basePayment;

    @Column
    private  int totalDue;

}
