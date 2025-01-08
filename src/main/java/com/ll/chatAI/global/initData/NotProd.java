package com.ll.chatAI.global.initData;

import com.ll.chatAI.domain.article.entity.Article;
import com.ll.chatAI.domain.article.service.ArticleService;
import com.ll.chatAI.domain.chatMessage.service.ChatMessageService;
import com.ll.chatAI.domain.chatRoom.entity.ChatRoom;
import com.ll.chatAI.domain.chatRoom.service.ChatRoomService;
import com.ll.chatAI.domain.member.entity.Member;
import com.ll.chatAI.domain.member.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {
    @Bean
    public ApplicationRunner initNotProd(ChatRoomService chatRoomService, ChatMessageService chatMessageService, MemberService memberService, ArticleService articleService) {
        return args -> {
            System.out.println("실 개발환경이 아닙니다. 테스트 데이터를 생성합니다.");

            ChatRoom chatRoom1 = chatRoomService.create("Room No.1");
            ChatRoom chatRoom2 = chatRoomService.create("Room No.2");
            ChatRoom chatRoom3 = chatRoomService.create("Room No.3");

            IntStream.rangeClosed(1, 100).forEach(i -> {
                chatMessageService.create(chatRoom1, "홍길동", i + "번째 메세지입니다.");
            });

            Member member1 = memberService.join("user1", "1234").getData();
            Member member2 = memberService.join("user2", "1234").getData();
            Member member3 = memberService.join("user3", "1234").getData();

            Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
            Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();

            Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
            Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();

            System.out.println("Not Prod");
        };
    }
}