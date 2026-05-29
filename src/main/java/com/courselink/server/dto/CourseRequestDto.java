package com.courselink.server.dto;

import java.util.List;

public record CourseRequestDto (
    String title,
    String description,
    String url,
    int price,
    List<String> tags
) {}