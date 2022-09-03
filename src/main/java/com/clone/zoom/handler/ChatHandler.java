package com.clone.zoom.handler;

import com.clone.zoom.service.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {

//    private final MsgService msgService;
    private final ObjectMapper objectMapper;

    private Set<WebSocketSession> sessionList = new HashSet<>();



    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : {}", payload);

        Message parsed = objectMapper.readValue(payload, Message.class);
        log.info("payload = {}", parsed.getPayload());
        switch (parsed.getType()) {
            case MESSAGE:
                for (WebSocketSession webSocketSession : sessionList) {
                    webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(session.getAttributes().get("nickname") + ": " + parsed.getPayload())));
                }
                break;
            case NICKNAME:
                session.getAttributes().put("nickname", parsed.getPayload());
                break;
        }
//        Message msg = objectMapper.readValue(payload, Message.class);
//        MsgRoom room = msgService.findById(msg.getRoomId());
//        room.handleActions(session, msg, msgService);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(session + " 클라이언트 접속 ✅");
        session.getAttributes().put("nickname", "Anonymous");
        sessionList.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " 클라이언트 접속 해제 ❌");
        sessionList.remove(session);
    }
}
