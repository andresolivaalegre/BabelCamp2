package service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import converters.ConversorEntityDto;
import dao.CuentasDao;
import dao.MovimientosDao;
import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cuenta;
import model.Movimiento;

@Service
public class CajeroServiceImpl implements CajeroService {

	@Autowired
	ConversorEntityDto conversor;
	CuentasDao cuentasDao;
	MovimientosDao movimientosDao;
	
	public CajeroServiceImpl(@Autowired CuentasDao cuentasDao,@Autowired MovimientosDao movimientosDao) {
		this.cuentasDao=cuentasDao;
		this.movimientosDao=movimientosDao;
	}
	
	@Override
	public CuentaDto validarCuenta(int numeroCuenta) {
		return conversor.cuentaToDto(cuentasDao.findById(numeroCuenta));
	}

	@Override
	public boolean ingreso(int numeroCuenta, int cantidad) {
		Cuenta cuenta=cuentasDao.findById(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		Date fecha = new Date();
		Movimiento movimiento=new Movimiento(numeroCuenta, fecha , cantidad, "ingreso");
		if(cuenta!=null) {
			movimientosDao.save(movimiento);	
			cuentasDao.save(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public boolean extraccion(int numeroCuenta, int cantidad) {
		Cuenta cuenta=cuentasDao.findById(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo()-cantidad);
		Date fecha = new Date();
		Movimiento movimiento=new Movimiento(numeroCuenta, fecha , cantidad, "extraccion");
		if(cuenta!=null) {
			movimientosDao.save(movimiento);	
			cuentasDao.save(cuenta);
			return true;
		}
		return false;
	}

	@Override
	public boolean transferencia(int numeroCuenta1, int numeroCuenta2, int cantidad) {
		Cuenta cuenta1=cuentasDao.findById(numeroCuenta1);
		Cuenta cuenta2=cuentasDao.findById(numeroCuenta2);
		if(cuenta1!=null && cuenta2!=null) {
			extraccion(numeroCuenta1, cantidad);
			ingreso(numeroCuenta2, cantidad);
			return true;
		}
		return false;
	}

	@Override
	public List<MovimientoDto> consultarMovimientos(int numeroCuenta, Date f1, Date f2) {
		return movimientosDao.findMovimientosFechas(numeroCuenta, f1, f2)
				.stream()
				.map(m->conversor.movimientoToDto(m))
				.collect(Collectors.toList());
	}

	@Override
	public boolean insertarMovimiento(int idCuenta, Date fecha, int cantidad, String operacion) {
		movimientosDao.save(new Movimiento(idCuenta, fecha, cantidad, operacion));	
		return true;
	}

}
