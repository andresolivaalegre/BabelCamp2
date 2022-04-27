package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCurso;
	private String denominacion;
	private int duracion;
	private double precio;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@OneToMany(mappedBy = "curso")
	private List<Alumno> alumnos;
	
}
