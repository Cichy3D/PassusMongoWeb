package pl.passus.app.util;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoUtil {

	public static String DATABASE_HOST = "localhost";
	public static String DATABASE_NAME = "passus";
	
	private static DB db = null;
	
	public static DB getMongoDBSession(){
		if(db!=null) return db;
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( DATABASE_HOST );
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		db = mongoClient.getDB(DATABASE_NAME);
		return db;
	}
	
}
