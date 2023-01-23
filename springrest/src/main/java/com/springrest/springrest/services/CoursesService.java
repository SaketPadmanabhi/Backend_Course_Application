package com.springrest.springrest.services;

import com.springrest.springrest.entities.Courses;

import java.util.List;

public interface CoursesService {

    public List<Courses> getCourses();
    public Courses getCourses(long courseID);
    public Courses addCourse(Courses course);

    public Courses updateCourse(Courses course);

    public Courses deleteCourse(long courseID);
}
