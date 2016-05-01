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

import domain.Home;
import domain.Person;
import jpa.EntityManagerHelper;

@Path("/homes")
public class HomeService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Home> getlistHeater(){
		List<Home> hs = EntityManagerHelper.getEntityManager().createQuery("Select h from Home h ", Home.class).getResultList();

		EntityManagerHelper.closeEntityManager();
		return hs;
	}
	
	@Path("/ajouter")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Home create(Home h){
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(h);
		t.commit();
		EntityManagerHelper.closeEntityManager();
		return h;
	}
}
