package com.delivery.repository;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.entity.Sucursal;
import com.delivery.utils.Abs;
import com.delivery.utils.Dao;

@Repository
@Transactional
public class SucursalImpl extends Abs<Sucursal> implements Dao<Sucursal> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SucursalImpl() {
		super(Sucursal.class);
	}
	
	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
	
}
