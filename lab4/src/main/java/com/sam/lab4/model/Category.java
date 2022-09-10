package com.sam.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tự động tăng
    private Long id;
    @Column(name="name", nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

}
