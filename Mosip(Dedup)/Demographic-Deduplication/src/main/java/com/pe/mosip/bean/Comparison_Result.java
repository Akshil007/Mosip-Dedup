package com.pe.mosip.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Comparison_Result implements Serializable{
    Demo_Details record;
    ArrayList<String> matching_ids;

    public Comparison_Result(Demo_Details record, ArrayList<String> matching_ids) {
        this.record = record;
        this.matching_ids = matching_ids;
    }

    public Comparison_Result() {
    }

    public Demo_Details getRecord() {
        return record;
    }

    public void setRecord(Demo_Details record) {
        this.record = record;
    }

    public ArrayList<String> getMatching_ids() {
        return matching_ids;
    }

    public void setMatching_ids(ArrayList<String> matching_ids) {
        this.matching_ids = matching_ids;
    }

    @Override
    public String toString() {
        return "Comparison_Result{" +
                "record=" + record.toString() +
                ", matching_ids=" + matching_ids +
                '}';
    }
}
