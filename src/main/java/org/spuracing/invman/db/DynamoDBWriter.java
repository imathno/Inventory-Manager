package org.spuracing.invman.db;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

public class DynamoDBWriter {

	private final AmazonDynamoDB DB;
	
	public DynamoDBWriter(AmazonDynamoDB db) {
		DB = db;
	}
	
	public void write() {
		
	}
}
