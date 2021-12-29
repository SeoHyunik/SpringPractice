package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    
    @GetMapping("hello") // localhost:8080/hello
    public String hello (Model model) {
        model.addAttribute("data", "hello!!"); // key = data , val = hello!!
        return "hello"; // resources/templates안의 html 파일명과 동일함.
    }
}
