package com.pe.mosip.service;

import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.bean.Request_Body;
import com.pe.mosip.bean.Responce_Body;
import com.pe.mosip.dao.DemoDao;
import com.pe.mosip.dao.implementation.DemoDaoimpl;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

public class Main_Table_Service {
    DemoDao demoDao=new DemoDaoimpl();
    public Responce_Body request(Request_Body request_body) throws IOException, SAXException {
        Responce_Body responce_body=setResponce(request_body);
        if((request_body.getId()).equals("mosip.dedup.insert"))
        {
            Demo_Details demo_details=request_body.getDemo_details();
            if(demoDao.insert(demo_details)==200) {
                responce_body.setReturnValue("1");
            }
            else{
                responce_body.setReturnValue("2");
            }
        }
        else if(request_body.getId().equals("mosip.dedup.identify"))
        {
            duke_implementation duke_implementation=new duke_implementation();
            ArrayList<String> sList=duke_implementation.identify();
            responce_body.setReturnValue("1");
        }
        else if(request_body.getId().equals("mosip.dedup.delete"))
        {
            Demo_Details demo_details=request_body.getDemo_details();
            if(demoDao.delete(demo_details)==200) {
                responce_body.setReturnValue("1");
            }
            else
            {
                responce_body.setReturnValue("2");
            }
        }
        else
        {
            responce_body.setReturnValue("2");
            responce_body.setFailureReason("Id is wrong");
        }
        return responce_body;
    }
    public Responce_Body setResponce(Request_Body request_body)
    {
        Responce_Body responceBody=new Responce_Body();
        responceBody.setId(request_body.getId());
        responceBody.setRequestId(request_body.getRequestId());
        return responceBody;
    }
}
