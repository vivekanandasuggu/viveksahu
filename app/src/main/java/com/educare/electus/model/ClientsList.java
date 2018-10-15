package com.educare.electus.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientsList {

    @SerializedName("clientid")
    @Expose
    private Integer clientid;
    @SerializedName("clientname")
    @Expose
    private String clientname;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
