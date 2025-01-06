package com.ll.chatAI.domain.chatRoom.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat/rooms")
public class ApiV1ChatRoomController {
    @GetMapping
    public String showChatRooms() {
        return "채팅방 목록 조회 완료";
    }

    @PostMapping
    public String createChatRoom() {
        return "채팅방 생성 완료";
    }

    @GetMapping("/{roomId}")
    public String showChatRoom(@PathVariable Long roomId) {
        return roomId + "번 채팅방 조회 완료";
    }

    @GetMapping("{chatRoomId}/messages")
    public String showChatMessages(@PathVariable Long chatRoomId, @RequestParam String afterChatMessageId) {
        return chatRoomId + "번 채팅방의 " + afterChatMessageId + "번 메시지 조회 완료";
    }

    @PostMapping("{chatRoomId}/messages")
    public String showChatMessages(@PathVariable Long chatRoomId) {
        return chatRoomId + "번 채팅방의 메시지 조회 완료";
    }
}
