package com.example.relationships.manytomany;
import javax.persistence.*;

import java.util.Set;

@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "employee")
    Set<ProjectAllotment> projectAllotmentSet;
}
