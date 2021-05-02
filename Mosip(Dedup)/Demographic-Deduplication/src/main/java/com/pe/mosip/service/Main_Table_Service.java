package com.pe.mosip.service;

import com.pe.mosip.bean.*;
import com.pe.mosip.dao.DemoDao;
import com.pe.mosip.dao.ThreadDao;
import com.pe.mosip.dao.implementation.DemoDaoimpl;

import com.pe.mosip.dao.implementation.ThreadDaoimpl;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class Main_Table_Service {
    DemoDao demoDao=new DemoDaoimpl();

    public Responce_Body request(Request_Body request_body) throws IOException, SAXException, InterruptedException {

        Responce_Body responce_body=setResponce(request_body);
        if((request_body.getId()).equals("mosip.dedup.insert"))
        {
            if(demoDao.insert(request_body.getRecords())==200) {
                responce_body.setReturnValue("1");
            }
            else{
                responce_body.setFailureReason("Error occurred in insertion of Demo_Details table");
                responce_body.setReturnValue("-1");
            }
        }
        else if(request_body.getId().equals("mosip.dedup.identify"))
        {
            if(initialization(request_body, responce_body) == false)
                return responce_body;
            if(identify(request_body,responce_body) == false)
                return responce_body;
            if(finalization(request_body,responce_body) == false)
                return responce_body;
        }
        else if(request_body.getId().equals("mosip.dedup.delete"))
        {
            if(demoDao.delete(request_body.getRecords())==200) {
                responce_body.setReturnValue("1");
            }
            else
            {
                responce_body.setFailureReason("Error occurred in deletion of Demo_Details table");
                responce_body.setReturnValue("-1");
            }
        }
        else
        {
            responce_body.setReturnValue("-1");
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

    public boolean insertForCompare(ArrayList<Demo_Details> records, String ThreadName)
    {
        if(records.size()==0)
            return false;
        ThreadDao threadDao = new ThreadDaoimpl();
        if(threadDao.insertRecords(records,ThreadName)==200)
            return true;
        else
            return false;
    }



    private boolean initialization(Request_Body request_body ,Responce_Body responce_body) throws InterruptedException, IOException {
        //create new view for compare_record_thread
        //make copy of configuration files for each thread
        //update that files for tables;
        /*
        we will use views and we will keep compare dao table as it is
        */

        ThreadDao threadDao = new ThreadDaoimpl();
        String threadName = Thread.currentThread().getName();


        //Individual table creation for each thread
        threadDao.createTable(threadName);


        //insert record into created table
        ArrayList<Demo_Details> records = request_body.getRecords();
        if(!insertForCompare(records, threadName))
        {
            responce_body.setReturnValue("-1");
            responce_body.setFailureReason("Error occurred in Insertion of threadTable");
            return false;
        }


        //copy and update duke config file according to each thread
        ProcessBuilder processBuilder = new ProcessBuilder();
        final ClassLoader classLoader = getClass().getClassLoader();
        final File scriptFile = new File(classLoader.getResource("Initializer.sh").getFile());
        processBuilder.command(scriptFile.getPath(),threadName);
        Process process = processBuilder.start();
        int exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println("Success! creating duke Config File For thread:"+threadName);
        } else {
            //abnormal...
            System.out.println("abnormal :: inputMonitorCreator");
            responce_body.setFailureReason("Failed to create Duke config file for thread "+threadName);
            responce_body.setReturnValue("-1");
            return false;
        }








        return true;

    }

    private boolean identify(Request_Body request_body, Responce_Body responce_body) throws IOException, SAXException {

        String threadName = Thread.currentThread().getName();
        String path = "ThreadDukeConfigFiles/duke_"+threadName+"_cfg.xml";

        duke_implementation duke_implementation=new duke_implementation();
        ArrayList<Comparison_Result> sList=duke_implementation.identify(path,threadName);
        responce_body.setResult(sList);
        responce_body.setReturnValue("1");

        return true;
    }

    private boolean finalization(Request_Body request_body,Responce_Body responce_body) throws InterruptedException, IOException {
        //delete that record
        //delete all files made for thread
        ThreadDao threadDao = new ThreadDaoimpl();
        String threadName = Thread.currentThread().getName();



        //table deletion for each thread
        threadDao.dropTable(threadName);




        //duke Config File deletion
        ProcessBuilder processBuilder = new ProcessBuilder();
        final ClassLoader classLoader = getClass().getClassLoader();
        final File scriptFile = new File(classLoader.getResource("Finalizer.sh").getFile());
        processBuilder.command(scriptFile.getPath(),threadName);
        Process process = processBuilder.start();
        int exitVal = process.waitFor();
        if (exitVal == 0) {
            System.out.println("Success! deleting duke Config File For thread:"+threadName);
        } else {
            //abnormal...
            System.out.println("abnormal :: inputMonitorCreator");
            responce_body.setFailureReason("Failed to create Duke config file for thread "+threadName);
            responce_body.setReturnValue("-1");
            return false;
        }



        return true;
    }

}


