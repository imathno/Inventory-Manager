package org.spuracing.invman.gui;

import org.spuracing.invman.Constants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InventoryManagerApplication extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Application_Form.fxml"));
		stage.setTitle(Constants.GUI_TITLE);
		stage.setScene(new Scene(root, 800, 600));
		stage.show();
	}

}
