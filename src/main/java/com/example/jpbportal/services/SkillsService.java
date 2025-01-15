package com.example.jpbportal.services;

import com.example.jpbportal.entity.Skills;
import com.example.jpbportal.repository.SkillsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {

    private final SkillsRepository skillsRepository;

    public SkillsService(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    public Optional<Skills> getOne(Integer id) {
        return skillsRepository.findById(id);
    }

    public void deleteById(int id) {
        skillsRepository.deleteById(id);
    }

    public List<Skills> findAll() {
        return skillsRepository.findAll();
    }
}
