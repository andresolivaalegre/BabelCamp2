package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;

@Service
public class PedidosServicesImpl implements PedidosService{

	RestTemplate template;
	String urlBase="http://servicio-productos/";
	PedidosDao pedidosDao;
	
	public PedidosServicesImpl(@Autowired RestTemplate template, PedidosDao pedidosDao) {
		super();
		this.pedidosDao = pedidosDao;
		this.template = template;
	}
	
	@Override
	public List<Pedido> pedidos() {
		return pedidosDao.findAll();
	}
	
	@Override
	public void altaPedido(Pedido p) {
		pedidosDao.save(p);
		template.put(urlBase+"ActualizarStock?codigoProducto="+p.getCodigoProducto()+"&unidades="+p.getUnidades(), Pedido.class);
	}


}
