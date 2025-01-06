package com.ll.chatAI.domain.chatMessage.entity;

import com.ll.chatAI.domain.chatRoom.entity.ChatRoom;
import com.ll.chatAI.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {
    public ChatMessage() {
    }

    private String writerName; //채팅 작성자
    private String content; //채팅 메시지

    @ManyToOne
    private ChatRoom chatRoom; //채팅방
}
