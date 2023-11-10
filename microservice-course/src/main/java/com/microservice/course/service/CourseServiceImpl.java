package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import com.microservice.course.entities.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService{

    private final ICourseRepository courseRepository;

    //importar el cliente para conectar con microservicio
    private final StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override //Metodo de llamada al microservicio
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        //Consultar el curso
        Course course = courseRepository.findById(idCourse).orElse(new Course());

        //Obtener estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
