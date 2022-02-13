package com.example.relationships.manytomany;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "projects")
public class Project {

    @Id
    @Column(name = "project_id")
    private int id;

    @Column(name= "start_date")
    private Date start_date;

    @OneToMany(mappedBy = "projects")
    Set<ProjectAllotment> projectAllotmentSet;
}
