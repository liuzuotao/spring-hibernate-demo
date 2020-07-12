package com.springboot.springhibernatedemo.server;

import com.springboot.springhibernatedemo.model.CourseModel;
import org.springframework.stereotype.Service;
import com.springboot.springhibernatedemo.dao.ICourseDAO;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServer {
    @Resource
    private ICourseDAO courseDAO;
    public List<CourseModel> getAllCourse(){
        return courseDAO.getAllCourse();
    }
    public CourseModel getCourseById(int courseId){
        return courseDAO.getCourseById(courseId);
    }
    public void updateCourse(CourseModel courseModel){
        courseDAO.updateCourse(courseModel);
    }
    public void deleteCourse(int courseId){
        courseDAO.deleteCourse(courseId);
    }
}
