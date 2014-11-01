package pl.passus.app.dao.factory;

import pl.passus.app.dao.RekordDAO;
import pl.passus.app.dao.impl.mongo.RekordMongoDAO;

public class RekordDAOFactory {

	public static RekordDAO getMongoInstance(){
		return new RekordMongoDAO();
	}
		
}
