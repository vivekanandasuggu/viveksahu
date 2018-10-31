package com.educare.electus.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExamsListModel {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
//http://www.pdf995.com/samples/pdf.pdf
    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("enddate")
        @Expose
        private String enddate;
        @SerializedName("slotdate")
        @Expose
        private String slotdate;
        @SerializedName("starttime")
        @Expose
        private String starttime;
        @SerializedName("endtime")
        @Expose
        private String endtime;
        @SerializedName("examname")
        @Expose
        private String examname;
        @SerializedName("examtype")
        @Expose
        private String examtype;
        @SerializedName("examstatus")
        @Expose
        private String examstatus;
        @SerializedName("subnamelist")
        @Expose
        private List<String> subnamelist = null;
        @SerializedName("subidlist")
        @Expose
        private List<String> subidlist = null;

        public String getEnddate() {
            return enddate;
        }

        public void setEnddate(String enddate) {
            this.enddate = enddate;
        }

        public String getSlotdate() {
            return slotdate;
        }

        public void setSlotdate(String slotdate) {
            this.slotdate = slotdate;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }

        public String getEndtime() {
            return endtime;
        }

        public void setEndtime(String endtime) {
            this.endtime = endtime;
        }

        public String getExamname() {
            return examname;
        }

        public void setExamname(String examname) {
            this.examname = examname;
        }

        public String getExamtype() {
            return examtype;
        }

        public void setExamtype(String examtype) {
            this.examtype = examtype;
        }

        public String getExamstatus() {
            return examstatus;
        }

        public void setExamstatus(String examstatus) {
            this.examstatus = examstatus;
        }

        public List<String> getSubnamelist() {
            return subnamelist;
        }

        public void setSubnamelist(List<String> subnamelist) {
            this.subnamelist = subnamelist;
        }

        public List<String> getSubidlist() {
            return subidlist;
        }

        public void setSubidlist(List<String> subidlist) {
            this.subidlist = subidlist;
        }

    }

}
