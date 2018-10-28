package org.spuracing.invman;

import org.spuracing.invman.db.DynamoDBManager;
import org.spuracing.invman.db.DynamoTableReader;
import org.spuracing.invman.gui.InvManApplication;
import org.spuracing.invman.gui.InvManPreloader;

import com.sun.javafx.application.LauncherImpl;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main {

	public static void main(String[] args) throws Exception {
//		DynamoDBManager manager = DynamoDBManager.getInstance();
//		manager.setTable(Constants.TABLE_NAME);
//		manager.addItemToTable("Wrench", 832089);
//		manager.addItemToTable("Jack Hammer", 432);
//		manager.addItemToTable("Saw", 542);
//		manager.addItemToTable("Screwdriver", 3254);
//		manager.addItemToTable("Nitrous", 38093);
//		DynamoTableReader reader = new DynamoTableReader(DynamoDBManager.getInstance().getTable());
//		System.out.println(reader.getItemQuantity(Constants.PRIMARY_KEY, "D"));
		LauncherImpl.launchApplication(InvManApplication.class, InvManPreloader.class, args);
	}

}
