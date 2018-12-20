package br.com.abasteceaqui.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionManager {
	
	private static ConectionManager dao;
	private EntityManagerFactory factory;
	
	private ConectionManager() {
		factory = Persistence.createEntityManagerFactory("abastece_aqui");
	}
	
	public static ConectionManager getInstance() {
		if(dao == null) {
			dao = new ConectionManager();
		}
		
		return dao;
	}
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
