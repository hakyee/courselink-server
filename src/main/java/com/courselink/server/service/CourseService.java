package com.courselink.server.service;

import com.courselink.server.domain.Course;
import com.courselink.server.dto.CourseRequestDto;
import com.courselink.server.dto.CourseResponseDto;
import com.courselink.server.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseResponseDto createCourse(CourseRequestDto requestDto) {
        Course course = new Course(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getUrl(),
                requestDto.getPrice()
        );

        Course savedCourse = courseRepository.save(course);

        return new CourseResponseDto(savedCourse);
    }

    public List<CourseResponseDto> getCourse() {
        return courseRepository.findAll().stream().map(CourseResponseDto::new).collect(Collectors.toList());
    }
}
