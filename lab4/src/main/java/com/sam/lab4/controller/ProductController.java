package com.sam.lab4.controller;

import com.sam.lab4.model.Category;
import com.sam.lab4.model.Product;
import com.sam.lab4.service.CategoryService;
import com.sam.lab4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/list-product")
    public String list(Model model)
    {
        model.addAttribute("list",productService.getAllProduct());
        model.addAttribute("listsiteClass",categoryService.getCategoryList());

        return "/student/list-student"; //trang html
    }

    //add student
    @GetMapping("/add-product")
    public String addStudent( Model model)
    {
        model.addAttribute("student", new Product());
        model.addAttribute("listsiteClass",categoryService.getCategoryList());
        return "product/add-product"; //trang html
    }

    //nut lưu giữ liệu
    @PostMapping("/save-product")
    public String saveProduct (@RequestParam("name") String name, @RequestParam("des") String description, @RequestParam("price") float price, @RequestParam(name = "file") MultipartFile multipartFile, @RequestParam("category") Category category, ModelMap modelMap)
    {
        productService.addProduct(name,description,price, multipartFile,category);
        return "redirect:/product/list-product";//trang html
    }
}
