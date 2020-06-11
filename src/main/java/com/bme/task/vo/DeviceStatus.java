package com.bme.task.vo;

import java.util.Date;

/**
 * @author yutyi
 * @date 2020/06/11
 */
public class DeviceStatus {

    private long deviceId;
    private long customerId;
    private String deviceNo;
    private long outlineTime;
    private Date createTime;
    private int status;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public long getOutlineTime() {
        return outlineTime;
    }

    public void setOutlineTime(long outlineTime) {
        this.outlineTime = outlineTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
