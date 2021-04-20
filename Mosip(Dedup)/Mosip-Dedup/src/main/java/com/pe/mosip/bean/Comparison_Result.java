package com.pe.mosip.bean;

import java.util.ArrayList;

public class Comparison_Result {
    String id;
    ArrayList<String> matching_ids;

    public Comparison_Result(String id, ArrayList<String> matching_ids) {
        this.id = id;
        this.matching_ids = matching_ids;
    }

    public Comparison_Result() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getMatching_ids() {
        return matching_ids;
    }

    public void setMatching_ids(ArrayList<String> matching_ids) {
        this.matching_ids = matching_ids;
    }
}
