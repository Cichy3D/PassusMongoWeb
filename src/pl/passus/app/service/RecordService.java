package pl.passus.app.service;

import java.io.Serializable;
import java.util.List;

import pl.passus.app.dao.RecordDAO;
import pl.passus.app.dao.factory.RecordDAOFactory;
import pl.passus.app.model.Record;

public class RecordService implements Serializable {

	private static final long serialVersionUID = -3664385458882109379L;

	public List<Record> getRecordList(){
		RecordDAO dao = RecordDAOFactory.getMongoInstance();
		List<Record> lista = dao.list();
		return lista;
	}
	
}
