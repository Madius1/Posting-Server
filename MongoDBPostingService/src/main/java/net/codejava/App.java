package net.codejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class App {

	public static void main(String[] args) {

		// String uri= "mongodb://superuser:passw0rd@localhost";

		MongoClient mongoClient = MongoClients.create(/* uri */);

		MongoIterable<String> dbNames = mongoClient.listDatabaseNames();
		for (String dbName : dbNames) {
			System.out.println(dbName);
		}
		//Insert database/ collection/ document
		MongoDatabase db = mongoClient.getDatabase("codejava");
		MongoCollection<Document> inventory = db.getCollection("inventory");

		Document journal = new Document("name", "journal").append("qty", 25);
		List<Document> ratings = new ArrayList<>();
		
		Document size = new Document("height", 14).append("width", 21).append("unit", "cm");
		ratings.add(new Document("score", 9));
		journal.append("rating", ratings);
		journal.put("size", size);
		journal.put("status", "A");
		journal.append("tags", Arrays.asList("brown","lined"));
		inventory.insertOne(journal);
		//Search in Database
		FindIterable<Document> result = inventory.find(new Document("name","journal"));
		for(Document document : result) {
			System.out.println(document.toJson());
		}
	}
}
