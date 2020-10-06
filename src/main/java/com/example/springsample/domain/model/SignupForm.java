package com.example.springsample.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {

    // 必須入力＋メールアドレス形式
    @NotBlank
    @Email
    private String userId;      // ユーザーID

    // 必須入力、文字列長：4-100桁まで、半角英数字のみ
    @NotBlank
    @Size(min = 4, max = 100)
    @Pattern(regexp="^[a-zA-Z0-9]+$")
    private String password;    // パスワード

    // 必須入力
    @NotBlank
    private String userName;    // ユーザー名

    // 必須入力＋日付形式
    @NotNull
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;      // 誕生日

    // 値が20-100まで
    @Min(20)
    @Max(100)
    private int age;            // 年齢

    // falseのみ可能
    @AssertFalse
    private boolean marriage;   // 結婚ステイタス

}
