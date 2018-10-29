package org.spuracing.invman.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class InventoryManagerApplicationController implements Initializable {

	@FXML
	private TextField itemField;

	@FXML
	protected void onEnter(ActionEvent event) {
		System.out.println("Something happened");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] arr = {"Umm", "Hey", "bye"};
		TextFields.bindAutoCompletion(itemField, arr);
	}
}
