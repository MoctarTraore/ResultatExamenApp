package com.example.resultatexamen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DetailController {

    @FXML
    private Label matriculeLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label ecoleLabel;
    @FXML
    private Label moyenneLabel;

    public void setEtudiant(Etudiant etudiant) {
        matriculeLabel.setText("Matricule: " + etudiant.getMatricule());
        nomLabel.setText("Nom: " + etudiant.getNom());
        prenomLabel.setText("Prénom: " + etudiant.getPrenom());
        dobLabel.setText("Date de naissance: " + etudiant.getDateNaissance());
        ecoleLabel.setText("École: " + etudiant.getEcole());
        moyenneLabel.setText("Moyenne: " + etudiant.getMoyenne());
    }
}
