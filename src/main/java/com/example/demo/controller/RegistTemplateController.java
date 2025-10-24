package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("regist-new-template")
    public String registTemplate(
            @Validated @ModelAttribute RegistTemplateForm form,
            BindingResult result){
        
        if(result.hasErrors()){
            return "regist-new-template";
        }

        return "confirm-regist-template";

    }

    @PostMapping("regist-new-template-ret")
    public String registTemplateRet(    
            @ModelAttribute RegistTemplateForm form){
        
        return "regist-new-template";
        
    }

    @PostMapping("confirm-regist-template")
    public String confirmRegistTemplate(
            @Validated @ModelAttribute RegistTemplateForm form,
            BindingResult result, 
            RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            return "regist-new-template";
        }

        redirectAttributes.addFlashAttribute("msg", "新規テンプレート登録完了");

        System.out.println(form.getTemplateName());
        System.out.println(form.getDescription());

        for (int i=0; i<form.getCompanyList().size(); i++){
            CompanyForm company = form.getCompanyList().get(i);

            System.out.println(company.getCompanyName());
            System.out.println(company.getEntryDeadLine());
        }

        return "redirect:/complete";

    }

}
