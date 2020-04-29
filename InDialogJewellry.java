/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Assignment 1 -  Part 2
* @version: 1.30
*/

import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class InDialogJewellry extends Alert {

	private TextField tfName = new TextField();
	private TextField tfStones = new TextField();
	private CheckBox cbMaterial = new CheckBox();

	public InDialogJewellry() {
		super(AlertType.CONFIRMATION);
		GridPane grid = new GridPane();
		Label lbName = new Label("Name:");
		lbName.setStyle("-fx-font-weight: BOLD");
		Label lbStones = new Label("Stones:");
		lbStones.setStyle("-fx-font-weight: BOLD");
		Label lbGold = new Label("Of gold");
		lbGold.setStyle("-fx-font-weight: BOLD");
		FlowPane pane = new FlowPane();
		pane.setHgap(5);
		pane.setPrefWidth(50);
		pane.getChildren().addAll(cbMaterial, lbGold);
		grid.addRow(0, lbName, tfName);
		grid.addRow(1, lbStones, tfStones);
		grid.add(pane, 1, 2);
		Tooltip ttNameField = new Tooltip("Enter the name of the jewellery");
		Tooltip ttPriceField = new Tooltip("Enter the number of gemstones as an integer");
		Tooltip ttWearField = new Tooltip("Select if jewellery is made out of gold");
		tfName.setTooltip(ttNameField);
		tfStones.setTooltip(ttPriceField);
		cbMaterial.setTooltip(ttWearField);
		grid.setVgap(3);
		grid.setHgap(3);
		getDialogPane().setContent(grid);
		setHeaderText(null);
	}
	

	public String getNameField() {
		return tfName.getText();
	}

	
	public int getStoneField() {
		return Integer.parseInt(tfStones.getText());
	}

	
	public boolean getCbMaterial() {
		return cbMaterial.isSelected();
	}

	
}
