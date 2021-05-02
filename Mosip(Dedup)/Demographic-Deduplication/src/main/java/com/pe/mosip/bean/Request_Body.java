package com.pe.mosip.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Request_Body implements Serializable {

    String Id;

    String version;

    String requestId;

    String requestTime;

    String referenceId;

    String referenceURL;

    ArrayList<Demo_Details> records;

    public Request_Body(String id, String version, String requestId, String requestTime, String referenceId, String refernceURL, ArrayList<Demo_Details> records) {
        Id = id;
        this.version = version;
        this.requestId = requestId;
        this.requestTime = requestTime;
        this.referenceId = referenceId;
        this.referenceURL = refernceURL;
        this.records = records;
    }

    public Request_Body() {
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
        return referenceURL;
    }

    public void setRefernceURL(String refernceURL) {
        this.referenceURL = refernceURL;
    }

    public ArrayList<Demo_Details> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Demo_Details> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Request_Body{" +
                "Id='" + Id + '\'' +
                ", version='" + version + '\'' +
                ", requestId='" + requestId + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", referenceId='" + referenceId + '\'' +
                ", refernceURL='" + referenceURL + '\'' +
                ", records=" + records +
                '}';
    }
}
