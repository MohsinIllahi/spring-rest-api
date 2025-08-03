package com.springrest.springrest.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MyController {
    private static final Logger logger = Logger.getLogger(MyController.class.getName());

	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to my first spring application";
	}

	// Get the courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseService.getCourses();

	}
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId,HttpServletRequest request) {
		 String fullUrl = request.getRequestURL().toString();
		 Course course=this.courseService.getCourses(Long.parseLong(courseId));
		logger.info("Request recieved for specififc courseId:---->"+fullUrl);
		logger.info("Response recieved for specififc courseId:---->"+course.toString());
		return course;
	}
	//add course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	//update course
		@PutMapping("/courses")
		public Course updateCourse(@RequestBody Course course) {
			return this.courseService.updateCourse(course);
		}

}
