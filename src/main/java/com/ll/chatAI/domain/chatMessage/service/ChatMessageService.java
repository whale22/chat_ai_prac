package com.ll.chatAI.domain.chatMessage.service;

import com.ll.chatAI.domain.chatMessage.entity.ChatMessage;
import com.ll.chatAI.domain.chatMessage.repository.ChatMessageRepository;
import com.ll.chatAI.domain.chatRoom.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessage create(ChatRoom chatRoom, String writerName, String content) {
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .writerName(writerName)
                .content(content)
                .build();

        chatMessageRepository.save(chatMessage);

        return chatMessage;
    }
}
