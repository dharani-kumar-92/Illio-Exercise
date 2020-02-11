package com.dharani.Model;

public class Data {
    String date;
    double open;
    double high;
    double low;
    double close;
    double adjusted_close;
    Integer volume;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getAdjusted_close() {
        return adjusted_close;
    }

    public void setAdjusted_close(double adjusted_close) {
        this.adjusted_close = adjusted_close;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
