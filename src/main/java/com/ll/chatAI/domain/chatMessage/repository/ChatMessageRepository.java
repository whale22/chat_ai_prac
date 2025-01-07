package com.ll.chatAI.domain.chatMessage.repository;

import com.ll.chatAI.domain.chatMessage.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatRoomIdAndIdAfter(Long roomId, Long afterChatMessageId);
    List<ChatMessage> findByChatRoom_id(Long chatRoomId);

}
