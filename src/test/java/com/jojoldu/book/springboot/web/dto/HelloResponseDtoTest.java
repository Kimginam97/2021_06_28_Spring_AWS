package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬북_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        //assertThat은 assertj라는 테스트 검증 라이브러리의 검증 메소드,메소드체이닝이 지원
        assertThat(dto.getName()).isEqualTo(name);//isEqualTo는 assertj의 동등 메소드,값이 비교해 같을 때만 성공
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
