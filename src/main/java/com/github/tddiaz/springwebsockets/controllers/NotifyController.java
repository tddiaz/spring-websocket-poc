package com.github.tddiaz.springwebsockets.controllers;

import com.github.tddiaz.springwebsockets.controllers.data.Notification;
import com.github.tddiaz.springwebsockets.controllers.data.NotifyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NotifyController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/notify")
    public void send(@RequestBody NotifyRequest request, Principal principal) {
        Notification notification = new Notification("From " + principal.getName(), request.getMessage());
        log.info("Notification: {}", notification);

        simpMessagingTemplate.convertAndSendToUser(request.getUser(), "/queue/notifications", notification);
    }
}
