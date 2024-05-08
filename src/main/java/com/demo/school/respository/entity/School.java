package com.demo.school.respository.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "school")
@Data
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "date_of_birth")
    private Date dob;
    @Column(name = "joining_date")
    private Date joiningDate;
    @Column(name = "class")
    private String standard;


}
