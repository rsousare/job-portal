package com.example.jpbportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recruiter_profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecruiterProfile {
    @Id
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String company;

    @Column(nullable = true, length = 64)
    private String profilePhoto;

    public RecruiterProfile(Users userId) {
        this.userId = userId;
    }

    public String photosImagePath() {
        if (profilePhoto == null) return null;
        return "/photos/recruiter/" + userAccountId + "/" + profilePhoto;
    }

    @Override
    public String toString() {
        return "RecruiterProfile: " +
                "User Account Id: " + userAccountId +
                ", User Id: " + userId +
                ", First Name: " + firstName +
                ", Last Name: " + lastName +
                ", City: " + city +
                ", State: " + state +
                ", Country: " + country +
                ", Company: " + company +
                ", Profile Photo: " + profilePhoto;
    }
}
