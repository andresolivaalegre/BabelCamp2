package service;

import java.util.Date;
import java.util.List;

import dto.CuentaDto;
import dto.MovimientoDto;

public interface CajeroService {
	CuentaDto validarCuenta(int numeroCuenta);
	boolean transferencia(int numeroCuenta1, int numeroCuenta2, int cantidad);
	List<MovimientoDto> consultarMovimientos(int numeroCuenta, Date f1, Date f2);
	boolean ingreso(int numeroCuenta, int cantidad);
	boolean extraccion(int numeroCuenta, int cantidad);
	boolean insertarMovimiento(int idCuenta, Date fecha, int cantidad, String operacion);

}
