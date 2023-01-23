package com.springrest.springrest.services;

import com.springrest.springrest.CourseDao.CourseDao;
import com.springrest.springrest.entities.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService{

    @Autowired
    private CourseDao courseDao;
//    List<Courses> list;
//
//    //This temporary, here actually there should be a DAO, which fetches data from the Database.
    public CoursesServiceImpl(){
//        list = new ArrayList<>();
//        list.add(new Courses(1,"Java","Basics of Java Programming"));
//        list.add(new Courses(2,"Spring Boot","Getting Started with Spring Boot"));
    }

    @Override
    public List<Courses> getCourses() {
    //    return list;
        return courseDao.findAll();   // this will take everything from database create a list and return
    }

    @Override
    public Courses getCourses(long courseID) {
//        Courses c = null;
//        for(Courses course:list){
//            if(course.getId()==courseID){
//                c=course;
//                break;
//            }
//        }
        return courseDao.getReferenceById(courseID);
    }

    @Override
    public Courses addCourse(Courses course) {
      //  list.add(course);
         courseDao.save(course);
         return course;
    }

    @Override
    public Courses updateCourse(Courses course) {

//        list.forEach(e -> {                                 // This is use-case of Lambda Functionality
//            if (e.getId()==course.getId()){                 // Please see how lambda function works
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
        courseDao.save(course);
        return course;
    }


    @Override
    public Courses deleteCourse(long courseID) {
//        Courses c = null;
//        for(Courses course:list){
//            if(course.getId()==courseID){
//                c=course;
//                list.remove(course);
//                break;
//            }
//        }
   // Or the above can be implemented using lambda functionality as well
   //list=this.list.stream().filter(e->e.getId()!=courseID).collect(Collector.toList())
        Courses one = courseDao.getReferenceById(courseID);
        courseDao.delete(one);
        return one;
        // we can also directly pass an object in the function parameters and return it here
    }


}
