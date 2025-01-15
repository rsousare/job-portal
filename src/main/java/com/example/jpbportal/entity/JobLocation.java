package com.example.jpbportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String city;
    private String state;
    private String country;

    @Override
    public String toString() {
        return "Job Location: " +
                "Id: " + Id +
                ", City: " + city +
                ", State: " + state +
                ", Country: " + country;
    }
}
