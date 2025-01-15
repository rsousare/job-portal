package com.example.jpbportal.services;

import com.example.jpbportal.entity.JobPostActivity;
import com.example.jpbportal.entity.JobSeekerProfile;
import com.example.jpbportal.entity.JobSeekerSave;
import com.example.jpbportal.repository.JobSeekerSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerSaveService {
    private final JobSeekerSaveRepository jobSeekerSaveRepository;


    @Autowired
    public JobSeekerSaveService(JobSeekerSaveRepository jobSeekerSaveRepository) {
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }

    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId) {
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getCandidates(JobPostActivity job) {
        return jobSeekerSaveRepository.findByJob(job);
    }


    public void addNew(JobSeekerSave jobSeekerSave) {
        Optional<JobSeekerSave> existingSave = jobSeekerSaveRepository.findByUserIdAndJob(jobSeekerSave.getUserId(), jobSeekerSave.getJob());
        if (existingSave.isPresent()) {
            throw new RuntimeException("You have already saved this job.");
        }
        jobSeekerSaveRepository.save(jobSeekerSave);
    }
}
