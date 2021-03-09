package com.pe.mosip.bean;

import javax.persistence.*;

@Entity
public class Request_Body {

    @Id
    @Column
    String Id;

    @Column
    String version;

    @Column
    String requestId;

    @Column
    String requestTime;

    @Column
    String referenceId;

    @Column
    String refernceURL;

    @OneToOne(mappedBy = "demo_Details",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Demo_Details demo_details;

    @OneToOne(mappedBy = "compare_record",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Compare_Record compare_record;

    public Request_Body(String id, String version, String requestId, String requestTime, String referenceId, String refernceURL, Demo_Details demo_details, Compare_Record compare_record) {
        Id = id;
        this.version = version;
        this.requestId = requestId;
        this.requestTime = requestTime;
        this.referenceId = referenceId;
        this.refernceURL = refernceURL;
        this.demo_details = demo_details;
        this.compare_record = compare_record;
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

    public String toString(Request_Body request_body)
    {
        return request_body.getId()+"\n"+request_body.getVersion()+"\n"+request_body.getDemo_details().getFull_name()+"\n"+request_body.getDemo_details().getAddress()
                +"\n"+request_body.getDemo_details().getDob();
    }
}
