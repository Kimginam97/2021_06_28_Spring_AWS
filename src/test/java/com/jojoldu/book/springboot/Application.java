package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//앞으로 만들 프로젝트의 메인 클래스
@SpringBootApplication//스프링 부트의 자동 설정,스프링 Bean읽기와 생성을 모두 자동을 설정
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run으로 내장 WAS를 실행(내부)
        SpringApplication.run(Application.class,args);
    }
}
