package com.pe.mosip.bean;

import javax.persistence.*;
import java.util.ArrayList;

public class Request_Body {

    String Id;

    String version;

    String requestId;

    String requestTime;

    String referenceId;

    String refernceURL;

    Demo_Details demo_details;

    Compare_Record compare_record;

    ArrayList<Compare_Record> records;

    public Request_Body(String id, String version, String requestId, String requestTime, String referenceId, String refernceURL, Demo_Details demo_details, Compare_Record compare_record, ArrayList<Compare_Record> records) {
        Id = id;
        this.version = version;
        this.requestId = requestId;
        this.requestTime = requestTime;
        this.referenceId = referenceId;
        this.refernceURL = refernceURL;
        this.demo_details = demo_details;
        this.compare_record = compare_record;
        this.records = records;
    }

    public Request_Body() {
    }

    public Compare_Record getCompare_record() {
        return compare_record;
    }

    public void setCompare_record(Compare_Record compare_record) {
        this.compare_record = compare_record;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getRefernceURL() {
        return refernceURL;
    }

    public void setRefernceURL(String refernceURL) {
        this.refernceURL = refernceURL;
    }

    public Demo_Details getDemo_details() {
        return demo_details;
    }

    public void setDemo_details(Demo_Details demo_details) {
        this.demo_details = demo_details;
    }

    public ArrayList<Compare_Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Compare_Record> records) {
        this.records = records;
    }

    public String toString(Request_Body request_body)
    {
        return request_body.getId()+"\n"+request_body.getVersion()+"\n"+request_body.getDemo_details().getFull_name()+"\n"+request_body.getDemo_details().getAddress()
                +"\n"+request_body.getDemo_details().getDob();
    }
}
