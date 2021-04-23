package com.pe.mosip.Listener;

import com.pe.mosip.bean.Responce_Body;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;


@Component
public class ResponceConsumer {

    ArrayDeque<Responce_Body> list = new ArrayDeque<>();
    @JmsListener(destination = "outbound.queue")
    public void getResponce(Responce_Body responce_body){
        list.add(responce_body);
    }

    public ArrayDeque<Responce_Body> getList() {
        return list;
    }

    public void setList(ArrayDeque<Responce_Body> list) {
        this.list = list;
    }
}
