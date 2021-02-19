package com.delivery.repository;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.entity.Turno;
import com.delivery.utils.Abs;
import com.delivery.utils.Dao;

@Repository
@Transactional
public class TurnoImpl extends Abs<Turno> implements Dao<Turno>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public TurnoImpl() {
		super(Turno.class);
	}

	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
}
