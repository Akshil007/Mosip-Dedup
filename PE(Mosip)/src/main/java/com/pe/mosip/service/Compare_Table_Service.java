package com.pe.mosip.service;

import com.pe.mosip.bean.Compare_Record;
import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.dao.CompareDao;
import com.pe.mosip.dao.DemoDao;
import com.pe.mosip.dao.implementation.CompareDaoimpl;
import com.pe.mosip.dao.implementation.DemoDaoimpl;

public class Compare_Table_Service {
    CompareDao compareDao=new CompareDaoimpl();
    public int addDemo(Compare_Record compare_record) {
        return compareDao.insert(compare_record);
    }
}
