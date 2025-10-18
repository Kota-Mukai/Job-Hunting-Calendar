package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.RegistTemplateForm;

@Controller
@RequestMapping("/")
public class RegistTemplateController {

    @GetMapping("regist-new-template")
    public String showRegistForm(RegistTemplateForm form){

        return "regist-new-template";
    }

}
