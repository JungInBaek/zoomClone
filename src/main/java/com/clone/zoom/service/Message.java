package com.clone.zoom.service;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Message {

    public enum Type {
        NICKNAME, MESSAGE
    }

    private Type type;
    private String payload;

//    public enum MessageType {
//        ENTER, COMM
//    }
//
//    private MessageType messageType;
//    private String roomId;
//    private String sender;
//    private String message;
}
