package com.example.springsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    // ログイン画面のGET用コントローラー
    @GetMapping("/login")
    public String getLogin(Model model){
        // login.htmlへ画面遷移
        return "login/login";
    }

    // ログイン画面のPOST用コントローラー
    @GetMapping("/login")
    public String postLogin(Model model){
        // login.htmlへ画面遷移
        return "login/login";
    }

}
