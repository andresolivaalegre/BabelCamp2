package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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
@Setter
@Getter
@Entity
@Table(name="cursos")
public class Curso {
	@Id
	private int idCurso;
	private String nombre;
	private int duracion;
	
	public Curso(int idCurso, String nombre, int duracion, double precio, Date fechaInicio) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
	}
	private double precio;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	@OneToMany(mappedBy = "curso") //nombre en la entidad matricual
	private List<Matricula> matriculas;
}
