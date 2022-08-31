package com.dxc.FactoryDesign;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
	private static final SessionFactory factory;
	
	static {
		factory = new Configuration().configure("/resource/hibernate.cfg.xml").buildSessionFactory();
	}
	
	public static SessionFactory getFactoryObject() {
		return factory;
	}
}
