package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentSystem extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Input fields
        TextField idField = new TextField();
        TextField nameField = new TextField();
        TextField majorField = new TextField();
        TextField gpaField = new TextField();

        Button addButton = new Button("Add Student");
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);


        addButton.setOnAction(e -> {
            try {
                Student student = new Student(idField.getText(), nameField.getText(),
                        majorField.getText(), Double.parseDouble(gpaField.getText()));
                StudentData.addStudent(student);
                displayArea.setText(""); // Clear previous data
                for (Student s : StudentData.getAllStudents()) {
                    displayArea.appendText(s.toString() + "\n");
                }

                // Clear input fields
                idField.clear();
                nameField.clear();
                majorField.clear();
                gpaField.clear();

            } catch (NumberFormatException ex) {
                // Handle invalid GPA input
                displayArea.appendText("Invalid GPA input.\n");
            }
        });


        GridPane inputGrid = new GridPane();
        inputGrid.setPadding(new Insets(10));
        inputGrid.setHgap(5);
        inputGrid.setVgap(5);
        inputGrid.add(new Label("ID:"), 0, 0);
        inputGrid.add(idField, 1, 0);
        inputGrid.add(new Label("Name:"), 0, 1);
        inputGrid.add(nameField, 1, 1);
        inputGrid.add(new Label("Major:"), 0, 2);
        inputGrid.add(majorField, 1, 2);
        inputGrid.add(new Label("GPA:"), 0, 3);
        inputGrid.add(gpaField, 1, 3);
        inputGrid.add(addButton, 1, 4);


        VBox root = new VBox(inputGrid, displayArea);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Student Information System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}