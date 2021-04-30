package com.pe.mosip.Listener;

import com.pe.mosip.bean.Responce_Body;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@Component
public class PushResToOutbound {

    @Qualifier("out_jmsTemplate")
    @Autowired
    static JmsTemplate out_jmsTemplate;

    @Autowired
    static Queue getOutboundQueue;

    public void push(Responce_Body responce_body)
    {
        out_jmsTemplate.convertAndSend(getOutboundQueue,responce_body);
    }

    public static void setGetOutboundQueue(Queue getOutboundQueue) {
        PushResToOutbound.getOutboundQueue = getOutboundQueue;
    }

    public void setOut_jmsTemplate(JmsTemplate out_jmsTemplate) {
        this.out_jmsTemplate = out_jmsTemplate;
    }
}
