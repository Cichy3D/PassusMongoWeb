package pl.passus.app.view;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecordServlet() {
        super();
   }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		for(Object paramObj : request.getParameterMap().keySet()){
			String paramName = (String) paramObj;
			for(String v : request.getParameterValues(paramName)){
				System.out.println(paramName+" : "+v);
			}
		}
		
		response.sendRedirect("records.vm");
	}

}
