package com.gs.studentservice.utils;

import lombok.Data;

@Data
public class StudentResponse<T> {
    private Integer status;
    private String message;
    private T data;
    private Object error;


}
