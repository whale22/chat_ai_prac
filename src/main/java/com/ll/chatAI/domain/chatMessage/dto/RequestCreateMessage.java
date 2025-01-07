package com.ll.chatAI.domain.chatMessage.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RequestCreateMessage {
    private String writerName;
    private String content;
}