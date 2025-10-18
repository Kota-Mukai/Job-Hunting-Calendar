package com.example.demo.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CompanyForm {

    @Size(min = 1, max = 50, message = "企業名を1文字以上50文字以下で入力してください")
    private String companyName;

    @NotNull
    private LocalDateTime entryDeadLine;

}