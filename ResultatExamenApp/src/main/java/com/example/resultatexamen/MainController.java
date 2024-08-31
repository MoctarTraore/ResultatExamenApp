package com.example.resultatexamen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainController {

    @FXML
    private TextField matriculeField;
    @FXML
    private Button consulterButton;

    private final Map<String, Etudiant> etudiants = new HashMap<>();

    public MainController() {
        // Initialisation de la source de données fictive
        etudiants.put("BTS202400001", new Etudiant("BTS202400001", "Yeo", "Kader", "1998-01-15", "Pigier CI", 12.5));
        etudiants.put("BTS202400002", new Etudiant("BTS202400002", "Kouassi", "Anna", "1999-03-22", "Loko", 9.1));
        etudiants.put("BTS202400003", new Etudiant("BTS202400003", "Lebron", "James", "2000-07-11", "HETEC", 15.0));
        etudiants.put("BTS202400004", new Etudiant("BTS202400004", "Traoré", "Lamine", "2001-10-25", "IFSM", 7.3));
        etudiants.put("BTS202400005", new Etudiant("BTS202400005", "Kouame", "Lorent", "1997-12-05", "UNDA", 10.5));
    }

    @FXML
    private void onConsulterButtonClicked() {
        String matricule = matriculeField.getText();
        Etudiant etudiant = etudiants.get(matricule);

        if (etudiant == null) {
            showAlert("Erreur", "Matricule non trouvé !");
        } else {
            openResultWindow(etudiant);
        }
    }

    private void openResultWindow(Etudiant etudiant) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("result-view.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load(), 400, 300); // Taille agrandie
            stage.setScene(scene);

            ResultController controller = loader.getController();
            if (etudiant.getMoyenne() >= 10) {
                controller.setMessage("Félicitations, vous avez réussi !");
                controller.setButtonVisible(true);
                controller.setButtonAction(e -> openDetailWindow(etudiant, "lightgreen"));
                scene.getRoot().setStyle("-fx-background-color: lightgreen;");
            } else {
                controller.setMessage("Désolé, vous avez échoué !");
                controller.setButtonVisible(true);
                controller.setButtonAction(e -> openDetailWindow(etudiant, "lightcoral"));
                scene.getRoot().setStyle("-fx-background-color: lightcoral;");
            }

            stage.setTitle("Résultat");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openDetailWindow(Etudiant etudiant, String color) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("details-view.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load(), 400, 300); // Taille agrandie
            stage.setScene(scene);

            DetailController controller = loader.getController();
            controller.setEtudiant(etudiant);
            scene.getRoot().setStyle("-fx-background-color: " + color + ";");

            stage.setTitle("Détails de l'Étudiant");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
