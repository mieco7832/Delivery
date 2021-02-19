package com.delivery.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.entity.Ruta;
import com.delivery.utils.Abs;
import com.delivery.utils.Dao;

@Repository
@Transactional
public class RutaImpl extends Abs<Ruta> implements Dao<Ruta>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RutaImpl() {
		super(Ruta.class);
	}
	
	@Override
	public SessionFactory getSF() {
		return sessionFactory;
	}
	
	public List<Ruta> getEstado(){
		String script = "SELECT r FROM Ruta r INNER JOIN r.motociclista m INNER JOIN r.pedido p INNER JOIN m.personal u GROUP BY r.motociclista";
		TypedQuery<Ruta> query = sessionFactory.getCurrentSession().createQuery(script, Ruta.class);
		return query.getResultList();
	}
	
}
