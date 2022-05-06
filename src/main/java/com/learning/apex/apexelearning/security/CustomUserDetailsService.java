package com.learning.apex.apexelearning.security;


import com.learning.apex.apexelearning.entity.Instructor;
import com.learning.apex.apexelearning.entity.Role;
import com.learning.apex.apexelearning.entity.Student;
import com.learning.apex.apexelearning.repository.InstructorRepository;
import com.learning.apex.apexelearning.repository.StudentRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private InstructorRepository instructorRepository;
    private StudentRepository studentRepository;

    public CustomUserDetailsService(InstructorRepository instructorRepository, StudentRepository studentRepository) {
        this.instructorRepository = instructorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//        Instructor user = instructorRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("Instructor not found with username or email:" + usernameOrEmail));
        Role tempRole;
        String tempEmail;
        String tempPassword;
        try{
            Student student = studentRepository.findByUserNameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow();
            tempEmail=student.getEmail();
            tempPassword= student.getPassword();
            tempRole= student.getRole();
        }catch (Exception e){
            try {
                Instructor instructor = instructorRepository.findByUserNameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow();
                tempEmail=instructor.getEmail();
                tempPassword= instructor.getPassword();
                tempRole= instructor.getRole();
            }catch (Exception e2){
                throw new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail);
            }
        }


        Set<Role> roles = new HashSet<>();
        roles.add(tempRole);
        return new org.springframework.security.core.userdetails.User(tempEmail,
                tempPassword, mapRolesToAuthorities(roles));
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
