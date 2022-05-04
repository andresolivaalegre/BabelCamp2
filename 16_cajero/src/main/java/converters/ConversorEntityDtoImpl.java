package converters;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import dto.ClienteDto;
import dto.CuentaDto;
import dto.MovimientoDto;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;
import model.Titular;

@Component
public class ConversorEntityDtoImpl implements ConversorEntityDto {

	@Override
	public ClienteDto clienteToDto(Cliente cliente) {
		return new ClienteDto(cliente.getDni(), cliente.getNombre(), cliente.getDireccion(), cliente.getTelefono());
	}

	@Override
	public Cliente dtoToCliente(ClienteDto dto) {
		return new Cliente(dto.getDni(), dto.getNombre(), dto.getDireccion(), dto.getTelefono(), new ArrayList<Titular>());
	}

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		return new CuentaDto(cuenta.getNumeroCuenta(), cuenta.getSaldo(), cuenta.getTipoCuenta());
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		return new Cuenta(dto.getNumeroCuenta(), dto.getSaldo(), dto.getTipoCuenta(), new ArrayList<Movimiento>());
	}

	@Override
	public MovimientoDto movimientoToDto(Movimiento movimiento) {
		return new MovimientoDto(movimiento.getIdMovimiento(), movimiento.getIdCuenta(), movimiento.getFecha(), movimiento.getCantidad(), movimiento.getOperacion());
	}

	@Override
	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		return new Movimiento(dto.getIdMovimiento(), dto.getIdCuenta(), dto.getFecha(), dto.getCantidad(), dto.getOperacion(), dto.getCuenta());
	}

	
	
	

}
