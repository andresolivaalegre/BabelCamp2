package dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Movimiento;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CuentaDto {
	private int numeroCuenta;
	private int saldo;
	private String tipoCuenta;
	
	public CuentaDto(int numeroCuenta, int saldo, String tipoCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}

	private List<Movimiento> movimientos;
}
