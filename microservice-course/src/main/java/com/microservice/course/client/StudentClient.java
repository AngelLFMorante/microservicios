package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Configuracion del cliente microservicio de Student
//Si tenemos una puerta de enlace como en gateWay en la url ya no hace falta apuntar directamente al microservicio  "localhost:8090/api/student"
// Ahora con gateWay directamente ponemos el puerto de la puerta del enlace 8080
@FeignClient(name = "msvc-student", url = "localhost:8080/api/student") //este nombre está en el properties de student y url junto su requestMapping
public interface StudentClient {

    @GetMapping("/search-by-course/{idCourse}")
    //Aqui como no se puede traer la entidad, se ha de crear un DTO
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long idCourse);
}
