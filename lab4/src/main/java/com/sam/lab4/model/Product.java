package com.sam.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tự động tăng
    private long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "id_category") //("id_class: phải viết theo chuẩn của MySQL)
    private Category category;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;
    private float price;

}
