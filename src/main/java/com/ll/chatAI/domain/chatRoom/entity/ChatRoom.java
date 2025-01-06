package com.ll.chatAI.domain.chatRoom.entity;

import com.ll.chatAI.domain.chatMessage.entity.ChatMessage;
import com.ll.chatAI.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom extends BaseEntity {
    private String name; //채팅방 이름

    @OneToMany
    private List<ChatMessage> chatMessages; //채팅방의 채팅 메시지들

    public ChatRoom(String name) {
        this.name = name;
    }
}
