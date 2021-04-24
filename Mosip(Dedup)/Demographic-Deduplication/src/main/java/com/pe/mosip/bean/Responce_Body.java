package com.pe.mosip.bean;

import java.io.Serializable;
import java.util.List;
public class Responce_Body implements Serializable {
    String id;

    String requestId;

    String responsetime;

    String returnValue;

    String failureReason;

    List<Comparison_Result> Result;

    public Responce_Body() {
    }

    public Responce_Body(String id, String requestId, String responsetime, String returnValue, String failureReason, List<Comparison_Result> result) {
        this.id = id;
        this.requestId = requestId;
        this.responsetime = responsetime;
        this.returnValue = returnValue;
        this.failureReason = failureReason;
        Result = result;
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

    public String getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(String responcetime) {
        this.responsetime = responcetime;
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

    public List<Comparison_Result> getResult() {
        return Result;
    }

    public void setResult(List<Comparison_Result> result) {
        Result = result;
    }

    @Override
    public String toString() {
        return "Responce_Body{" +
                "id='" + id + '\'' +
                ", requestId='" + requestId + '\'' +
                ", responsetime='" + responsetime + '\'' +
                ", returnValue='" + returnValue + '\'' +
                ", failureReason='" + failureReason + '\'' +
                ", Result=" + Result.toString() +
                '}';
    }
}
