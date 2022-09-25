package com.rols.educ.Service;

import com.rols.educ.Model.Course;
import com.rols.educ.Repository.CommentRepository;
import com.rols.educ.Repository.CourseRepository;
import com.rols.educ.Repository.ReviewRepository;
import com.rols.educ.Service.RolsSvc.RolsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolsServiceImpl implements RolsService {

    private final CourseRepository courseRepository;
    private final ReviewRepository reviewRepository;
    private final CommentRepository commentRepository;

    public RolsServiceImpl(CourseRepository courseRepository, ReviewRepository reviewRepository, CommentRepository commentRepository) {
        this.courseRepository = courseRepository;
        this.reviewRepository = reviewRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course viewCourse(long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> viewAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course editCourse(long id, Course course) {
        Optional<Course> oldCourse = courseRepository.findById(id);
        if(course.getCourseName() != null) oldCourse.get().setCourseName(course.getCourseName());
        if(course.getCourseTittle() != null) oldCourse.get().setCourseTittle(course.getCourseTittle());
        if(course.getCourseDescription() != null) oldCourse.get().setCourseDescription(course.getCourseDescription());
        if(course.getComments() != null) oldCourse.get().setComments(course.getComments());
        if(course.getEndDate() != null) oldCourse.get().setEndDate(course.getEndDate());
        if(course.getStartDate() != null) oldCourse.get().setStartDate(course.getStartDate());
        if(course.getReferenceId() != null) oldCourse.get().setReferenceId(course.getReferenceId());
        if(course.getReviews() != null) oldCourse.get().setReviews(course.getReviews());
        if(course.getTutorName() != null) oldCourse.get().setTutorName(course.getTutorName());
        if(course.getImageUrl() != null) oldCourse.get().setImageUrl(course.getImageUrl());
        if(course.getVideoUrls() != null) oldCourse.get().setVideoUrls(course.getVideoUrls());

        reviewRepository.save(oldCourse.get().getReviews());
        commentRepository.save(oldCourse.get().getComments());

        return courseRepository.save(oldCourse.get());
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }
}
