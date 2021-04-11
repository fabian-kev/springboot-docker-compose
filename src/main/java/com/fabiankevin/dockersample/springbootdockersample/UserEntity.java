package com.fabiankevin.dockersample.springbootdockersample;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "CR_USER")
@Entity(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
}
