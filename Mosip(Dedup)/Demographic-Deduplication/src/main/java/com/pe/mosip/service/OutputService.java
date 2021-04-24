package com.pe.mosip.service;

import com.pe.mosip.Listener.RequestConsumer;
import com.pe.mosip.bean.Responce_Body;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class OutputService {

    public List<Responce_Body> getRecords(int minNoRecords)
    {
        RequestConsumer requestConsumer = new RequestConsumer();
        ArrayDeque<Responce_Body> list = requestConsumer.getList();
        List<Responce_Body> finalList = new ArrayList<>();
        if(list.size()<minNoRecords)
        {
            finalList.addAll(list);
            list.clear();
        }
        else
        {
            for(int i=0;i<minNoRecords;i++)
            {
                finalList.add(list.poll());
            }
        }
        return finalList;
    }
}
