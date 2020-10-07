package com.example.springsample.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {

    // 必須入力＋メールアドレス形式
    @NotBlank(message = "{require_check}")
    @Email(message = "{email_check")
    private String userId;      // ユーザーID

    // 必須入力、文字列長：4-100桁まで、半角英数字のみ
    @NotBlank(message = "{require_check}")
    @Size(min = 4, max = 100, message = "{length_check}")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message = "{pattern_check}")
    private String password;    // パスワード

    // 必須入力
    @NotBlank(message = "{require_check}")
    private String userName;    // ユーザー名

    // 必須入力＋日付形式
    @NotNull(message = "{require_check}")
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;      // 誕生日

    // 値が20-100まで
    @Min(value = 20, message = "{min_check}")
    @Max(value = 100, message = "{max_check}")
    private int age;            // 年齢

    // falseのみ可能
    @AssertFalse(message = "{false_check}")
    private boolean marriage;   // 結婚ステイタス

}
