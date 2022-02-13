package com.example.relationships.onetoone;
import javax.persistence.*;

@Entity
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "portfolio_id")
    private Long id;

    @OneToOne(mappedBy = "portfolios")
    private Investor investor;

    @Column(name = "data")
    private String portfolioData;

}