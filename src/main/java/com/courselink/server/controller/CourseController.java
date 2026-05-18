package com.courselink.server.controller;

import com.courselink.server.dto.CourseRequestDto;
import com.courselink.server.dto.CourseResponseDto;
import com.courselink.server.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponseDto createCourse(@RequestBody CourseRequestDto requestDto) {
        return courseService.createCourse(requestDto);
    }

    @GetMapping
    public List<CourseResponseDto> getCourse() {
        return courseService.getCourses();
    }
}
