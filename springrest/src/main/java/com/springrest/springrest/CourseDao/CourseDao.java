package com.springrest.springrest.CourseDao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springrest.springrest.entities.Courses;
import java.util.List;

//interceptor, aop logging, override jpa using @query, @api parm
//sonar splint
public interface CourseDao extends JpaRepository<Courses,Long> {

}
