package com.example.dailyhealth.model.customAnnotations.uniqueEmail;


import com.example.dailyhealth.registration.appuser.AppUserRepository;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private AppUserRepository userRepository;

    public UniqueEmailValidator(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepository.findByEmail(value) == null;
    }
}
