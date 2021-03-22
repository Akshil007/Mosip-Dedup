package com.pe.mosip.bean;

import javax.persistence.*;
import java.util.*;

@Entity
public class Responce_Body {
    @Id
    @Column
    String id;

    @Column
    String requestId;

    @Column
    String responcetime;

    @Column
    String returnValue;

    @Column
    String failureReason;

    @ManyToMany
    List<String> ids;

    public Responce_Body() {
    }

    public Responce_Body(String id, String requestId, String responcetime, String returnValue, String failureReason) {
        this.id = id;
        this.requestId = requestId;
        this.responcetime = responcetime;
        this.returnValue = returnValue;
        this.failureReason = failureReason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResponcetime() {
        return responcetime;
    }

    public void setResponcetime(String responcetime) {
        this.responcetime = responcetime;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}
