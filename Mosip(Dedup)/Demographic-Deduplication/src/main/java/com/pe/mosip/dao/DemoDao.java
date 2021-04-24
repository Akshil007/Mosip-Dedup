package com.pe.mosip.dao;

import com.pe.mosip.bean.Demo_Details;

public interface DemoDao {
    int insert(Demo_Details demo_details);
    int delete(Demo_Details demo_details);
}
