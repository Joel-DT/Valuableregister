package eng.vers;
/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Inlämningsuppgift 1 -  Del 2
* @version: 1.22
*/

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

public class InDialogAppliance extends Alert {
	private TextField tfName = new TextField();
	private TextField tfPrice = new TextField();
	private Slider slWear;

	public InDialogAppliance() {
		super(AlertType.CONFIRMATION);
		GridPane grid = new GridPane();
		slWear = createSlider();
		Label lbName = new Label("Name:");
		lbName.setStyle("-fx-font-weight: BOLD");
		Label lbPrice = new Label("Price:");
		lbPrice.setStyle("-fx-font-weight: BOLD");
		Label lbWear = new Label("State:");
		lbWear.setStyle("-fx-font-weight: BOLD");
		grid.addRow(0, lbName, tfName);
		grid.addRow(1, lbPrice, tfPrice);
		grid.addRow(2, lbWear, slWear);
		Tooltip ttNameField = new Tooltip("Enter the appliance name");
		Tooltip ttPriceField = new Tooltip("Enter purchased price as a decimal ex. 1234.99");
		Tooltip ttWearSlider = new Tooltip("State the condition of the appliance: 1 -- 10, where 10 is brand new");
		tfName.setTooltip(ttNameField);
		tfPrice.setTooltip(ttPriceField);
		slWear.setTooltip(ttWearSlider);
		grid.setVgap(3);
		grid.setHgap(3);
		getDialogPane().setContent(grid);
		setHeaderText(null);
	}
	

	private Slider createSlider() {
		slWear = new Slider(1, 10, 5);
		slWear.setMajorTickUnit(1.0);
		slWear.setMinorTickCount(0);
		slWear.setShowTickMarks(true);
		slWear.setShowTickLabels(true);
		slWear.setSnapToTicks(true);
		return slWear;
	}
	
	
	public String getNameField() {
		return tfName.getText();
	}

	
	public double getPriceField() {
		return Double.parseDouble(tfPrice.getText());
	}

	
	public int getSliderField() {
		return (int)(slWear.getValue()); 
	}
	
	
}
