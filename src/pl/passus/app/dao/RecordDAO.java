package pl.passus.app.dao;

import java.util.List;

import pl.passus.app.model.Record;

public interface RecordDAO {

	public Record get(String field, String value);
	public List<Record> list();
	public boolean add(Record rekord);
	
	
}
