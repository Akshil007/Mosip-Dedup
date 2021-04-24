package com.pe.mosip.service;

import com.pe.mosip.bean.Compare_Record;
import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.bean.Request_Body;
import com.pe.mosip.bean.Responce_Body;
import com.pe.mosip.dao.CompareDao;
import com.pe.mosip.dao.implementation.CompareDaoimpl;

public class Deprecated_Compare_Table_Service {
    CompareDao compareDao=new CompareDaoimpl();
    Main_Table_Service main_table_service=new Main_Table_Service();
    public Responce_Body addDemo(Request_Body request_body) {
        Responce_Body responce_body=main_table_service.setResponce(request_body);
        if((request_body.getId()).equals("mosip.dedup.compare_insert"))
        {
            Compare_Record compare_record=request_body.getCompare_record();
//            if(compareDao.insert(compare_record)==200) {
//                responce_body.setReturnValue("1");
//            }
//            else{
//                responce_body.setReturnValue("2");
//            }
        }
        else
        {
            responce_body.setReturnValue("2");
            responce_body.setFailureReason("Id is wrong");
        }
        return responce_body;
    }
}
