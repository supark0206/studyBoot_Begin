package com.example.studyBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Controller 추가
public class HelloController {

    @GetMapping("hello") //hello를 입력받으면 수행됨
    public String hello(Model model){
        // (data html에서 사용될 변수명 , hello!는 실제로 나오는 값)
        model.addAttribute("first", "hello!");
        return "hello"; //templates 에서 'viewResolver'가 hello파일을 찾아서 실행시킴
    }

}
