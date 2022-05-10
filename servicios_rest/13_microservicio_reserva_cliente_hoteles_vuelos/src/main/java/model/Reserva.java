package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="reservas")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;
	public Reserva(String nombre, int dni, int hotel, int vuelo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.hotel = hotel;
		this.vuelo = vuelo;
	}
	private String nombre;
	private int dni;
	private int hotel;
	private int vuelo;
}

