package com.courselink.server.service;

import com.courselink.server.domain.Course;
import com.courselink.server.domain.Tag;
import com.courselink.server.dto.CourseRequestDto;
import com.courselink.server.dto.CourseResponseDto;
import com.courselink.server.repository.CourseRepository;

import com.courselink.server.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TagRepository tagRepository;

    public CourseService(CourseRepository courseRepository, TagRepository tagRepository) {
        this.courseRepository = courseRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    public CourseResponseDto createCourse(CourseRequestDto requestDto) {
        Course course = new Course(
                requestDto.title(),
                requestDto.description(),
                requestDto.url(),
                requestDto.price()
        );

        if(requestDto.tags() != null) {
            for(String tagName : requestDto.tags()) {
                Tag tag = tagRepository.findByName(tagName).orElseGet(() -> tagRepository.save(new Tag(tagName)));
                course.addTag(tag);
            }
        }

        Course savedCourse = courseRepository.save(course);

        return new CourseResponseDto(savedCourse);
    }

    @Transactional(readOnly = true)
    public List<CourseResponseDto> getCourses() {
        return courseRepository.findAll().stream().map(CourseResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CourseResponseDto getCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 강의가 존재하지 않습니다. id=" + id));
        return new CourseResponseDto(course);
    }
}
