package com.courselink.server.dto;

import com.courselink.server.domain.Course;

public class CourseResponseDto {
    private Long id;
    private String title;
    private String description;
    private String url;
    private int price;

    public CourseResponseDto(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.description = course.getDescription();
        this.url = course.getUrl();
        this.price = course.getPrice();
    }

    public Long getId() {
        return id;
    }

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
