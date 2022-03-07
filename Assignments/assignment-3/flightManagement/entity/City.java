package com.flightManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "city")
@Entity
public class City {
    //from here//
    @Id
    @Column(name = "Code")
    private String cityCode;

    @Column(name = "Name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_code",referencedColumnName = "Code")
    private Country country;
    //To here//

    //mapping this table primary key to other//
    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Airport> airport;


}
