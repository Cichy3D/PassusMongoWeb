package pl.passus.app.dao.impl.mongo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;

import pl.passus.app.dao.RekordDAO;
import pl.passus.app.model.Rekord;
import pl.passus.app.util.MongoUtil;

import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class RekordMongoDAO implements RekordDAO {


	@Override
	public Rekord get(String pole) {
		

		
		return null;
	}

	@Override
	public List<Rekord> list() {
		
		DB db = MongoUtil.getMongoDBSession();
		List<Rekord> list = new LinkedList<>();
		
		DBCursor cursor = db.getCollection("rekordy").find();
		for(DBObject dbObject : cursor){
			//System.out.println(dbObject.toString());
			JSONObject o = new JSONObject(dbObject.toMap());
			System.out.println(o.get("pole"));
			System.out.println(o.get("wartosc"));
			System.out.println(o.get("czas"));
		}
		
		
		return null;
	}

	@Override
	public boolean add(Rekord rekord) {
		// TODO Auto-generated method stub
		return false;
	}

}
