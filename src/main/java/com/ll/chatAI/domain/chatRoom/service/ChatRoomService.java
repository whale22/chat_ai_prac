package com.ll.chatAI.domain.chatRoom.service;

import com.ll.chatAI.domain.chatRoom.entity.ChatRoom;
import com.ll.chatAI.domain.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom create(String name) {
        ChatRoom chatRoom = ChatRoom.builder()
                .name(name)
                .build();

        chatRoomRepository.save(chatRoom);

        return chatRoom;
    }

    public List<ChatRoom> getAll() {
        return chatRoomRepository.findAll();
    }

    public ChatRoom getChatRoom(Long roomId) {
        return chatRoomRepository.findById(roomId).orElse(null);
    }
}