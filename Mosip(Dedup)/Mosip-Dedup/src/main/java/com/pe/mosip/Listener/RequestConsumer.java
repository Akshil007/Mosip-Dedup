package com.pe.mosip.Listener;

import com.pe.mosip.bean.Request_Body;
import com.pe.mosip.bean.Responce_Body;
import com.pe.mosip.service.Main_Table_Service;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayDeque;

@Component
public class RequestConsumer {
    Main_Table_Service main_table_service=new Main_Table_Service();

    public static ArrayDeque<Responce_Body> list = new ArrayDeque<>();
    @JmsListener(destination = "inbound.queue")
    public void requestListener(Request_Body request_body) throws IOException, SAXException {
        Responce_Body responce_body = main_table_service.request(request_body);
        //PushResToOutbound pushRestoOutbound =new PushResToOutbound();
        //pushRestoOutbound.push(responce_body);
        list.add(responce_body);

    }

    public RequestConsumer(ArrayDeque<Responce_Body> list) {
        this.list = list;
    }

    public RequestConsumer() {
    }

    public ArrayDeque<Responce_Body> getList() {
        return list;
    }

    public void setList(ArrayDeque<Responce_Body> list) {
        this.list = list;
    }
}
