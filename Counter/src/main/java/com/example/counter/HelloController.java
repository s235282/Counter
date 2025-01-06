package com.example.counter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label counterLabel;

    @FXML
    private Button decreaseButton;

    @FXML
    private Button increaseButton;

    private int counter = 0;

    @FXML
    public void initialize() {
        // Set initial counter value
        updateCounterLabel();

        // Add button click handlers
        decreaseButton.setOnAction(event -> decreaseCounter());
        increaseButton.setOnAction(event -> increaseCounter());
    }

    public void decreaseCounter() {
        counter--;
        updateCounterLabel();
    }

    public void increaseCounter() {
        counter++;
        updateCounterLabel();
    }

    private void updateCounterLabel() {
        counterLabel.setText(String.valueOf(counter));
    }
}