package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.CuentaDto;
import dto.MovimientoDto;
import service.CajeroService;
@CrossOrigin("*")
@Controller
public class CajeroController {
	@Autowired
	CajeroService service;
	
	@PostMapping("Cuenta")
	public String autenticar(@RequestParam("numeroCuenta") int numeroCuenta, HttpServletRequest request) {
		CuentaDto cuenta=service.validarCuenta(numeroCuenta);
		if(cuenta!=null) {
			return "menu";
		}else {
			return "inicioFallo";
		}
	}
	
	@GetMapping(value="Movimientos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<MovimientoDto> matriculas(@RequestParam("fechaIni") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaIni, 
														@RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin, 
														@RequestParam("numeroCuenta") int numeroCuenta){		
			return service.consultarMovimientos(numeroCuenta, fechaIni, fechaFin);		
	}
	
	@PostMapping("Ingreso")
	public String ingreso(@RequestParam("numeroCuenta") int numeroCuenta, @RequestParam("cantidad") int cantidad) {
		System.out.println(numeroCuenta);
		return service.ingreso(numeroCuenta, cantidad)?"menu":"ingreso";
	}
	
	@PostMapping("Extraccion")
	public String extraccion(@RequestParam("numeroCuenta") int numeroCuenta, @RequestParam("cantidad") int cantidad) {
		return service.extraccion(numeroCuenta, cantidad)?"menu":"extraccion";
	}
	
	@PostMapping("Transferencia")
	public String transferencia(@RequestParam("numeroCuenta1") int numeroCuenta1, @RequestParam("numeroCuenta2") int numeroCuenta2, @RequestParam("cantidad") int cantidad) {
		return service.ingreso(numeroCuenta1, cantidad) && service.extraccion(numeroCuenta2, cantidad)?"menu":"transferencia";
	}
}
