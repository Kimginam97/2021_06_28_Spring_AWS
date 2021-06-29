package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//컨트롤러를 JSON으로 반환하는 컨트롤러로 만들어줌
public class HelloController {

    @GetMapping("/hello")//HTTP Method인 Get요청을 받을때 사용
    public String hello() {
        return "hello";
    }
}