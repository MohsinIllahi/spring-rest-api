package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

//	private final MyController myController;
	List<Course> list;

	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(123, "Java Core Course", "This is a basic course for beginners"));
		list.add(new Course(124, "Java Advance Course", "This is a basic course for intermediates"));
		list.add(new Course(125, "JavaScript Core Course", "This is a basic course for beginners"));
//		this.myController = myController;
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourses(long courseId) {
		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e -> {
			if (e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public Course deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
	}

}
