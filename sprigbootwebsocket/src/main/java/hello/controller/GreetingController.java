package hello.controller;

import hello.messaage.Greeting;
import hello.messaage.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by maskwang on 2017/10/12 0012.
 */
@Controller
public class GreetingController {
    @MessageMapping("/hello")
    //转发给服务端
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
