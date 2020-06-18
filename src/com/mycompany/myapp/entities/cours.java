/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

  
 

/**
 *
 * @author AYOUB
 */
public class cours {

    public cours(int id, String name, String description, String type,   int enable, String nomfile, int nbRaiting, int available,   int idUser, int warning) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
         
        this.enable = enable;
        this.nomfile = nomfile;
        this.nbRaiting = nbRaiting;
        this.available = available;
        
        this.idUser = idUser;
        this.warning = warning;
    }
    private int id;
    private String name;
    private String description;
    private String type;
   
    private int enable;
    private String nomfile;
    private int nbRaiting;
    private int available;
    
    private int idUser;
    private int warning;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
 

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public String getNomfile() {
        return nomfile;
    }

    public void setNomfile(String nomfile) {
        this.nomfile = nomfile;
    }

    public int getNbRaiting() {
        return nbRaiting;
    }

    public void setNbRaiting(int nbRaiting) {
        this.nbRaiting = nbRaiting;
    }

    public int getAvailable() {
        return available;
    }

    public cours() {
    }

    public void setAvailable(int available) {
        this.available = available;
    }
 

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    @Override
    public String toString() {
        return "cours{" + "id=" + id + ", name=" + name + ", description=" + description + ", type=" + type + ",   enable=" + enable + ", nomfile=" + nomfile + ", nbRaiting=" + nbRaiting + ", available=" + available +   ", idUser=" + idUser + ", warning=" + warning + '}';
    }

    public cours(String name, String description, String type,String nomfile) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.nomfile=nomfile;
    }

    public cours(String name,  int enable ) {
        this.name = name;
        ;
        this.enable = enable;
         
    }
    
    
}
