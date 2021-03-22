package com.pe.mosip.bean;

import java.util.List;
public class Responce_Body {
    String id;

    String requestId;

    String responsetime;

    String returnValue;

    String failureReason;

    List<String> MatchingIds;

    public Responce_Body() {
    }

    public Responce_Body(String id, String requestId, String responsetime, String returnValue, String failureReason) {
        this.id = id;
        this.requestId = requestId;
        this.responsetime = responsetime;
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

    public List<String> getMatchingIds() {
        return MatchingIds;
    }

    public void setMatchingIds(List<String> matchingIds) {
        this.MatchingIds = matchingIds;
    }
}
