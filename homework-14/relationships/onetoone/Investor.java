package com.example.relationships.onetoone;

import javax.persistence.*;

@Entity
@Table(name = "investors")
public class Investor {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "registration_number")
        private Long registrationNumber;

        @Column(name = "investor_name")
        private String name;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "portfolio_id", referencedColumnName = "id")
        private Portfolio portfolio;

}
