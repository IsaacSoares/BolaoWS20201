package br.edu.uniateneu.bolao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static EntityManagerFactory emf;

	private HibernateUtil() {
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			try {
				emf  = Persistence.createEntityManagerFactory("Bolao");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return emf;
	}
	
	public static void main(String[] args) {
		EntityManagerFactory em = getEntityManagerFactory();
		//em.close();
	}

}
