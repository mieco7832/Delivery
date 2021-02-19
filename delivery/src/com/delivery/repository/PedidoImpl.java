package com.delivery.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.entity.Pedido;
import com.delivery.utils.Abs;
import com.delivery.utils.Dao;

@Repository
@Transactional
public class PedidoImpl  extends Abs<Pedido> implements Dao<Pedido>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PedidoImpl() {
		super(Pedido.class);
	}
	
	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
	
}
