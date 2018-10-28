package org.spuracing.invman.gui;

import org.spuracing.invman.Constants;

import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InvManPreloader extends Preloader {

	private Stage preloaderStage;
	
	@Override
	public void start(Stage preloaderStage) throws Exception {
		this.preloaderStage = preloaderStage;
		VBox loading = new VBox(20);
		loading.setMaxWidth(Region.USE_PREF_SIZE);
	    loading.setMaxHeight(Region.USE_PREF_SIZE);
	    loading.getChildren().add(new ProgressBar());
	    loading.getChildren().add(new Label("Please wait..."));
	    
	    BorderPane root = new BorderPane(loading);
	    Scene scene = new Scene(root);
	 
	    preloaderStage.setTitle(Constants.GUI_TITLE);
	    preloaderStage.setWidth(800);
	    preloaderStage.setHeight(600);
	    preloaderStage.setScene(scene);
	    preloaderStage.show();
	}

	 @Override
	  public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
	     if (stateChangeNotification.getType() == Type.BEFORE_START) {
	        preloaderStage.hide();
	     }
	  }
}
