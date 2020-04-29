package eng.vers;
/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Exercise 1 -  Part 2
* @version: 1.30
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainPane extends Application {

	private ArrayList<Valuable> valuables = new ArrayList<>();
	private TextArea textArea;
	private RadioButton rbNameAscend;
	private RadioButton rbNameDescend;
	private RadioButton rbValueAscend;
	private RadioButton rbValueDescend;
	private CheckBox cbAppliance;
	private CheckBox cbJewellery;
	private CheckBox cbStock;

	@Override
	public void start(Stage primaryStage) {

		// skapa en dummy-lista med värden för arraylist
		populateArray();

		FlowPane topPane = new FlowPane(createTopPane());

		VBox sortingPane = new VBox(createRightPane());

		textArea = new TextArea();
		textArea.setPadding(new Insets(3));
		textArea.setEditable(false);

		FlowPane bottomPane = new FlowPane(createBottomPane());

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(8));
		root.setStyle("-fx-background-color: gold");
		root.setTop(topPane);
		root.setRight(sortingPane);
		root.setCenter(textArea);
		root.setBottom(bottomPane);

		Scene scene = new Scene(root, 825, 420);
		primaryStage.setTitle("Register of Valuables");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private FlowPane createTopPane() {
		FlowPane topPane = new FlowPane();
		Label lbHeader = new Label("Valuables in your possession");
		lbHeader.setFont(Font.font("times New Roman", FontWeight.BOLD, 16));
		topPane.setPadding(new Insets(10));
		topPane.setAlignment(Pos.CENTER);
		topPane.setPrefWidth(815);
		topPane.getChildren().add(lbHeader);
		return topPane;
	}

	private FlowPane createBottomPane() {
		FlowPane bottomPane = new FlowPane();
		HBox hboxLeft = new HBox();
		Label lbNew = new Label("Add:");
		lbNew.setFont(Font.font("", FontWeight.BOLD, 12));
		MenuButton mbValuables = new MenuButton("Choose Valuable");
		MenuItem miJewellry = new MenuItem("Jewellery");
		MenuItem miStock = new MenuItem("Stocks");
		MenuItem miAppliance = new MenuItem("Appliances");
		Button btCrash = new Button("Stock market crash");
		mbValuables.getItems().addAll(miJewellry, miStock, miAppliance);
		btCrash.setAlignment(Pos.CENTER_RIGHT);
		hboxLeft.getChildren().addAll(lbNew, mbValuables);
		hboxLeft.setAlignment(Pos.CENTER);
		hboxLeft.setSpacing(5);
		bottomPane.getChildren().addAll(hboxLeft, btCrash);
		bottomPane.setPrefWidth(810);
		bottomPane.setHgap(200);
		bottomPane.setPadding(new Insets(10));

		Tooltip ttMenuButton = new Tooltip("Click to select the type of valuable you wish to add");
		Tooltip ttCrashButton = new Tooltip(
				"Click to cause stock market crash, WARNING: sets value of all shares to 0");
		mbValuables.setTooltip(ttMenuButton);
		btCrash.setTooltip(ttCrashButton);

		miJewellry.setOnAction(new JewellryHandler());
		miStock.setOnAction(new StockHandler());
		miAppliance.setOnAction(new ApplianceHandler());
		btCrash.setOnAction(new CrashHandler());

		return bottomPane;
	}

	private VBox createRightPane() {
		VBox sortingPane = new VBox();
		sortingPane.setPadding(new Insets(10));
		sortingPane.setSpacing(8);

		Label lbSorting = new Label("Sort by:");
		rbNameAscend = new RadioButton("Name \u25B2");
		rbNameDescend = new RadioButton("Name \u25BC");
		rbValueAscend = new RadioButton("Value \u25B2");
		rbValueDescend = new RadioButton("Value \u25BC");
		Button btShow = new Button("Show");
		btShow.setMaxWidth(Double.MAX_VALUE);
		lbSorting.setFont(Font.font("", FontWeight.BOLD, 12));
		sortingPane.getChildren().addAll(lbSorting, rbNameAscend, rbNameDescend, rbValueAscend, rbValueDescend, btShow);
		ToggleGroup group = new ToggleGroup();
		group.getToggles().addAll(rbNameAscend, rbNameDescend, rbValueAscend, rbValueDescend);
		rbNameAscend.setSelected(true);
		btShow.setOnAction(new ShowHandler());

		Separator separator = new Separator(Orientation.HORIZONTAL);
		Label lbDelete = new Label("Delete:");
		cbAppliance = new CheckBox("Appliance");
		cbJewellery = new CheckBox("Jewellery");
		cbStock = new CheckBox("Stock");
		Button btDelete = new Button("Delete");
		btDelete.setMaxWidth(Double.MAX_VALUE);
		lbDelete.setFont(Font.font("", FontWeight.BOLD, 12));
		sortingPane.getChildren().addAll(separator, lbDelete, cbAppliance, cbJewellery, cbStock, btDelete);
		btDelete.setOnAction(new DeleteHandler());

		Tooltip ttShow = new Tooltip("Display all the sorted items");
		Tooltip ttNameAscend = new Tooltip("Sort by namne in ascending order");
		Tooltip ttNameDescend = new Tooltip("Sort by namne in descending order");
		Tooltip ttValueAscend = new Tooltip("Sort by value in ascending order");
		Tooltip ttValueDescend = new Tooltip("Sort by value in descending order");
		Tooltip ttDeleteAppliance = new Tooltip("Check to Delete all Appliances");
		Tooltip ttDeleteJewellry = new Tooltip("Check to Delete all Jewellery");
		Tooltip ttDeleteStock = new Tooltip("Check to Delete all Stock");
		Tooltip ttDelete = new Tooltip("Deletes all selected items from register");
		btShow.setTooltip(ttShow);
		btDelete.setTooltip(ttDelete);
		rbNameAscend.setTooltip(ttNameAscend);
		rbNameDescend.setTooltip(ttNameDescend);
		rbValueAscend.setTooltip(ttValueAscend);
		rbValueDescend.setTooltip(ttValueDescend);
		cbAppliance.setTooltip(ttDeleteAppliance);
		cbJewellery.setTooltip(ttDeleteJewellry);
		cbStock.setTooltip(ttDeleteStock);

		return sortingPane;
	}

	private void populateArray() {
		valuables.add(new Appliance("Micro owen", 20.5, 5));
		valuables.add(new Appliance("Tablet", 8000, 10));
		valuables.add(new Appliance("TV", 3000, 3));
		valuables.add(new Appliance("iPhone", 6000, 8));
		valuables.add(new Jewellery("Bracelet", 5, "Silver"));
		valuables.add(new Jewellery("Necklace", 13, "Silver"));
		valuables.add(new Jewellery("Ring", 3, "Gold"));
		valuables.add(new Jewellery("Ring", 1, "Silver"));
		valuables.add(new Stock("Astra Zeneca", 120, 977.29));
		valuables.add(new Stock("ABB", 1500, 227.62));
		valuables.add(new Stock("Ericsson B", 100, 85.77));
		valuables.add(new Stock("Nokia", 17, 39.41));
	}

	
	private class JewellryHandler implements EventHandler<ActionEvent> {
		private ErrorAlert errAlert = new ErrorAlert();

		@Override
		public void handle(ActionEvent event) {
			textArea.clear();
			try {
				InDialogJewellry dialog = new InDialogJewellry();
				dialog.setTitle("New Jewellery");
				dialog.getDialogPane().setStyle("-fx-background-color: PALEGREEN");
				Optional<ButtonType> answer = dialog.showAndWait();
				if (answer.isPresent() && answer.get() == ButtonType.OK) {
					String name = dialog.getNameField();
					if (name.trim().isEmpty()) {
						errAlert.showNameError();
						return;
					}
					int numbStones = dialog.getStoneField();
					boolean ofGold = dialog.getCbMaterial();
					String material = ofGold ? "Gold" : "Silver";
					Valuable newValuable = new Jewellery(name, numbStones, material);
					valuables.add(newValuable);
				}
			} catch (NumberFormatException e) {
				errAlert.showNumberError();
			}
		}
	}

	
	private class StockHandler implements EventHandler<ActionEvent> {
		private ErrorAlert errAlert = new ErrorAlert();

		@Override
		public void handle(ActionEvent event) {
			textArea.clear();
			try {
				InDialogStock dialog = new InDialogStock();
				dialog.setTitle("New Stock");
				dialog.getDialogPane().setStyle("-fx-background-color: #ffb39a ");
				Optional<ButtonType> answer = dialog.showAndWait();
				if (answer.isPresent() && answer.get() == ButtonType.OK) {
					String name = dialog.getNameField();
					if (name.trim().isEmpty()) {
						errAlert.showNameError();
						return;
					}
					int quantity = dialog.getQuantityField();
					double rate = dialog.getPriceField();
					Valuable newValuable = new Stock(name, quantity, rate);
					valuables.add(newValuable);
				}
			} catch (NumberFormatException e) {
				errAlert.showNumberError();
			}
		}
	}

	
	private class ApplianceHandler implements EventHandler<ActionEvent> {
		private ErrorAlert errAlert = new ErrorAlert();

		@Override
		public void handle(ActionEvent event) {
			textArea.clear();
			try {
				InDialogAppliance dialog = new InDialogAppliance();
				dialog.setTitle("New Appliance");
				dialog.getDialogPane().setStyle("-fx-background-color: AQUA");
				Optional<ButtonType> answer = dialog.showAndWait();
				if (answer.isPresent() && answer.get() == ButtonType.OK) {
					String name = dialog.getNameField();
					if (name.trim().isEmpty()) {
						errAlert.showNameError();
						return;
					}
					double price = dialog.getPriceField();
					int wear = dialog.getSliderField();
					Valuable newValuable = new Appliance(name, price, wear);
					valuables.add(newValuable);
				}
			} catch (NumberFormatException e) {
				errAlert.showNumberError();
			}
		}
	}

	
	class ShowHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			textArea.clear();
			textArea.setStyle("-fx-text-inner-color: black; -fx-font-family: monospace");
			if (rbNameAscend.isSelected())
				valuables.sort(Comparator.comparing(Valuable::getName));
			else if (rbNameDescend.isSelected())
				valuables.sort(Comparator.comparing(Valuable::getName).reversed());
			else if (rbValueAscend.isSelected())
				valuables.sort(Comparator.comparing(Valuable::getValuePlusVAT));
			else
				valuables.sort(Comparator.comparing(Valuable::getValuePlusVAT).reversed());
			for (Valuable val : valuables)
				textArea.appendText(val.toString() + "\n");
		}
	}
	

	private class DeleteHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			textArea.clear();
			textArea.setStyle("-fx-text-inner-color: red; -fx-font-family:  monospace");
			if (cbAppliance.isSelected()) {
				deleteAllAppliances();
				textArea.appendText("All your Appliances are now deleted from register!\n");
			}
			if (cbJewellery.isSelected()) {
				textArea.appendText("All your Jewellery are now deleted from register!\n");
				deleteAllJewellery();
			}
			if (cbStock.isSelected()) {
				deleteAllStock();
				textArea.appendText("All your Stock are now deleted from register!\n");
			}
		}

		private void deleteAllAppliances() {
			int i = 0;
			while (i < valuables.size()) {
				if (valuables.get(i) instanceof Appliance) {
					valuables.remove(i);
				} else {
					i++;
				}
			}
		}

		private void deleteAllJewellery() {
			int i = 0;
			while (i < valuables.size()) {
				if (valuables.get(i) instanceof Jewellery) {
					valuables.remove(i);
				} else {
					i++;
				}
			}
		}

		private void deleteAllStock() {
			int i = 0;
			while (i < valuables.size()) {
				if (valuables.get(i) instanceof Stock) {
					valuables.remove(i);
				} else {
					i++;
				}
			}
		}
	}

	
	private class CrashHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			textArea.clear();
			promptCrashAlert();
			for (Valuable val : valuables)
				if (val instanceof Stock)
					((Stock) val).setRate(0);
		}

		private void promptCrashAlert() {
			Text heading = new Text("The chinese-virus crashed the whole stock market!!!");
			Text text = new Text(
					"All your stocks are now worthless since you\ndid not build a shrine to honor Corona Chan!");
			textArea.setStyle("-fx-font-weight: BOLD;-fx-background-color: red; "
					+ "-fx-text-inner-color: red; -fx-font-size: 16");
			textArea.appendText(heading.getText() + "\n\n" + text.getText());
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
	

}
