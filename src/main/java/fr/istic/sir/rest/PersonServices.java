package fr.istic.sir.rest;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Heaters;
import domain.Person;
import jpa.EntityManagerHelper;

@Path("/personnes")
public class PersonServices {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Person> getlistHeater(){
		List<Person> hs = EntityManagerHelper.getEntityManager().createQuery("Select p from Person p ", Person.class).getResultList();

		EntityManagerHelper.closeEntityManager();
		return hs;
	}
	
	@Path("/ajouter")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Person create(Person p){
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(p);
		t.commit();
		EntityManagerHelper.closeEntityManager();
		return p;
	}
	
}
