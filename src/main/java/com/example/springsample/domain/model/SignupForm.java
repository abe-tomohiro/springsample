package com.example.springsample.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SignupForm {

    private String userId;      // ユーザーID

    private String password;    // パスワード

    private String userName;    // ユーザー名

    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthDay;      // 誕生日

    private int age;            // 年齢

    private boolean marriage;   // 結婚ステイタス

}
