package com.avisys;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "common.date-format")
public class DateFormatProperties {

    private String localDate = "MM-dd-yyyy";
    private String localDateTime = "MM-dd-yyyy HH:mm";

    public String getLocalDate() { return localDate; }
    public void setLocalDate(String localDate) { this.localDate = localDate; }

    public String getLocalDateTime() { return localDateTime; }
    public void setLocalDateTime(String localDateTime) { this.localDateTime = localDateTime; }
}
