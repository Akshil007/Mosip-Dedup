package com.pe.mosip.Controller;

import com.pe.mosip.Application;
import com.pe.mosip.Listener.RequestConsumer;
import com.pe.mosip.Listener.ResponceConsumer;
import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.bean.Request_Body;
import com.pe.mosip.bean.Responce_Body;
import com.pe.mosip.service.Compare_Table_Service;
import com.pe.mosip.service.Main_Table_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.jms.Queue;
import java.io.IOException;
import java.util.ArrayDeque;

@RequestMapping("api/demo")
@RestController
public class DemoController {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue getInboundQueue;

    @PostMapping(path = "/request")
    public String demo_main(@RequestBody Request_Body request_body) throws IOException, SAXException {
        System.out.println(getInboundQueue);
        jmsTemplate.convertAndSend(getInboundQueue, request_body);
        return "Request Successfully Queued in inbound queue";
    }

    @GetMapping(path = "/get_responce")
    public Responce_Body getNextResponce()
    {
        RequestConsumer requestConsumer=new RequestConsumer();
        ArrayDeque<Responce_Body> list = requestConsumer.getList();
        Responce_Body responce_body = list.peek();
        list.poll();
        return responce_body;
    }

}
