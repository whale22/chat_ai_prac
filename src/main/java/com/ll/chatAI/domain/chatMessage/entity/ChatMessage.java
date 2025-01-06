package com.ll.chatAI.domain.chatMessage.entity;

import com.ll.chatAI.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {
    public ChatMessage() {
    }
}
