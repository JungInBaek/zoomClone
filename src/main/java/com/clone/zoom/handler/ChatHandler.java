package com.clone.zoom.handler;

import com.clone.zoom.service.Message;
import com.clone.zoom.service.MsgRoom;
import com.clone.zoom.service.MsgService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {

    private final MsgService msgService;
    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : {}", payload);

        session.sendMessage(message);

//        Message msg = objectMapper.readValue(payload, Message.class);
//        MsgRoom room = msgService.findById(msg.getRoomId());
//        room.handleActions(session, msg, msgService);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(session + " 클라이언트 접속 ✅");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " 클라이언트 접속 해제 ❌");
    }
}
