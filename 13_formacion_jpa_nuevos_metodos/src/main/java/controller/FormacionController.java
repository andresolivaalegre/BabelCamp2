package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@Controller
public class FormacionController {
	@Autowired
	FormacionService formacionService;
	
	
	@PostMapping(value="AltaAlumno")
	public @ResponseBody String altaAlumno(@ModelAttribute Alumno a)  {	
		return formacionService.altaAlumno(a)? "menu":"altaAlumno";
	}
	
	@PostMapping(value="AltaCurso")
	public @ResponseBody String altaCurso(@ModelAttribute Curso c)  {	
		return formacionService.altaCurso(c)? "menu":"altaCurso";
	}
	
	@GetMapping(value="BuscarCursosNoMatriculadoAlumno", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> buscarAlumnoNoCurso(@RequestParam("usuario") String usuario, HttpServletRequest request)  {	
		return formacionService.cursosPosiblesMatricularAlumno(usuario);
	}
	
	
	@GetMapping(value="BuscarEntreFechas",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> matriculas(@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni, 
												@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin){
			return formacionService.consultarMatriculas(fechaIni, fechaFin);
		
	}

	@GetMapping(value="Cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> cursos()  {	
		return formacionService.cursos();
	}
	
	@GetMapping(value="Alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Alumno> alumnos()  {	
		return formacionService.alumnos();
	}
	
	@GetMapping(value="CursosAlumno", produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Curso> cursosAlumno(@RequestParam("usuario") String usuario)  {		
		return formacionService.cursosAlumno(usuario);	
	}
	
	@GetMapping(value="AlumnosCurso", produces = MediaType.APPLICATION_JSON_VALUE)	
	public @ResponseBody List<Alumno> alumnosCurso(@RequestParam("nombreCurso") String nombreCurso)  {		
		return formacionService.alumnosCurso(nombreCurso);	
	}
	
	@PostMapping("Login")
	public String login(@RequestParam String usuario, @RequestParam String password, HttpSession sesion, HttpServletRequest request)  {
		Alumno alumno = formacionService.validarUsuario(usuario, password);
		if(alumno!=null) {
			sesion.setAttribute("alumno", alumno);
			return "menu";}
		return "loginError";
	}
	
	

}
