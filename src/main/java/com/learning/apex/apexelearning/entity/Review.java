package com.learning.apex.apexelearning.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "comment")
    private String comment;


}
