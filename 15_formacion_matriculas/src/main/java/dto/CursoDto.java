package dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CursoDto {
	private int idCurso;
	public CursoDto(int idCurso, String nombre, int duracion, double precio, Date fechaInicio) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.fechaInicio = fechaInicio;
	}
	private String nombre;
	private int duracion;
	private double precio;
	private Date fechaInicio;
	List<String> alumnos;
}
