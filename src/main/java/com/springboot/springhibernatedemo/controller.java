package com.springboot.springhibernatedemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import com.springboot.springhibernatedemo.server.CourseServer;
import com.springboot.springhibernatedemo.model.CourseModel;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class controller {
    @Resource
    private CourseServer courseServer;
    @RequestMapping("/select")
    public String courseList(Model model){
        System.out.println("进入后台界面");
        List<CourseModel> course=new ArrayList<CourseModel>();
        /*course.add(courseServer.getCourseById(1));
        course.add(courseServer.getCourseById(2));
        course.add(courseServer.getCourseById(3));*/
        course=courseServer.getAllCourse();
        if(course.isEmpty())
            System.out.println("为空");
        model.addAttribute("Courses",course);
        return "CourseList";
    }
}
