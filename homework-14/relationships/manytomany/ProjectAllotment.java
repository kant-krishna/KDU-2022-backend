package com.example.relationships.manytomany;
import javax.persistence.*;

@Entity
public class ProjectAllotment {

    @EmbeddedId
    String id;

    @ManyToOne
    @MapsId("employeeID")
    @JoinColumn(name = "employee_id")
    Employee employee;

    @ManyToOne
    @MapsId("projectID")
    @JoinColumn(name = "project_id")
    Project project;

}
