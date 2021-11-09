package com.example.dailyhealth.registration.registration;


import com.example.dailyhealth.model.customAnnotations.uniqueUsername.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {


    @NotNull
    @Size(min = 3,max=10)
    @UniqueUsername
    private String username;
    @Size(min = 3,max=10)
    private String firstName;
    @NotNull
    @Size(min = 3,max=10)
    private String lastName;
    @Email
    @NotNull
    private String email;
    @Size(min = 5,max=10)
    @NotNull
    private String password;
    @Size(min = 5,max=10)
    @NotNull
    private String confirmPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
