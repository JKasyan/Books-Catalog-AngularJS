package catalog.angularjs.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by evgen on 03.02.16.
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;
    private List<String> messages = new CopyOnWriteArrayList<>();
    private static final Logger logger = Logger.getLogger(MessageController.class);

    @MessageMapping("/message")
    public void received(@Payload String msg, @Headers Map headers) {
        //logger.info("Principal: " + principal);
        logger.info("Received : " + msg);
        logger.info("Headers: " + headers);
        @SuppressWarnings("unchecked")
        Map<String, List<String>> nativeHeaders = (Map<String, List<String>>)headers.get("nativeHeaders");
        logger.info("User: " + nativeHeaders.get("user").get(0));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<String> getAll() {
        return messages;
    }

    @Scheduled(fixedDelay = 5000)
    public void sendMessage(Principal principal) {
        logger.debug("Principal: " + principal);
        simpMessageSendingOperations.convertAndSendToUser(principal.getName(), "/queue/test", "Hello " + principal.getName());
    }
}
