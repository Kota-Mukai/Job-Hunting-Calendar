package com.example.demo.form;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistTemplateForm {

    @Size(min = 1, max = 50, message = "登録するテンプレートの名前を1文字以上50文字以下で入力してください")
    private String templateName;

    @Size(min = 1, max = 250, message = "登録するテンプレートの説明を1文字以上250文字以下で入力してください")
    private String description;    


}