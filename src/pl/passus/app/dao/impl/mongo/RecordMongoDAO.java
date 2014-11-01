package pl.passus.app.dao.impl.mongo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.json.simple.JSONObject;

import pl.passus.app.dao.RecordDAO;
import pl.passus.app.model.Record;
import pl.passus.app.util.MongoUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class RecordMongoDAO implements RecordDAO {


	@Override
	public Record get(String field, String val) {
		
		DB db = MongoUtil.getMongoDBSession();
		BasicDBObject query = new BasicDBObject(field, val);
		DBCursor cursor = db.getCollection("rekordy").find(query).limit(1);
		for(DBObject dbObject : cursor){
			return parseRecord(dbObject);
		}
		return null;
	}

	@Override
	public List<Record> list() {
		
		DB db = MongoUtil.getMongoDBSession();
		List<Record> lista = new LinkedList<>();
		
		DBCursor cursor = db.getCollection("rekordy").find();
		for(DBObject dbObject : cursor){
			Record r = parseRecord(dbObject);
			lista.add(r);
		}
		return lista;
	}

	public Record parseRecord(DBObject dbObject) {
		JSONObject o = new JSONObject(dbObject.toMap());
		Record r = new Record();
		r.setTime   ((String)o.get("time"));
		Map<String, String> dataMap = new HashMap<>();
		r.setData(dataMap);
		for(Object key: o.keySet()) 
			if(!"time".equals(key)){
				Object val = o.get(key);
				if(!(val instanceof ObjectId)){
					dataMap.put(key.toString(), val.toString());
				}
			}
		
		return r;
	}

	@Override
	public boolean add(Record rekord) {
		
		Map<String, String> recordMap = new HashMap<>();
		recordMap.putAll(rekord.getData());
		recordMap.put("time",rekord.getTime());
		
		DBObject o = new BasicDBObject(recordMap);
		
		DB db = MongoUtil.getMongoDBSession();
		WriteResult result = db.getCollection("rekordy").insert(o);
		
		System.out.println("inserted: "+result.getN());
		if(result.getN()>0){
			return true;
		} else {
			return false;
		}
		
		
	}

}
