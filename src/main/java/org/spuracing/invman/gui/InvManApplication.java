package org.spuracing.invman.gui;

import org.spuracing.invman.Constants;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InvManApplication extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(Constants.GUI_TITLE);
		StackPane root = new StackPane();
		Button update = new Button("Update");
		TextField textBox = new TextField();
		textBox.setPrefWidth(4);
		root.getChildren().add(textBox);
	    root.getChildren().add(update);
	    StackPane.setAlignment(textBox, Pos.CENTER_LEFT);
	    StackPane.setAlignment(update, Pos.CENTER_RIGHT);
	    Scene scene = new Scene(root, 800, 600);
	    stage.setScene(scene);
	    
		stage.show();
	}

}
