package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventorySystem extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Input fields
		TextField idField = new TextField();
		TextField nameField = new TextField();
		TextField quantityField = new TextField();
		TextField priceField = new TextField();

		Button addItemButton = new Button("Add Item");
		TextArea displayArea = new TextArea();
		displayArea.setEditable(false);

		addItemButton.setOnAction(e -> {
			try {
				InventoryItem newItem = new InventoryItem(idField.getText(), nameField.getText(),
						Integer.parseInt(quantityField.getText()), Double.parseDouble(priceField.getText()));
				InventoryData.addItem(newItem);
				displayArea.setText(""); // Clear previous data
				for (InventoryItem item : InventoryData.getAllItems()) {
					displayArea.appendText(item.toString() + "\n");
				}
				// Clear fields
				idField.clear();
				nameField.clear();
				quantityField.clear();
				priceField.clear();

			} catch (NumberFormatException ex) {
				displayArea.appendText("Invalid input. Please enter numbers for quantity and price.\n");
			}
		});

		// ... (Add update and delete functionality here - see below) ...

		GridPane inputGrid = new GridPane();
		inputGrid.setPadding(new Insets(10));
		inputGrid.setHgap(5);
		inputGrid.setVgap(5);
		// Add labels and text fields to the grid...

		VBox root = new VBox(inputGrid, addItemButton, displayArea);
		Scene scene = new Scene(root, 400, 300);
		primaryStage.setTitle("Inventory Management System");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}