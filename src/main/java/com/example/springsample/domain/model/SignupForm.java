package com.example.springsample.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {

    // 必須入力＋メールアドレス形式
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    @Email(groups = ValidGroup2.class, message = "{email_check}")
    private String userId;      // ユーザーID

    // 必須入力、文字列長：4-100桁まで、半角英数字のみ
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    @Size(groups = ValidGroup2.class, min = 4, max = 100, message = "{length_check}")
    @Pattern(groups = ValidGroup3.class, regexp="^[a-zA-Z0-9]+$", message = "{pattern_check}")
    private String password;    // パスワード

    // 必須入力
    @NotBlank(groups = ValidGroup1.class, message = "{require_check}")
    private String userName;    // ユーザー名

    // 必須入力＋日付形式
    @NotNull(groups = ValidGroup1.class, message = "{require_check}")
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;      // 誕生日

    // 値が20-100まで
    @NotNull(groups = ValidGroup1.class, message = "{require_check}")
    @Min(groups = ValidGroup2.class, value = 20, message = "{min_check}")
    @Max(groups = ValidGroup2.class, value = 100, message = "{max_check}")
    private int age;            // 年齢

    // falseのみ可能
    @AssertFalse(groups = ValidGroup2.class, message = "{false_check}")
    private boolean marriage;   // 結婚ステイタス

}
