//package com.clone.zoom.handler;
//
//import com.clone.zoom.service.MsgRoom;
//import com.clone.zoom.service.MsgService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.net.Socket;
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//public class MsgController {
//
//    private final MsgService msgService;
//
//    @GetMapping("/chat")
//    public List<MsgRoom> findAllRoom() {
//        return msgService.findAllRoom();
//    }
//
//    @PostMapping("/chat")
//    public MsgRoom createRoom(@RequestParam String name) {
//        return msgService.createRoom(name);
//    }
//}
