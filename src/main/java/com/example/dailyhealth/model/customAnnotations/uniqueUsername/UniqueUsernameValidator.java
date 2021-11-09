package com.example.dailyhealth.model.customAnnotations.uniqueUsername;


import com.example.dailyhealth.registration.appuser.AppUserRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private AppUserRepository userRepository;

    public UniqueUsernameValidator(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepository.findByUsername(value).isEmpty();
    }
}
