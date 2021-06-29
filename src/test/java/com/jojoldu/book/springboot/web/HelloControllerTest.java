package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//테스트 진행시 JUnit에 내장된 실행자 외에 다른 실행자를 실행 SpringRunner라는 스프링 실행자를 사용
@RunWith(SpringRunner.class)
//Web(Spring Mvc)에 집중할수 있는 어노테이션, 컨트롤러를 사용하기 위해 사용
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    //스프링이 관리하는 빈을 주입
    @Autowired
    //웹API를 테스트할때 사용,HTTP에 대한 API테스트 가능
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws  Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))//HTTP Get요청
                .andExpect(status().isOk())//HTTP header의 Status를 검증 200인지를 검증
                .andExpect(content().string(hello));//응답 본문의 내용을 검증,Controller에서 hello를 리턴하기에 값이 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name).param("amount",String.valueOf(amount)))//APT테스트시 요청 파라미터를 설정,값은 String만 허용,숫자/날짜는 문자열로 변경해야함
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))//jsonPath는 응답값을 필드별로 검증할수있는메소드,$를 기준으로 필드명을 명시
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}