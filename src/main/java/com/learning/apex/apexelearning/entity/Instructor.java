package com.learning.apex.apexelearning.entity;

import jdk.jfr.Enabled;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Enabled
@Table(name = "instructors",uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Entity
@Data
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", nullable = false)
    String userName;
    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(name = "email", nullable = false)
    String email;

    private String password;

    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})  //dont apply cascade remove
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    InstructorDetails instructorDetails;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "instructor", cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})  //dont apply cascade remove
    private List<Course> courses;


}
