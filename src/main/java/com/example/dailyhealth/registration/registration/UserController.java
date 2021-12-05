package com.example.dailyhealth.registration.registration;


import com.example.dailyhealth.model.dtos.ProductDto;
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
    public String register() {
//        if (!model.containsAttribute("registrationRequest")) {
//            model.addAttribute("registrationRequest", new RegistrationRequest());
//        }
        return "user/registration";
    }

    @ModelAttribute("registrationRequest")
    public RegistrationRequest request(){
        return new RegistrationRequest();
    }
    @PostMapping("/register")
    public String registerAdd(@Valid RegistrationRequest request, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !request.getPassword().equals(request.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("registrationRequest", request);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationRequest",
                    bindingResult);
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
