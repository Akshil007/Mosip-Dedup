package com.pe.mosip.Listener;

import com.pe.mosip.bean.Responce_Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@Component
public class PushResToOutbound {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue getOutboundQueue;

    public void push(Responce_Body responce_body)
    {
        System.out.println(responce_body.toString());
        System.out.println(getOutboundQueue);
        //jmsTemplate.convertAndSend(getOutboundQueue,responce_body);
    }
}
