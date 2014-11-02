package pl.passus.test.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import pl.passus.app.dao.RecordDAO;
import pl.passus.app.dao.factory.RecordDAOFactory;
import pl.passus.app.model.Record;

public class RecordDAOTest {

	@Test
	public void listTest() {
		
		RecordDAO dao = RecordDAOFactory.getMongoInstance();
		List<Record> list = dao.list();
		System.out.println("list size = "+list.size());
		
	}
	
	@Test
	public void listThenAddThenListTest() {
		
		RecordDAO dao = RecordDAOFactory.getMongoInstance();
		
		for(int i=0; i<3; i++){ // kilka wstawieñ, bo mo¿e siê wywalic w drugim obrocie
			List<Record> list1 = dao.list();
			System.out.println("list 1 size = "+list1.size());
			
			Record record = new Record();
			record.setData(new HashMap<String, String>());
			record.setTime(new Date().toString());
			
			dao.add(record);
			
			List<Record> list2 = dao.list();
			System.out.println("list 2 size = "+list2.size());
			
			assertEquals(list1.size()+1, list2.size());
			
			Record recordFromDB = list2.get(list2.size()-1);
			assertEquals(recordFromDB.getTime(), record.getTime());
		}
	}

}
