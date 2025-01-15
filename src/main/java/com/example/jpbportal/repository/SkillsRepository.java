package com.example.jpbportal.repository;

import com.example.jpbportal.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
    void deleteById(int id);
}
