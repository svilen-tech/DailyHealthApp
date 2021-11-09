package com.example.dailyhealth.registration.registration;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private RegistrationService registrationService;

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("registrationRequest")) {
            model.addAttribute("registrationRequest", new RegistrationRequest());
        }
        return "user/registration";
    }

    @PostMapping("/register")
    public String registerAdd(@Valid RegistrationRequest request, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        //ToDo: Connect redirected attributes to front-end to show errors
        if (bindingResult.hasErrors() || !request.getPassword().equals(request.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegistrationDto", request);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.request", bindingResult);
            return "redirect:/users/register";
        }
        registrationService.register(request);
        return "user/checkemail";
    }


    @GetMapping(path = "/register/confirm")
    public String confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return "user/successfulConfirmation";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "user/login";
    }


}
