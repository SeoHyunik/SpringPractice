package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // localhost:8080/hello
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // key = data , val = hello!!
        return "hello"; // resources/templates안의 html 파일명과 동일함.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API
    @GetMapping("hello-string")
    @ResponseBody
    public String helloMvc(@RequestParam("name") String name) {
        return "hello" + name; // hello {name} 문자가 그대로 넘어간다.
    }

    // API
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) { // json 방식의 처리
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }// helloApi

    static class Hello {
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}
