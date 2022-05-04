package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="movimientos")
public class Movimiento {
	@Id
	private int idMovimiento;
	private int idCuenta;
	private Date fecha;
	private int cantidad;
	private String operacion;
	
	public Movimiento(int idCuenta, Date fecha, int cantidad, String operacion) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
		this.idCuenta=idCuenta;
	}


public Movimiento(int idMovimiento, int idCuenta, Date fecha, int cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}


@ManyToOne()
@JoinColumn(name = "idCuenta", referencedColumnName = "numeroCuenta", insertable=false, updatable=false)
Cuenta cuenta;

}