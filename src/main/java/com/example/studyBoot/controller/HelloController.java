package com.example.studyBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Controller 추가
public class HelloController {

    @GetMapping("hello") //hello를 입력받으면 수행됨
    public String hello(Model model){
        // (data html에서 사용될 변수명 , hello!는 실제로 나오는 값)
        model.addAttribute("first", "hello!");
        return "hello"; //templates 에서 'viewResolver'가 hello파일을 찾아서 실행시킴
    }

    @GetMapping("hello-mvc")
    public String helloMvc(
            //RequestParam을 통해 받은 값을 view페이지에 뿌려준다
            @RequestParam(value = "name",required = true)String name
            ,Model m){

        m.addAttribute("name",name);


        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //그냥 바로 문자가 body에 입력되서 출력된다
    public String helloString(@RequestParam("name")String name){
        return "hello" + name;//"hello ~~ "
    }

    @GetMapping("hello-api")
    @ResponseBody //@ResponseBody로 한다면 json으로 반환하는게 기본.
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);//파라미터로 넘어온 name 을 입력
        return hello; //문자가 아닌 객체를 넘김
        //json 방식으로 출력됨
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

