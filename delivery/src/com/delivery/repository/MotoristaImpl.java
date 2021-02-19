package com.delivery.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.entity.Motociclista;
import com.delivery.entity.Sucursal;
import com.delivery.utils.Abs;
import com.delivery.utils.Dao;

@Repository
@Transactional
public class MotoristaImpl extends Abs<Motociclista> implements Dao<Motociclista>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public MotoristaImpl() {
		super(Motociclista.class);
	}
	
	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
}
