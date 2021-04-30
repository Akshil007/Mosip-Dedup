package com.pe.mosip.dao;

import com.pe.mosip.bean.Demo_Details;

import java.util.ArrayList;

public interface ThreadDao {
    void createTable(String ThreadName);
    int insertRecords(ArrayList<Demo_Details> records, String ThreadName);
    Demo_Details getRecord(String id, String ThreadName);
    void dropTable(String ThreadName);
}
