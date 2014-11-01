package pl.passus.app.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.passus.app.dao.RecordDAO;
import pl.passus.app.dao.factory.RecordDAOFactory;
import pl.passus.app.dao.impl.mongo.RecordMongoDAO;
import pl.passus.app.model.Record;

/**
 * Servlet implementation class Hello
 */
@WebServlet({ "/Hello", "/hello" })
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Hello!");
		System.out.println("Buu");
		
		RecordDAO dao = RecordDAOFactory.getMongoInstance();
		List<Record> lista = dao.list();
		response.getWriter().println(lista);
		
		
		System.out.println("End");
		
		
		response.sendRedirect("records.vm");
	}
	


}
