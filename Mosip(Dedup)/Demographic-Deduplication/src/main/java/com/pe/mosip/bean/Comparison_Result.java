package com.pe.mosip.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Comparison_Result implements Serializable{
    Compare_Record compare_record;
    ArrayList<String> matching_ids;

    public Comparison_Result(Compare_Record compare_record, ArrayList<String> matching_ids) {
        this.compare_record = compare_record;
        this.matching_ids = matching_ids;
    }

    public Comparison_Result() {
    }

    public Compare_Record getCompare_record() {
        return compare_record;
    }

    public void setCompare_record(Compare_Record compare_record) {
        this.compare_record = compare_record;
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
                "compare_record=" + compare_record.toString() +
                ", matching_ids=" + matching_ids +
                '}';
    }
}
