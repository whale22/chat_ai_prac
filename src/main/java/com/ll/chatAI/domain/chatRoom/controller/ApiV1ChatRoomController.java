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

}
