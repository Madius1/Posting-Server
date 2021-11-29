package jku;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class Main {

	public static void main(String[] args) throws UnknownHostException {
		//Post-Einträge 
		//(Mood, Text, Timestamp, 
		//		 UserID, Hashtags, Erwähnungen)
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		
		DB database = mongoClient.getDB("postings");
		DBCollection collection = database.getCollection("posting");
		Post post = new Post("sad","i am sad", new Timestamp(123), "1", new ArrayList<String>(), new ArrayList<String>());
		
		collection.insert(post.toDBObject());
		List<DBObject> all = collection.find().toArray();
		System.out.println(all.toString());
		
		
	}
}
