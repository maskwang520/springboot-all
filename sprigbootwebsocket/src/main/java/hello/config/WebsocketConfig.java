package hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by maskwang on 2017/10/12 0012.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //客户端接收服务端消息的地址的前缀信息（客户端接受）
        config.enableSimpleBroker("/topic");
        //客户端给服务端发消息的地址的前缀（客户端发送）
        config.setApplicationDestinationPrefixes("/app");
    }
    //这个方法的作用是添加一个服务端点，来接收客户端的连接。并开启SockJS的支持。
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socket").withSockJS();
    }
}
