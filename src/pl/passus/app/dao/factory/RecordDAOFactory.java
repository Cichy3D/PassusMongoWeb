package pl.passus.app.dao.factory;

import pl.passus.app.dao.RecordDAO;
import pl.passus.app.dao.impl.mongo.RecordMongoDAO;

public class RecordDAOFactory {

	public static RecordDAO getMongoInstance(){
		return new RecordMongoDAO();
	}
	
	/** przyk³¹d dla innej bazy danych */
	public static RecordDAO getMySQLInstance(){
		return null;
	}
	
	/** przyk³¹d dla zapisu do pliku */
	public static RecordDAO getFileInstance(){
		return null;
	}
		
}
