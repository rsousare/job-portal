package com.example.jpbportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "job_seeker_profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobSeekerProfile {
    @Id
    private Integer userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String workAuthorization;
    private String employmentType;
    private String resume;

    @Column(nullable = true, length = 64)
    private String profilePhoto;

    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL, mappedBy = "jobSeekerProfile")
    private List<Skills> skills;

    public JobSeekerProfile(Users userId) {
        this.userId = userId;
    }

    @Transient
    public String getPhotosImagePath() {
        if (profilePhoto == null || userAccountId == null) return null;
        return "/photos/candidate/" + userAccountId + "/" + profilePhoto;
    }

    @Override
    public String toString() {
        return "Job Seeker Profile: " +
                "User Account Id: " + userAccountId +
                ", User Id: " + userId +
                ", First Name: " + firstName +
                ", Last Name: " + lastName +
                ", City: " + city +
                ", State: " + state +
                ", Country: " + country +
                ", Work Authorization: " + workAuthorization +
                ", Employment Type: " + employmentType +
                ", Resume: " + resume +
                ", Profile Photo: " + profilePhoto;
    }
}
