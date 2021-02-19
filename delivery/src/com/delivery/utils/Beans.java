package com.delivery.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.delivery.repository.*;

@Configuration
public class Beans {
	//Repositorios
	@Bean
	public PersonalImpl perosonalImpl() {
		return new PersonalImpl();
	}

	@Bean
	public SucursalImpl sucursalImpl() {
		return new SucursalImpl();
	}
	
	@Bean
	public TurnoImpl turnoImpl() {
		return new TurnoImpl();
	}
	
	@Bean
	public UnidadImpl unidadImpl() {
		return new UnidadImpl();
	}
	
	@Bean
	public MotoristaImpl motoristaImpl() {
		return new MotoristaImpl();
	}
	
	@Bean
	public PedidoImpl pedidoImpl() {
		return new PedidoImpl();
	}
	
	@Bean
	public RutaImpl rutaImpl() {
		return new RutaImpl();
	}
}
