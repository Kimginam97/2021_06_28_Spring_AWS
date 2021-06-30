package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
// 실제 DB와 매칭될 클래스(Entity 클래스)
@Getter
@NoArgsConstructor//기본 생성자 자동추가
@Entity// 테이블과 링크될 클래스임을 나타냄
public class Posts {
    // 해당 테이블의 PK필드를 나타냄
    @Id
    // PK의 생성 규칙을 나타내며 스프링부트2.0에서는 GenerationType.IDENTITY 옵션을 추가해야 auto_increment가 됨
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //테이블의 칼럼을 나타내며 선언하지 않아도 됨
    @Column(length = 500, nullable = false)//길이가 500,not null
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)//타입은 TEXT,not null
    private String content;

    private String author;

    @Builder//해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
