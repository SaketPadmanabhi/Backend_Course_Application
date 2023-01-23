package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//REST - Representational State Transfer
@RestController
public class MyController {

    @Autowired
    private CoursesService coursesService;
    @GetMapping("/home")
    public String home(){
        return "Welcome to Courses Application";
    }

    //get the courses
    @GetMapping("/courses")
    public List<Courses> getCourses()
    {
        return this.coursesService.getCourses();
    }

    //single course get
    @GetMapping("/courses/{courseId}")
    public Courses getCourse(@PathVariable String courseId)
    {
        return this.coursesService.getCourses(Long.parseLong(courseId));
    }

    //add a new course
    @PostMapping(path="/courses",consumes = "application/json")
    public Courses addCourse(@RequestBody Courses course)
    {
        return this.coursesService.addCourse(course);
    }

    @PutMapping(path="/courses", consumes="application/json" )
    public Courses updateCourse(@RequestBody Courses course)
    {
        return this.coursesService.updateCourse(course);
    }

    //The above APIs do not have the http status involved for them, it is mandatory to pass see the below api
    @DeleteMapping(path = "/courses/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID)
    {
        try {
            this.coursesService.deleteCourse(Long.parseLong(courseID));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
