/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Assignment 1 -  Part 2
* @version: 1.30
*/

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

public class InDialogStock extends Alert {
	private TextField tfName = new TextField();
	private TextField tfQuantity = new TextField();
	private TextField tfPrice = new TextField();

	public InDialogStock() {
		super(AlertType.CONFIRMATION);
		GridPane grid = new GridPane();
		Label lbName = new Label("Name:");
		lbName.setStyle("-fx-font-weight: BOLD");
		Label lbQuantity = new Label("Shares:");
		lbQuantity.setStyle("-fx-font-weight: BOLD");
		Label lbPrice = new Label("Rate:");
		lbPrice.setStyle("-fx-font-weight: BOLD");
		grid.addRow(0, lbName, tfName);
		grid.addRow(1, lbQuantity, tfQuantity);
		grid.addRow(2, lbPrice, tfPrice);
		Tooltip ttNameField = new Tooltip("Enter the name of the stock");
		Tooltip ttQuantity = new Tooltip("Enter the amount of shares as an integer");
		Tooltip ttPriceField = new Tooltip("Enter the cost per share as a decimal, ex. 15.50");
		tfName.setTooltip(ttNameField);
		tfQuantity.setTooltip(ttQuantity);
		tfPrice.setTooltip(ttPriceField);
		grid.setVgap(3);
		grid.setHgap(3);
		getDialogPane().setContent(grid);
		setHeaderText(null);
	}

	
	public String getNameField() {
		return tfName.getText();
	}

	
	public int getQuantityField() {
		return Integer.parseInt(tfQuantity.getText());
	}

	
	public double getPriceField() {
		return Double.parseDouble(tfPrice.getText());
	}

	
}
