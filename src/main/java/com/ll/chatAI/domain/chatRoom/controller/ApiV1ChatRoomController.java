package com.ll.chatAI.domain.chatRoom.controller;

import com.ll.chatAI.domain.chatMessage.service.ChatMessageService;
import com.ll.chatAI.domain.chatRoom.dto.RequestCreateRoom;
import com.ll.chatAI.domain.chatRoom.entity.ChatRoom;
import com.ll.chatAI.domain.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
@CrossOrigin(
        origins = "https://cdpn.io"
)
public class ApiV1ChatRoomController {
    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    @GetMapping
    public List<ChatRoom> getChatRooms() {
        List<ChatRoom> ChatRooms = chatRoomService.getAll();
        return ChatRooms;
    }


    @PostMapping
    public ChatRoom createChatRoom(@RequestBody RequestCreateRoom requestCreateRoom) {
        ChatRoom chatRoom = chatRoomService.create(requestCreateRoom.getName());
        return chatRoom;
    }

}