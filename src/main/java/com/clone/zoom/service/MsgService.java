//package com.clone.zoom.service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class MsgService {
//
//    private final ObjectMapper objectMapper;
//
//    //  TODO : Map -> DB로 전환
//    private Map<String, MsgRoom> msgRooms;
//
//    @PostConstruct
//    private void init() {
//        msgRooms = new LinkedHashMap<>();
//    }
//
//    public List<MsgRoom> findAllRoom() {
//        return new ArrayList<>(msgRooms.values());
//    }
//
//    public MsgRoom findById(String roomId) {
//        return msgRooms.get(roomId);
//    }
//
//    public MsgRoom createRoom(String name) {
//        String roomId = name;
//        MsgRoom msgRoom = MsgRoom.builder().roomId(roomId).build();
//        msgRooms.put(name, msgRoom);
//
//        return msgRoom;
//    }
//
//    public <T> void sendMessage(WebSocketSession session, T message) {
//        try {
//            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        }
//    }
//}
