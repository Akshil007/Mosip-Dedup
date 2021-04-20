package com.pe.mosip.dao;

import com.pe.mosip.bean.Compare_Record;

import java.util.ArrayList;

public interface CompareDao {
    public int insert(ArrayList<Compare_Record> compare_records);
}
