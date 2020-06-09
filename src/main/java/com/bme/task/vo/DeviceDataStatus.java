package com.bme.task.vo;

import java.util.Date;

/**
 * 设备数据状态
 *
 * @author yutyi
 * @date 2020/06/09
 */
public class DeviceDataStatus {

    private int id;
    private long deviceId;
    private String deviceNo;
    private long customerId;
    private int total;
    private int exCount;
    private int exceedCount;
    private long typeId;
    private double reportRate;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getExCount() {
        return exCount;
    }

    public void setExCount(int exCount) {
        this.exCount = exCount;
    }

    public int getExceedCount() {
        return exceedCount;
    }

    public void setExceedCount(int exceedCount) {
        this.exceedCount = exceedCount;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public double getReportRate() {
        return reportRate;
    }

    public void setReportRate(double reportRate) {
        this.reportRate = reportRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
