package de.itcoops.monitoring.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@EnableWebSocketMessageBroker
@Configuration
@Slf4j
class WebSocketConfiguration 
  implements WebSocketMessageBrokerConfigurer
{
  
  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    log.info("Enable Stomp Endpoint");
    registry.addEndpoint("/notifications").withSockJS();
  }

  /**
   * No InBound Channel Configuration (don't want incoming messages)
   */
  @Override
  public void configureClientInboundChannel(ChannelRegistration registraion) {
  }

  /**
   * configure outbount channels
   * minimum poolsize 4
   * max are 10
   */
  @Override
  public void configureClientOutboundChannel(ChannelRegistration registration) {
    log.info("configure Client outbound Channels");
    registration.taskExecutor().corePoolSize(4).maxPoolSize(10);
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/queue/", "/topic/");
    registry.setApplicationDestinationPrefixes("/app");
  }
}