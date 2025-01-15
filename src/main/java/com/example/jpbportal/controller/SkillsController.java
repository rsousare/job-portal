package com.example.jpbportal.controller;

import com.example.jpbportal.entity.Skills;
import com.example.jpbportal.repository.UsersRepository;
import com.example.jpbportal.services.JobSeekerProfileService;
import com.example.jpbportal.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final SkillsService skillsService;
    private final UsersRepository usersRepository;
    private final JobSeekerProfileService jobSeekerProfileService;

    @Autowired
    public SkillsController(SkillsService skillsService, UsersRepository usersRepository, JobSeekerProfileService jobSeekerProfileService) {
        this.skillsService = skillsService;
        this.usersRepository = usersRepository;
        this.jobSeekerProfileService = jobSeekerProfileService;
    }


//    @PostMapping("/remove-skill")
//    public String removeSkill(@RequestParam("skillId") int skillId, Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            Users user = usersRepository.findByEmail(authentication.getName()).orElseThrow(() ->
//                    new UsernameNotFoundException("User not found"));
//            Optional<JobSeekerProfile> seekerProfile = jobSeekerProfileService.getOne(user.getUserId());
//            if (seekerProfile.isPresent()) {
//                JobSeekerProfile jobSeekerProfile = seekerProfile.get();
//                List<Skills> skills = jobSeekerProfile.getSkills();
//                skills.removeIf(skill -> skill.getId().equals(skillId));
//
//                jobSeekerProfile.setSkills(skills);
//                jobSeekerProfileService.addNew(jobSeekerProfile);
//            }
//        }
//        return "job-seeker-profile";
//    }

    @PostMapping("/remove-skill")
    public String getJobSeekerProfile(Model model) {
        List<Skills> skills = skillsService.findAll();
        if (skills == null) {
            skills = new ArrayList<>();
        }
        model.addAttribute("skills", skills);
        return "job-seeker-profile";
    }
}
