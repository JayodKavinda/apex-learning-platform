package com.learning.apex.apexelearning.controller;

import com.learning.apex.apexelearning.entity.Instructor;
import com.learning.apex.apexelearning.entity.Role;
import com.learning.apex.apexelearning.entity.Student;
import com.learning.apex.apexelearning.payload.InstructorSignUpDto;
import com.learning.apex.apexelearning.payload.JWTAuthResponse;
import com.learning.apex.apexelearning.payload.LoginDto;
import com.learning.apex.apexelearning.payload.StudentSignUpDto;
import com.learning.apex.apexelearning.repository.InstructorRepository;
import com.learning.apex.apexelearning.repository.RoleRepository;
import com.learning.apex.apexelearning.repository.StudentRepository;
import com.learning.apex.apexelearning.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@Tag(name = "Register and Signin")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Operation(summary = "REST API to Register instructor to app")
    @PostMapping("/signin/in")
    public ResponseEntity<JWTAuthResponse> authenticateInstructor(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }

    @Operation(summary = "REST API to  Signup instructor to app")
    @PostMapping("/signup/in")
    public ResponseEntity<?> registerInstructor(@RequestBody InstructorSignUpDto signUpDto){

        // add check for username exists in a DB
        if(instructorRepository.existsByUserName(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(instructorRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Instructor instructor = new Instructor();
        instructor.setFirstName(signUpDto.getFirstName());
        instructor.setLastName(signUpDto.getLastName());
        instructor.setUserName(signUpDto.getUsername());
        instructor.setEmail(signUpDto.getEmail());
        instructor.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role role = roleRepository.findByRoleName("ROLE_INSTRUCTOR").get();
        instructor.setRole(role);

        instructorRepository.save(instructor);

        return new ResponseEntity<>("Instructor registered successfully", HttpStatus.OK);

    }

    //Student

    @Operation(summary = "REST API to Register students to app")
    @PostMapping("/signin/stu")
    public ResponseEntity<JWTAuthResponse> authenticateStudent(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // get token form tokenProvider
        String token = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTAuthResponse(token));
    }


    @Operation(summary = "REST API to  Signup students to app")
    @PostMapping("/signup/stu")
    public ResponseEntity<?> registerStudent(@RequestBody StudentSignUpDto signUpDto){

        // add check for username exists in a DB
        if(studentRepository.existsByUserName(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(studentRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Student student = new Student();
        student.setFirstName(signUpDto.getFirstName());
        student.setLastName(signUpDto.getLastName());
        student.setUserName(signUpDto.getUsername());
        student.setEmail(signUpDto.getEmail());
        student.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role role = roleRepository.findByRoleName("ROLE_STUDENT").get();
        student.setRole(role);

        studentRepository.save(student);

        return new ResponseEntity<>("Student registered successfully", HttpStatus.OK);

    }
}
