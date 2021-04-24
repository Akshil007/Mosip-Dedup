package com.pe.mosip.Controller;

import com.pe.mosip.Listener.RequestConsumer;
import com.pe.mosip.bean.Request_Body;
import com.pe.mosip.bean.Responce_Body;
import com.pe.mosip.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.jms.Queue;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;

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
    public List<Responce_Body> getNextResponce()
    {
        OutputService outputService = new OutputService();
        List<Responce_Body> list = outputService.getRecords(5);
        if(!list.isEmpty())
            return list;
        else
        {
            Responce_Body responce_body = new Responce_Body();
            responce_body.setFailureReason("No responce is pending");
            list.add(responce_body);
            return list;
        }
    }

}
