package com.sam.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ssoid", unique = true, nullable = false)
    private String ssoId;
    private String fulllName;
    private String password;
    private String email;
    @NotEmpty
    @ManyToMany
    @JoinTable(name="userrolemapping", joinColumns = {@JoinColumn(name="USER_ID")}, inverseJoinColumns = {@JoinColumn(name="ROLE_ID")})
    private Set<UserRole> userRoleSet;
}
