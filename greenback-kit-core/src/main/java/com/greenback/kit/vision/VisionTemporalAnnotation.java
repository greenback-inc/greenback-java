package com.greenback.kit.vision;

import java.time.LocalDate;
import java.time.LocalTime;

public class VisionTemporalAnnotation extends VisionAnnotation {
    
    private LocalDate date;
    private LocalTime time;
    private VisionTemporalGranularity granularity;
    private String tz;
    
    @Override
    public String getType() {
        return "temporal";
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public VisionTemporalGranularity getGranularity() {
        return granularity;
    }

    public void setGranularity(VisionTemporalGranularity granularity) {
        this.granularity = granularity;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

}