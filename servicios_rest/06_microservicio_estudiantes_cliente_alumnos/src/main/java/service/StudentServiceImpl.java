package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	RestTemplate template;
	String urlBase="http://localhost:8000/crud";
	
	public StudentServiceImpl(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public void altaStudent(Student student) {
		template.postForLocation(urlBase+"/Alumno", student);
	}

	@Override
	public List<Student> studentPorPuntuacionMinima(double puntuacion) {
		//Recupero todos los estudiantes
		Student[] estudiantes= template.getForObject(urlBase+"/Alumnos", Student[].class);
		//Utilizo streams para filtrar
		return Arrays.stream(estudiantes)
		.filter(s->s.getPuntuacion()>puntuacion)
		.collect(Collectors.toList());
	}

}
