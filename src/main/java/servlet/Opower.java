package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ElectronicDevices;
import domain.Heaters;
import domain.Home;
import domain.Person;
import domain.SmartDevices;
import jpa.EntityManagerHelper;

@WebServlet(name="opower",
urlPatterns={"/Opower"})
public class Opower extends HttpServlet {
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");

PrintWriter out = response.getWriter();


out.println("<HTML>\n<BODY>\n" +
		"<H1>Affichage des informations</H1>\n" +
		"<UL>\n" +			
" <LI>Nom: "
		+ request.getParameter("nom") + "\n" +
		" <LI>Prenom: "
		+ request.getParameter("prenom") + "\n" +
		" <LI>Email: "
		+ request.getParameter("email") + "\n" +
		" <LI>Maison: "
		+ request.getParameter("maison") + "\n" +
		"</UL>\n" +				
"</BODY></HTML>");

	//test
	EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
	tx.begin();
	try {
		Home home0 = new Home("residence principale",300,10);
		Heaters C1 = new Heaters("chauffage cuisine", 150, home0);
		Heaters C2 = new Heaters("chauffage salon", 200, home0);
		ElectronicDevices Ed1= new ElectronicDevices("Tv", 20, home0);
		ElectronicDevices Ed2= new ElectronicDevices("Tel", 50, home0);
		
		List<SmartDevices> listConsoChauffage = new ArrayList<SmartDevices>();
		listConsoChauffage.add(C1);
		listConsoChauffage.add(C2);
		List<SmartDevices> listConsoED = new ArrayList<SmartDevices>();
		listConsoED.add(Ed1);
		listConsoED.add(Ed2);
		home0.setElectronicDevices(listConsoED);
		home0.setHeaters(listConsoChauffage);
		List<Home> homes = new ArrayList<Home>();
		homes.add(home0);
		Person personne = new Person(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), homes);
		EntityManagerHelper.getEntityManager().persist(home0);
		EntityManagerHelper.getEntityManager().persist(C1);
		EntityManagerHelper.getEntityManager().persist(C2);
		EntityManagerHelper.getEntityManager().persist(Ed1);
		EntityManagerHelper.getEntityManager().persist(Ed2);
		EntityManagerHelper.getEntityManager().persist(personne);
	} catch (Exception e) {
		e.printStackTrace();
	}
	tx.commit();

	out.println("Enregistrement effectué</BODY></HTML>");
}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String query = "select p from Person as p";
		List result2 = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
		out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"<UL>\n");
				for (Object enregistrement : result2) {
					out.println("<LI> enregistrement : " + enregistrement+"\n");
				}
				out.println("</UL>\n" +				
				"</BODY></HTML>");
	}
}