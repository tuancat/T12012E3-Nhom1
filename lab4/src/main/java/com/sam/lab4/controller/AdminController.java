package com.sam.lab4.controller;

import com.sam.lab4.model.User;
import com.sam.lab4.service.UserRoleService;
import com.sam.lab4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @GetMapping("/add-user")
    public String addStudent(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("userRole" , userRoleService.getAllUserRole());
        return "admin/add-user"; //trang html
    }

    //nut lưu giữ liệu
    @PostMapping("/save-user")
    public String saveEmployee (@Valid @ModelAttribute("student") User user, BindingResult result, ModelMap modelMap)
    {
        userService.addUser(user);
        return "redirect:/user/list"; //trang html
    }
    @GetMapping("list-user")
    public String listUser(Model model){
        model.addAttribute("list",userService.getAllUser());
        return "/admin/list-user"; //t
    }
}
