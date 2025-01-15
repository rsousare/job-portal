package com.example.jpbportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String experienceLevel;
    private String yearsOfExperience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_seeker_profile")
    private JobSeekerProfile jobSeekerProfile;

    @Override
    public String toString() {
        return "Skills: " +
                "Id: " + id +
                ", Name: " + name +
                ", Experience Level: " + experienceLevel +
                ", Years Of Experience: " + yearsOfExperience +
                ", Job Seeker Profile: " + jobSeekerProfile;
    }
}
