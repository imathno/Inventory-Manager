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
		DynamoTableReader reader = new DynamoTableReader(DynamoDBManager.getInstance().getTable());
		System.out.println(reader.getItemQuantity(Constants.PRIMARY_KEY, "D"));
		//LauncherImpl.launchApplication(InvManApplication.class, InvManPreloader.class, args);
	}

}
