package dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Cuenta;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovimientoDto {
	private int idMovimiento;
	private int idCuenta;
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date fecha;
	private int cantidad;
	private String operacion;
	
	
	public MovimientoDto(int idMovimiento, int idCuenta, Date fecha, int cantidad, String operacion) {
		super();
		this.idMovimiento = idMovimiento;
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
	}


	public MovimientoDto(int idCuenta, Date fecha, int cantidad, String operacion, Cuenta cuenta) {
		super();
		this.idCuenta = idCuenta;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.operacion = operacion;
		this.cuenta = cuenta;
	}


	private Cuenta cuenta;

}
