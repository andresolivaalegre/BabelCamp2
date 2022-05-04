package testing;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import config.ServiceConfig;
import service.CajeroService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ServiceConfig.class})

public class TestCajeroService {
	@Autowired 
	CajeroService service;
	
	@Test
	void testValidarCuenta() {
		assertEquals(1000, service.validarCuenta(1000).getNumeroCuenta());
	}
	
	@Test
	void testIngreso() {
		assertEquals(true, service.ingreso(1000, 100));
	}
	
	@Test
	void testExtraccion() {
		assertEquals(true, service.extraccion(1000, 200));
	}
	
	@Test
	void testTransferencia() {
		assertEquals(true, service.transferencia(1000,1234, 200));
	}
	
	@Test
	void testMovimientos() {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(2020, 8 ,20);
		c2.set(2022, 8 ,20);
		Date f1=c1.getTime();
		Date f2=c2.getTime();
		assertEquals(26, service.consultarMovimientos(1000,f1, f2).size());
	}
}
