package com.pe.mosip.service;

import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.dao.DemoDao;
import com.pe.mosip.dao.implementation.DemoDaoimpl;

public class Main_Table_Service {
    DemoDao demoDao=new DemoDaoimpl();
    public int addDemo(Demo_Details demo_details) {
        return demoDao.insert(demo_details);
    }
}
