package com.delivery.repository;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.delivery.entity.Personal;
import com.delivery.utils.Abs;
import com.delivery.utils.Dao;

@Repository
@Transactional
public class PersonalImpl extends Abs<Personal> implements Dao<Personal>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PersonalImpl() {
		super(Personal.class);
	}

	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
}
