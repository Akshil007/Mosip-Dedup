package com.pe.mosip.service;

import com.pe.mosip.bean.*;
import com.pe.mosip.dao.CompareDao;
import com.pe.mosip.dao.DemoDao;
import com.pe.mosip.dao.implementation.CompareDaoimpl;
import com.pe.mosip.dao.implementation.DemoDaoimpl;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.*;

public class Main_Table_Service {
    DemoDao demoDao=new DemoDaoimpl();
    CompareDao compareDao=new CompareDaoimpl();
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
            ArrayList<Compare_Record> records=request_body.getRecords();
            if(!insertForCompare(records))
            {
                responce_body.setReturnValue("2");
            }
            else{
            ArrayList<Comparison_Result> sList=duke_implementation.identify();
            responce_body.setResult(sList);
            responce_body.setReturnValue("1");
            }
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

    public boolean insertForCompare(ArrayList<Compare_Record> records)
    {
        if(records.size()==0)
            return false;
        if(compareDao.insert(records)==200)
            return true;
        else
            return false;
    }
}
