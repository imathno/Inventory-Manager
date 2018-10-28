package org.spuracing.invman.gui;

import org.spuracing.invman.Constants;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InvManApplication extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(Constants.GUI_TITLE);
		BorderPane root = new BorderPane(new Label("Welcome!"));
	    Scene scene = new Scene(root);
	    stage.setWidth(800);
	    stage.setHeight(600);
	    stage.setScene(scene);
		stage.show();
	}

}
