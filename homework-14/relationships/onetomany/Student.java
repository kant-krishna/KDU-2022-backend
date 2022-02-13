package com.example.relationships.onetomany;
import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @Column(name = "student_id")
    private int id;


    @ManyToOne
    @JoinColumn(name="mentor_id", nullable=false)
    private Mentor mentor;

    @Column(name = "student_name")
    private String name;

}
