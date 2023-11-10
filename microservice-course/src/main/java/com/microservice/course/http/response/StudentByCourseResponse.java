package com.microservice.course.http.response;

import com.microservice.course.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Clase para mapear los microservicios
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentByCourseResponse {

    //Respuesta personalizada
    private String courseName;
    private String teacher;
    private List<StudentDTO> studentDTOList;

}
