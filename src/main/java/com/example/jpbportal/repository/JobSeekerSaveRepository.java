package com.example.jpbportal.repository;

import com.example.jpbportal.entity.JobPostActivity;
import com.example.jpbportal.entity.JobSeekerProfile;
import com.example.jpbportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {
    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

    Optional<JobSeekerSave> findByUserIdAndJob(JobSeekerProfile userId, JobPostActivity job);
}
