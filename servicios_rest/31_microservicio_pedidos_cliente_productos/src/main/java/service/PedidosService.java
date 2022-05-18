package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {

	List<Pedido> pedidos();
	void altaPedido(Pedido p);
	
	
}
