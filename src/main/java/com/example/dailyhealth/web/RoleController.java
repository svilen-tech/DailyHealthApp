package com.example.dailyhealth.web;

import com.example.dailyhealth.model.dtos.user.RoleChangeDto;
import com.example.dailyhealth.model.dtos.user.UserForAdminDto;
import com.example.dailyhealth.registration.appuser.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RoleController {

    private AppUserService appUserService;

    public RoleController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }


    @ModelAttribute("users")
    public UserForAdminDto allUsers() {
        return new UserForAdminDto();
    }

    @ModelAttribute("usersRole")
    public RoleChangeDto roleChangeDto() {
        return new RoleChangeDto();
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("users", appUserService.returnAllUsers());
        return "admin/admin-page";
    }

    @PostMapping("/admin")
    public String roleChangeNow(@RequestParam(defaultValue = "None") String name, @RequestParam(defaultValue = "None") String role, UserForAdminDto userForAdminDto) {
        System.out.println();

        appUserService.changeRole(name, role);
        return "redirect:/admin";
    }
}
