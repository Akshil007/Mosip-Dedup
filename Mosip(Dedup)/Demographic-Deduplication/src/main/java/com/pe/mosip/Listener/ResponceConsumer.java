package com.pe.mosip.Listener;

import com.pe.mosip.bean.Responce_Body;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;


@Component
public class ResponceConsumer {

    public static ArrayDeque<Responce_Body> list = new ArrayDeque<>();
    @JmsListener(destination = "outbound.queue",containerFactory = "out_jmsListenerContainerFactory")
    public void getResponce(Responce_Body responce_body){
        list.add(responce_body);
        System.out.println("Output list size:"+list.size());
    }

    public static ArrayDeque<Responce_Body> getList() {
        return list;
    }

}
