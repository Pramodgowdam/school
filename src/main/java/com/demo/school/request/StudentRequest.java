package com.demo.school.request;

import lombok.Data;

import java.util.Date;

@Data
public class StudentRequest{
    private String name;
    private Date joiningDate;
    private Date dateOfBirth;
    private String standard;
}
