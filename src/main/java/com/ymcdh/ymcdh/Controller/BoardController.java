package com.ymcdh.ymcdh.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }
}
