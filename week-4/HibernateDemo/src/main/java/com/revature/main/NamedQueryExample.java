package com.revature.main;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Pirate;
import com.revature.utils.SessionUtility;

public class NamedQueryExample {

	public static void main(String[] args) {
		// In Hibernate, we can create HQL "templates" that are configured either inside of xml configuration or entity mapping
		// annotations
		Session session = SessionUtility.getSessionFactory().openSession();
		
		List<Pirate> pirates = session.createNamedQuery("getPiratesByShipId")
			.setParameter("id", 1).getResultList();
		
		System.out.println(pirates);
	}

}
