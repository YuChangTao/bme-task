package com.bme.task.vo;

import java.io.Serializable;

/**
 * @author yutyi
 * @date 2020/06/05
 */
public class DeviceIndexStandard implements Serializable {

    private long id;
    private long startTime;
    private long endTime;
    private double exThreshold;
    private double exceedThreshold;
    private int k05Down;
    private int k05Up;
    private int k05ExceedDown;
    private int k05ExceedUp;
    private int k06Down;
    private int k06Up;
    private int k06ExceedDown;
    private int k06ExceedUp;
    private int k07Down;
    private int k07Up;
    private int k07ExceedDown;
    private int k07ExceedUp;
    private int k08Down;
    private int k08Up;
    private int k08ExceedDown;
    private int k08ExceedUp;
    private int frequency;

    private Long customerId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public double getExThreshold() {
        return exThreshold;
    }

    public void setExThreshold(double exThreshold) {
        this.exThreshold = exThreshold;
    }

    public double getExceedThreshold() {
        return exceedThreshold;
    }

    public void setExceedThreshold(double exceedThreshold) {
        this.exceedThreshold = exceedThreshold;
    }

    public int getK05Down() {
        return k05Down;
    }

    public void setK05Down(int k05Down) {
        this.k05Down = k05Down;
    }

    public int getK05Up() {
        return k05Up;
    }

    public void setK05Up(int k05Up) {
        this.k05Up = k05Up;
    }

    public int getK05ExceedDown() {
        return k05ExceedDown;
    }

    public void setK05ExceedDown(int k05ExceedDown) {
        this.k05ExceedDown = k05ExceedDown;
    }

    public int getK05ExceedUp() {
        return k05ExceedUp;
    }

    public void setK05ExceedUp(int k05ExceedUp) {
        this.k05ExceedUp = k05ExceedUp;
    }

    public int getK06Down() {
        return k06Down;
    }

    public void setK06Down(int k06Down) {
        this.k06Down = k06Down;
    }

    public int getK06Up() {
        return k06Up;
    }

    public void setK06Up(int k06Up) {
        this.k06Up = k06Up;
    }

    public int getK06ExceedDown() {
        return k06ExceedDown;
    }

    public void setK06ExceedDown(int k06ExceedDown) {
        this.k06ExceedDown = k06ExceedDown;
    }

    public int getK06ExceedUp() {
        return k06ExceedUp;
    }

    public void setK06ExceedUp(int k06ExceedUp) {
        this.k06ExceedUp = k06ExceedUp;
    }

    public int getK07Down() {
        return k07Down;
    }

    public void setK07Down(int k07Down) {
        this.k07Down = k07Down;
    }

    public int getK07Up() {
        return k07Up;
    }

    public void setK07Up(int k07Up) {
        this.k07Up = k07Up;
    }

    public int getK07ExceedDown() {
        return k07ExceedDown;
    }

    public void setK07ExceedDown(int k07ExceedDown) {
        this.k07ExceedDown = k07ExceedDown;
    }

    public int getK07ExceedUp() {
        return k07ExceedUp;
    }

    public void setK07ExceedUp(int k07ExceedUp) {
        this.k07ExceedUp = k07ExceedUp;
    }

    public int getK08Down() {
        return k08Down;
    }

    public void setK08Down(int k08Down) {
        this.k08Down = k08Down;
    }

    public int getK08Up() {
        return k08Up;
    }

    public void setK08Up(int k08Up) {
        this.k08Up = k08Up;
    }

    public int getK08ExceedDown() {
        return k08ExceedDown;
    }

    public void setK08ExceedDown(int k08ExceedDown) {
        this.k08ExceedDown = k08ExceedDown;
    }

    public int getK08ExceedUp() {
        return k08ExceedUp;
    }

    public void setK08ExceedUp(int k08ExceedUp) {
        this.k08ExceedUp = k08ExceedUp;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
