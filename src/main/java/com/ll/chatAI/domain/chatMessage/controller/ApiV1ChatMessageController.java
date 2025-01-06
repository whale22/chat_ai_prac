package com.ll.chatAI.domain.chatMessage.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/v1/chat/rooms")
@RestController
public class ApiV1ChatMessageController {
    private final OpenAiChatModel openAiChatModel;

    @GetMapping("/{roomId}/messages")
    public String getChatMessages(@PathVariable Long roomId, @RequestParam long afterChatMessageId) {

        return roomId + "번 채팅방의 메시지 조회 완료 / id :" + afterChatMessageId;
    }

    @PostMapping("{roomId}/messages")
    public String showChatMessages(@PathVariable Long chatRoomId) {
        return chatRoomId + "번 채팅방 메시지 조회 완료";
    }



    public ApiV1ChatMessageController(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    @GetMapping("/ai")
    public Map<String, String> chat(@RequestBody String message) {
        Map<String, String> responses = new HashMap<>();

        String openAiResponse = openAiChatModel.call(message);
        responses.put("openai(chatGPT) 응답", openAiResponse);

        return responses;
    }
}
