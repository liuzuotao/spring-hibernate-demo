package com.springboot.springhibernatedemo.dao;

import com.springboot.springhibernatedemo.model.CourseModel;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class CourseDAOImpl implements ICourseDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Override
    public List<CourseModel> getAllCourse() {
        String hql="select id,course_name,difficulty_level,star_level from course";
        Query query=entityManager.createNativeQuery(hql,CourseModel.class);
        for(int i=0;i<query.getResultList().size();i++){
            System.out.println(query.getResultList().get(i).toString());
        }
        return query.getResultList();
    }

    @Override
    public CourseModel getCourseById(int courseId) {
        return entityManager.find(CourseModel.class,courseId);
    }

    @Override
    public void addCourse(CourseModel courseModel) {
        entityManager.persist(courseModel);
    }

    @Override
    public void deleteCourse(int courseId) {
        entityManager.remove(this.getCourseById(courseId));
    }

    @Override
    public void updateCourse(CourseModel courseModel) {
        CourseModel c=this.getCourseById(courseModel.getId());
        c.setCourse_name(courseModel.getCourse_name());
        c.setDifficulty_level(courseModel.getDifficulty_level());
        c.setStar_level(courseModel.getStar_level());
        entityManager.flush();
    }
}
