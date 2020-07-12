package com.springboot.springhibernatedemo.dao;

import java.util.List;
import com.springboot.springhibernatedemo.model.CourseModel;
public interface ICourseDAO {
    List<CourseModel> getAllCourse();
    CourseModel getCourseById(int courseId);
    void addCourse(CourseModel courseModel);
    void updateCourse(CourseModel courseModel);
    void deleteCourse(int courseId);
}
