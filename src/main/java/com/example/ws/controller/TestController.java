package com.example.ws.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class TestController {

    @RequestMapping(value = "/hello")
    public String test(Model model) {
        log.info("XXXX");
        model.addAttribute("key", "hello hehe");
        return "index";
    }

    @RequestMapping(value = "/hello1")
    public String test1(Model model) {
        int i = 5 / 0;
        model.addAttribute("key", "hello hehe");
        return "index";
    }


}
