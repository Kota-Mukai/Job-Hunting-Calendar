package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.CompanyForm;
import com.example.demo.form.RegistTemplateForm;

@Controller
@RequestMapping("/")
public class RegistTemplateController {

    @GetMapping("regist-new-template")
    public String showRegistForm(
        @ModelAttribute RegistTemplateForm form){

        List<CompanyForm>  companyList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            companyList.add(new CompanyForm());
        }

        form.setCompanyList(companyList);

        return "regist-new-template";
    }

}
