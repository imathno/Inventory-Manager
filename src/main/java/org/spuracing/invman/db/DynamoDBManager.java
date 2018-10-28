package org.spuracing.invman.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spuracing.invman.Constants;
import org.spuracing.invman.utils.StringUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class DynamoDBManager {
	
	private static DynamoDBManager instance = null;
	
	private AmazonDynamoDB client;
	private DynamoDB database;
	private Table table;
	
	private DynamoDBManager() throws Exception {
		init();
	}
	
	public void init() throws Exception {	
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct location",
                    e);
        }
        
		client = AmazonDynamoDBClientBuilder.standard()
	            .withCredentials(credentialsProvider)
	            .withRegion(Constants.SERVER_REGION)
	            .build();

		database = new DynamoDB(client);
	}

	public void setTable(String tableName) {
		table = database.getTable(tableName);
	}
	
	public PutItemOutcome addItemToTable(String item, int quantity) {
		if (quantity < 0) {
			throw new RuntimeException("Cannot have a negative quantity");
		}
		
		Map<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("Quantity", quantity);
		item = StringUtils.capatilizeFirstLetter(item);
		
		return table.putItem(new Item().withPrimaryKey(Constants.PRIMARY_KEY, item).withMap("Info", infoMap));
	}
	
	public DeleteItemOutcome removeItemFromTable(String item) {
		item = StringUtils.capatilizeFirstLetter(item);
		return table.deleteItem(new DeleteItemSpec().withPrimaryKey(Constants.PRIMARY_KEY, item));
	}
	
	public PutItemOutcome updateItemFromTable(String item, int quantity) {
		return addItemToTable(item, quantity);
	}
	
	public DynamoDB getDatabase() {
		return database;
	}
	
	public Table getTable() {
		return table;
	}
	
	public static DynamoDBManager getInstance() throws Exception {
		if (instance == null) {
			instance = new DynamoDBManager();
		}
		return instance;
	}
}
