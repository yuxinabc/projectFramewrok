package com.syx.projectframewrok.model.bean;

import java.util.List;

public class TelInfoBean {

    /**
     * hasNext : false
     * retcode : 000000
     * pageToken : null
     * data : [{"location":"广东 深圳市","id":"13534060599","cardType":"移动预付费卡","zipCode":"518000","areaCode":"0755"}]
     * dataType : tools
     * appCode : phone_number_ascription
     */

    private boolean hasNext;
    private String retcode;
    private Object pageToken;
    private String dataType;
    private String appCode;
    private List<DataBean> data;

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public Object getPageToken() {
        return pageToken;
    }

    public void setPageToken(Object pageToken) {
        this.pageToken = pageToken;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * location : 广东 深圳市
         * id : 13534060599
         * cardType : 移动预付费卡
         * zipCode : 518000
         * areaCode : 0755
         */

        private String location;
        private String id;
        private String cardType;
        private String zipCode;
        private String areaCode;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }
    }
}
