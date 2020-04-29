package eng.vers;
/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Inlämningsuppgift 1 -  Del 2
* @version: 1.22
*/

import javafx.scene.control.Alert;

/**
 * Shows a customized Alert-box for displaying error
 *
 */
public class ErrorAlert {

	public void showNameError() {
		Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Name cannot be empty!");
		alert.getDialogPane().setHeaderText(null);
		alert.getDialogPane().setStyle("-fx-background-color: ORANGE; -fx-font-size: 15");
		alert.show();
	}
	
	public void showNumberError() {
		Alert alert = new Alert(Alert.AlertType.ERROR, "Error: Wrong numerical value!");
		alert.getDialogPane().setHeaderText(null);
		alert.getDialogPane().setStyle("-fx-background-color: ORANGE; -fx-font-size: 15");
		alert.show();
	}
}
