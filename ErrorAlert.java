/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Assignment 1 -  Part 2
* @version: 2.1
*/

import javafx.scene.control.Alert;

/**
 * Shows a customized Alert-box for displaying errors *
 */
public class ErrorAlert {

	public void showNameError() {
		alertBox("Error: Name cannot be empty!");
	}
	
	public void showNumberError() {
		alertBox("Error: Wrong numerical value!");
	}

	public void showIllegalValue() {
		alertBox("Error: Value can not be 0 or negative number!");
	}
	
	private void alertBox(String errorText) {
		Alert alert = new Alert(Alert.AlertType.ERROR, errorText);
		alert.getDialogPane().setHeaderText(null);
		alert.getDialogPane().setStyle("-fx-background-color: ORANGE; -fx-font-size: 15");
		alert.show();
	}
}
