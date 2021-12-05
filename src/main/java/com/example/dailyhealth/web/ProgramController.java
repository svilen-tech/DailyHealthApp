package com.example.dailyhealth.web;

import com.example.dailyhealth.service.CloudinaryService;
import com.example.dailyhealth.service.ProgramService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class ProgramController {

    private ProgramService programService;
    private final CloudinaryService cloudinaryService;

    @GetMapping("/programs/myprograms")
    public String showPrograms(final HttpServletRequest request, Principal principal, Model model) {
        final String currentUser = principal.getName();
        model.addAttribute("allPrograms",programService.allPersonalTrainingProgramByName(currentUser));
        return "exercises/myprograms";
    }

    @GetMapping("/programs/myprograms/{id}")
    public String showProgramsDetails(@PathVariable Long id, Model model){
        model.addAttribute("programDetails",programService.detailsForExercise(id));
        return "exercises/myprogramdetails";
    }

    @DeleteMapping("/programs/myprograms/delete/{id}")
    public String deleteOffer(@PathVariable Long id) {
        programService.deleteOffer(id);
        return "redirect:/programs/myprograms";
    }


}
