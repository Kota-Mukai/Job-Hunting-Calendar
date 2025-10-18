package com.example.demo.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyForm {

    @Size(min = 1, max = 50, message = "企業名を1文字以上50文字以下で入力してください")
    private String companyName;

    @NotNull(message = "エントリー締切日を入力してください")
    private LocalDateTime entryDeadLine;


}