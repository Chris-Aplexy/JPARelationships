package com.rols.educ.Service.RolsSvc;

import com.rols.educ.Model.Course;

import java.util.List;

public interface RolsService {


    Course addCourse(Course course);

    Course viewCourse(long id);

    List<Course> viewAllCourses();

    Course editCourse(long id, Course course);

    void deleteCourse(long id);
}
