package pl.passus.app.view;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.passus.app.dao.RecordDAO;
import pl.passus.app.dao.factory.RecordDAOFactory;
import pl.passus.app.model.Record;


@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecordServlet() {
        super();
   }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Record record = new Record();
		record.setData(new HashMap<String, String>());
		String[] keys = request.getParameterValues("key");
		String[] vals = request.getParameterValues("val");
		for(int i=0; i<keys.length && i<vals.length; i++){
			if(!keys[i].equals("")){
				record.getData().put(keys[i], vals[i]);
			}
		}
		record.setTime(new Date().toString());
		
		RecordDAO dao = RecordDAOFactory.getMongoInstance();
		dao.add(record);
		
		response.sendRedirect("/");
	}

}
