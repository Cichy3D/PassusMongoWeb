package pl.passus.app.util;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoUtil {

	public static String DATABASE_HOST = "localhost";
	public static String DATABASE_NAME = "passus";
	
	public static DB getMongoDBSession(){
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( DATABASE_HOST );
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		DB db = mongoClient.getDB(DATABASE_NAME);
		return db;
	}
	
}
