package com.project.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "data")
public class Data implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    String date;

    @Column(name = "open")
    double open;

    @Column(name = "high")
    double high;

    @Column(name = "low")
    double low;

    @Column(name = "close")
    double close;

    @Column(name = "adjusted_close")
    double adjusted_close;

    @Column(name = "volume")
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
