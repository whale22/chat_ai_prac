package com.ll.chatAI.domain.chatMessage.controller;

import com.ll.chatAI.domain.chatMessage.dto.RequestCreateMessage;
import com.ll.chatAI.domain.chatMessage.entity.ChatMessage;
import com.ll.chatAI.domain.chatMessage.service.ChatMessageService;
import com.ll.chatAI.domain.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(
        origins = "https://cdpn.io"
)
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
public class ApiV1ChatMessageController {
    private final OpenAiChatModel openAiChatModel;
    private final ChatMessageService chatMessageService;
    private final ChatRoomService chatRoomService;

    @GetMapping("/{chatRoomId}/messages")
    public List<ChatMessage> getChatMessages(@PathVariable Long chatRoomId, @RequestParam long afterChatMessageId) {
        List<ChatMessage> chatMessages = chatMessageService.getAllByChatRoomIdAndAfterId(chatRoomId, afterChatMessageId);
        return chatMessages;
    }

    @PostMapping("/{chatRoomId}/messages")
    public ChatMessage showChatMessages(@PathVariable Long chatRoomId, @RequestBody RequestCreateMessage requestCreateMessage) {
        ChatMessage chatMessage = chatMessageService.create(chatRoomService.getChatRoom(chatRoomId), requestCreateMessage.getWriterName(), requestCreateMessage.getContent());
        return chatMessage;
    }

    @GetMapping("/ai")
    public Map<String, String> chat(@RequestBody String message) {
        Map<String, String> responses = new HashMap<>();

        String openAiResponse = openAiChatModel.call(message);
        responses.put("openai(chatGPT) 응답", openAiResponse);

        return responses;
    }
}
