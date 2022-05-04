package dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Titular;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ClienteDto {
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
	
	public ClienteDto(int dni, String nombre, String direccion, int telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	private List<Titular> titular;

}
