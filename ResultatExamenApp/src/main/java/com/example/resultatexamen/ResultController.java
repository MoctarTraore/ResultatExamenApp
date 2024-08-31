package com.example.resultatexamen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ResultController {

    @FXML
    private Label messageLabel;
    @FXML
    private Button detailsButton;

    private javafx.event.EventHandler<javafx.event.ActionEvent> detailsButtonAction;

    @FXML
    private void handleDetailsButtonClick(javafx.event.ActionEvent event) {
        if (detailsButtonAction != null) {
            detailsButtonAction.handle(event);
        }
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    public void setButtonVisible(boolean visible) {
        detailsButton.setVisible(visible);
    }

    public void setButtonAction(javafx.event.EventHandler<javafx.event.ActionEvent> handler) {
        this.detailsButtonAction = handler;
    }
}
