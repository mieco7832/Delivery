package com.delivery.utils;

import javax.sql.DataSource;
import java.util.Properties;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class Configs {
	
	@Bean
	public DataSource getData() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/delivery?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	
	private Properties getPro() {
		Properties p = new Properties();
		p.setProperty("hibernet.dialect","org.hibernate.dialect.MySQLDialect");
		return p;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sF = new LocalSessionFactoryBean();
		sF.setDataSource(getData());
		sF.setHibernateProperties(getPro());
		sF.setPackagesToScan("com.delivery.entity");
		return sF;
	}
	
	@Bean
	public PlatformTransactionManager getTrans() {
		HibernateTransactionManager  hib = new HibernateTransactionManager();
		hib.setSessionFactory(sessionFactory().getObject());
		return hib;
	}

}
