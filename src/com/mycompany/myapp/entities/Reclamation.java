/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author Senda
 */
public class Reclamation {
    private int id;
    private String sujet;
    private String texte;
    private int etatReclamation;
    private Date dateReclamation;
    private int idUser;

    public Reclamation() {
    }

    public Reclamation(String sujet, String texte, int etatReclamation, Date dateReclamation, int idUser) {
        this.sujet = sujet;
        this.texte = texte;
        this.etatReclamation = etatReclamation;
        this.dateReclamation = dateReclamation;
        this.idUser = idUser;
    }

    public Reclamation(String sujet, String texte, int etatReclamation, Date dateReclamation) {
        this.sujet = sujet;
        this.texte = texte;
        this.etatReclamation = etatReclamation;
        this.dateReclamation = dateReclamation;
    }

    public Reclamation(int id, String sujet, String texte, int etatReclamation, Date dateReclamation) {
        this.id = id;
        this.sujet = sujet;
        this.texte = texte;
        this.etatReclamation = etatReclamation;
        this.dateReclamation = dateReclamation;
    }

    

    public Reclamation(int id, String sujet, String texte, int etatReclamation, Date dateReclamation, int idUser) {
        this.id = id;
        this.sujet = sujet;
        this.texte = texte;
        this.etatReclamation = etatReclamation;
        this.dateReclamation = dateReclamation;
        this.idUser = idUser;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getEtatReclamation() {
        return etatReclamation;
    }

    public void setEtatReclamation(int etatReclamation) {
        this.etatReclamation = etatReclamation;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    
    
}
