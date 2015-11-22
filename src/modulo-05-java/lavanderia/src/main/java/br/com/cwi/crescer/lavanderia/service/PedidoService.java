package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Pedido;

@Service
public class PedidoService {
	
	private PedidoDao pedidoDao;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao){
		super();
		this.pedidoDao = pedidoDao;
	}
	
	public Pedido findById(Long id){
		return this.pedidoDao.findById(id);
	}
	
}
