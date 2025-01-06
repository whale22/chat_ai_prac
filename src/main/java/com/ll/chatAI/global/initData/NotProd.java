package com.ll.chatAI.global.initData;

import com.ll.chatAI.domain.chatMessage.service.ChatMessageService;
import com.ll.chatAI.domain.chatRoom.entity.ChatRoom;
import com.ll.chatAI.domain.chatRoom.service.ChatRoomService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {
    @Bean
    public ApplicationRunner initNotProd(ChatRoomService chatRoomService, ChatMessageService chatMessageService) {
        return args -> {
            System.out.println("실 개발환경이 아닙니다. 테스트 데이터를 생성합니다.");

            ChatRoom chatRoom1 = chatRoomService.create("Room No.1");
            ChatRoom chatRoom2 = chatRoomService.create("Room No.2");
            ChatRoom chatRoom3 = chatRoomService.create("Room No.3");

            IntStream.rangeClosed(1, 100).forEach(i -> {
                chatMessageService.create(chatRoom1, "홍길동", i + "번째 메세지입니다.");
            });
            System.out.println("Not Prod");
        };
    }
}