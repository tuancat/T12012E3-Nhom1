package com.sam.lab4.service;

import com.sam.lab4.model.Category;
import com.sam.lab4.model.Product;
import com.sam.lab4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(String name, String description, float price, MultipartFile multipartFile, Category category) {
        Product s = new Product();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            s.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        s.setName(name);

        s.setDescription(description);
        s.setPrice(price);
        s.setCategory(category);

        productRepository.save(s);
    }
}
