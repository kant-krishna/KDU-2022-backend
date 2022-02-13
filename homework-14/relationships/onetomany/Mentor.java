package com.example.relationships.onetomany;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Mentor")
public class Mentor {

    @Id
    @Column(name = "mentor_id")
    private int id;

    @OneToMany(mappedBy="mentor")
    private Set<Student> studentsSet;

    @Column(name = "mentor_name")
    private String name;

    @Column(name = "phone")
    private String phoneNumber;


}