package com.pe.mosip.dao;

import com.pe.mosip.bean.Demo_Details;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface DemoDao {
    int insert(ArrayList<Demo_Details> records) throws InterruptedException;
    int delete(ArrayList<Demo_Details> records);
}
