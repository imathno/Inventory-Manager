package org.spuracing.invman.db;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class DynamoTableReader {
	
	private Table table;
	
	public DynamoTableReader(Table table) {
		this.table = table;
	}
	
	public int getItemQuantity(String primaryKey, String itemName) throws ParseException {
		GetItemSpec spec = new GetItemSpec().withPrimaryKey(primaryKey, itemName);
		Item item = table.getItem(spec);
		JSONObject jsonObject = (JSONObject) new JSONParser().parse(item.toJSON());
		jsonObject = (JSONObject) jsonObject.get("Info");
		return Math.toIntExact((Long)jsonObject.get("Quantity"));
	}
}
