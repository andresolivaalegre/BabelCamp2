package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import service.AlumnosService;

@CrossOrigin("*")
@Controller
public class AlumnosController {
	@Autowired
	AlumnosService alumnosService;
	
	@PostMapping("Alta")
	public String alta(@ModelAttribute Alumno alumno)  {
		alumnosService.altaAlumno(alumno);
		return "alta";
	}
	
	@GetMapping(value="Cursos", produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<String> cursos()  {		
		return alumnosService.cursos();	
	}
	
	@GetMapping(value="Buscador", produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Alumno> buscar(@RequestParam("curso") String curso)  {		
		return alumnosService.alumnosCurso(curso);	
	}
	
	@GetMapping(value="BuscadorCurso", produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<String> buscarCurso()  {		
		return alumnosService.cursos();	
	}
	
}
