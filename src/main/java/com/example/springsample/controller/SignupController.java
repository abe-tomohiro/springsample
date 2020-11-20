package com.example.springsample.controller;

import com.example.springsample.domain.model.GroupOrder;
import com.example.springsample.domain.model.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("SpringMVCViewInspection")
@Controller
public class SignupController {

    // ラジオボタンの実装
    private Map<String, String> radioMarriage;
    // ラジオボタンの初期化
    private Map<String, String> initRadioMarrige(){
        Map<String, String> radio = new LinkedHashMap<>();
        // 既婚、未婚をMapに格納
        radio.put("既婚", "true");
        radio.put("未婚", "false");

        return radio;
    }

    // ユーザー登録画面のGET用Mapping
    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form, Model model){
        // ラジオボタン初期化
        radioMarriage = initRadioMarrige();
        // ラジオボタン用のMapをModelに登録
        model.addAttribute("radioMarriage", radioMarriage);
        // signup.htmlへ画面遷移
        return "login/signup";
    }

    // ユーザー登録画面のPOST用コントローラー
    // データバインド結果の受け取り
    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            // GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻る
            return getSignUp(form, model);
        }
        // formの中身をコンソールに出力して確認
        System.out.println(form);

        // login.htmlへリダイレクト
        return "redirect:/login";
    }
}
