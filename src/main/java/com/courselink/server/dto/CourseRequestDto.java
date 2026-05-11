package com.courselink.server.dto;

public class CourseRequestDto {
    private String title;
    private String description;
    private String url;
    private int price;

    public CourseRequestDto() {}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public int getPrice() {
        return price;
    }
}
