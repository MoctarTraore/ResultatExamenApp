package com.example.resultatexamen;

public class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String ecole;
    private double moyenne;

    public Etudiant(String matricule, String nom, String prenom, String dateNaissance, String ecole, double moyenne) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ecole = ecole;
        this.moyenne = moyenne;
    }

    // Getters et Setters
    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getEcole() {
        return ecole;
    }

    public double getMoyenne() {
        return moyenne;
    }
}
