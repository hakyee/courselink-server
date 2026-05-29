package com.courselink.server.dto;

import com.courselink.server.domain.Course;
import com.courselink.server.domain.Tag;
import java.util.List;

public record CourseResponseDto (
        Long id,
        String title,
        String description,
        String url,
        int price,
        List<String> tags
) {
    public CourseResponseDto(Course course) {
        this(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getUrl(),
                course.getPrice(),
                course.getTags().stream().map(Tag::getName).toList()
        );
    }
}