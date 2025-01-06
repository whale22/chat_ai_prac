package com.ll.chatAI.domain.chatRoom.entity;

import com.ll.chatAI.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom extends BaseEntity {
    private String name; //채팅방 이름

    public ChatRoom () {
    }
}
