package net.codejava;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoIterable;

public class App {

	public static void main(String[] args) {
		MongoClient mongoClient = MongoClients.create();
	
//		MongoIterable<String> dbNames = mongoClient.listDatabaseNames();
//		for (String dbName : dbNames) {
//			System.out.println(dbName);
//		}
	}
}
