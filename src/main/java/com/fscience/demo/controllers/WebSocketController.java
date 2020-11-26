package com.fscience.demo.controllers;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/backend")
@Component
public class WebSocketController {
    private static Logger logger = LoggerFactory.getLogger(WebSocketController.class);
    @OnOpen
    public void onOpen(Session session) {
        logger.info("OPEN: {}", session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        logger.info("CLOSE: {}", session);
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        logger.info("MESSAGE: {} - {}", message, session.getId());
        session.getBasicRemote().sendText("Hello, I received.");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误: " + session.getId());
        throwable.printStackTrace();
    }
}
