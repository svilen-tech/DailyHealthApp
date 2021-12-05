package com.example.dailyhealth.registration.appuser;


import com.example.dailyhealth.model.dtos.user.UserForAdminDto;
import com.example.dailyhealth.registration.update.MobileUser;
import com.example.dailyhealth.registration.registration.token.ConfirmationToken;
import com.example.dailyhealth.registration.registration.token.ConfirmationTokenService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppUserService implements UserDetailsService {


    private final AppUserRepository appUserRepository;
    private static final String userException = "user with username %s not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public AppUserService(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.appUserRepository = appUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        AppUser appUser = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(userException, username)));


        return mapToUserDetails(appUser);
    }

    private static UserDetails mapToUserDetails(AppUser userEntity) {

        // GrantedAuthority is the representation of a user role in the
        // spring world. SimpleGrantedAuthority is an implementation of GrantedAuthority
        // which spring provides for our convenience.
        // Our representation of role is UserRoleEntity
        List<GrantedAuthority> auhtorities =
                userEntity.
                        getAuthorities().
                        stream().
                        map(r -> new SimpleGrantedAuthority("ROLE_" + r.getAuthority())).
                        collect(Collectors.toList());


        // User is the spring implementation of UserDetails interface.
        return new MobileUser(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEnabled(),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isAccountNonLocked(),
                auhtorities
        );
    }

    public String signUpUser(AppUser appUser) {

        boolean userExists = appUserRepository.
                findByEmail(appUser.getEmail()).
                isPresent();

        if (userExists) {
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser);

        confirmationTokenService.saveConfirmationToken(confirmationToken);


        return token;

    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public void changeRole(String username,String role){
        Optional<AppUser> byUsername = appUserRepository.findByUsername(username);
        if (byUsername.isEmpty()){
            throw new IllegalStateException("User not found");
        }
        List<String> collect = Arrays.asList(AppUserRole.values()).stream().map(Enum::toString).collect(Collectors.toList());
        if (!collect.contains(role)){
            throw new IllegalStateException("Role not found");
        }


        byUsername.get().setAppUserRole(AppUserRole.valueOf(role));
        appUserRepository.save(byUsername.get());

    }



    public List<UserForAdminDto> returnAllUsers(){
        List<AppUser> all = appUserRepository.findAll();
        List<UserForAdminDto> dtos = new ArrayList<>();
        for (int i = 0; i <all.size() ; i++) {
            dtos.add(new UserForAdminDto().setUsername(all.get(i).getUsername())
                    .setRole(all.get(i).getAppUserRole().name()));
        }
        return dtos;
    }
}
