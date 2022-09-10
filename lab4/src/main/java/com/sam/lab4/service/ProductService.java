package com.sam.lab4.service;

import com.sam.lab4.model.Category;
import com.sam.lab4.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();


    public void addProduct(String name, String description, float price, MultipartFile multipartFile, Category category);

}
