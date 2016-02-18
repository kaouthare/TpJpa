package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Heaters;
import domain.Home;
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
		"</UL>\n" +				
"</BODY></HTML>");

	//test
	EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
	tx.begin();
	try {
		Home home0 = new Home(3,100);
		Heaters heater6=new Heaters(200, home0);
		EntityManagerHelper.getEntityManager().persist(home0);
		EntityManagerHelper.getEntityManager().persist(heater6);
	} catch (Exception e) {
		e.printStackTrace();
	}
	tx.commit();

	out.println("Enregistrement effectué</BODY></HTML>");
}
}