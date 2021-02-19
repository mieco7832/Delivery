package com.delivery.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.entity.Unidad;
import com.delivery.utils.Abs;
import com.delivery.utils.Dao;

@Repository
@Transactional
public class UnidadImpl extends Abs<Unidad> implements Dao<Unidad>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UnidadImpl() {
		super(Unidad.class);
	}
	
	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
}
