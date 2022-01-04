package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") // localhost:8080/hello
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // key = data , val = hello!!
        return "hello"; // resources/templates안의 html 파일명과 동일함.
    }

    @GetMapping("hello-mvc") // localhost:8080/hello
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

}
