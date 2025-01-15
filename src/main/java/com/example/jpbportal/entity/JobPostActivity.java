package com.example.jpbportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobPostActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobPostId;

    @ManyToOne
    @JoinColumn(name = "postedById", referencedColumnName = "user_id")
    private Users postedById;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobLocationId", referencedColumnName = "Id")
    private JobLocation jobLocationId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobCompanyId", referencedColumnName = "Id")
    private JobCompany jobCompanyId;

    @Transient
    private Boolean isActive;

    @Transient
    private Boolean isSaved;

    @Length(max = 10000)
    private String descriptionOfJob;

    private String jobType;

    private String salary;

    private String remote;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postedDate;

    private String jobTitle;

    @Override
    public String toString() {
        return "Job Post Activity: " +
                "Job Post Id: " + jobPostId +
                ", Posted By Id: " + postedById +
                ", Job Location Id: " + jobLocationId +
                ", Job Company Id: " + jobCompanyId +
                ", isActive: " + isActive +
                ", isSaved: " + isSaved +
                ", Description Of Job: " + descriptionOfJob +
                ", Job Type: " + jobType +
                ", Salary: " + salary +
                ", Remote: " + remote +
                ", Posted Date: " + postedDate +
                ", Job Title: " + jobTitle;
    }
}
