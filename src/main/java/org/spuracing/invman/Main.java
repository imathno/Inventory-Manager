package org.spuracing.invman;

import org.spuracing.invman.db.DynamoDBManager;
import org.spuracing.invman.db.DynamoTableReader;
import org.spuracing.invman.gui.InventoryManagerApplication;
import org.spuracing.invman.gui.InventoryManagerApplicationPreloader;

import com.sun.javafx.application.LauncherImpl;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main {

	public static void main(String[] args) throws Exception {
//		DynamoDBManager manager = DynamoDBManager.getInstance();
//		manager.setTable(Constants.TABLE_NAME);
//		manager.addItemToTable("Wrench", 8089);
//		manager.addItemToTable("Jack Hammer", 432);
//		manager.addItemToTable("Saw", 542);
//		manager.addItemToTable("Screwdriver", 3254);
//		manager.addItemToTable("Nitrous", 38093);
		DynamoDBManager.getInstance().setTable(Constants.TABLE_NAME);
		DynamoTableReader reader = new DynamoTableReader(DynamoDBManager.getInstance().getTable());
		System.out.println(reader.getItemQuantity(Constants.PRIMARY_KEY, "Wrench"));
//		LauncherImpl.launchApplication(InventoryManagerApplication.class, InventoryManagerApplicationPreloader.class, args);
	}

}
