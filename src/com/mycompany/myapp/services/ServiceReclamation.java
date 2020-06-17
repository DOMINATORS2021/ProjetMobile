/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycomapny.myapp.utils.Statics;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.entities.Reclamation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

/**
 *
 * @author Senda
 */
public class ServiceReclamation {
    public ArrayList<Reclamation> reclamations;
    public static ServiceReclamation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    public ServiceReclamation(){
        req= new ConnectionRequest();
        
    }
    
    public static ServiceReclamation getInstance(){
        if(instance==null){
           instance = new ServiceReclamation();
        }
        return instance;
    }
    public ArrayList<Reclamation> parseReclamations(String jsonText) {
        try {
            reclamations = new ArrayList();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
             for (Map<String, Object> obj : list ) 
             {
                Reclamation r = new Reclamation();
                float id = Float.parseFloat(obj.get("id").toString());
                float etatReclamation = Float.parseFloat(obj.get("etatReclamation").toString());
                String sujet = obj.get("sujet").toString();
                String texte = obj.get("texte").toString();
                LinkedHashMap<String, Object> date = (LinkedHashMap<String, Object>) obj.get("dateReclamation");
                double t = (double) date.get("timestamp");
                long x = (long) (t * 1000L);
                r.setDateReclamation(new Date(x));
                r.setId((int) id);
                r.setEtatReclamation(0);
                r.setSujet(sujet);
                r.setTexte(texte);
                reclamations.add(r);   
             }

        } catch (IOException ex) {
         }
        return reclamations;   

}
    
       public ArrayList<Reclamation> getAllReclamations() {
        String url = Statics.BASE_URL + "/reclamation/AfficherReclamationMobile";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                reclamations = parseReclamations(new String(req.getResponseData()));
                req.removeResponseListener(this);                          
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }
       
        public ArrayList<Reclamation> getReclamation(String sujet ) {
        String url = Statics.BASE_URL + "/reclamation/RechercherReclamationMobile?sujet="+sujet;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                reclamations = parseReclamations(new String(req.getResponseData()));
                req.removeResponseListener(this);                          
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }
       
    public boolean AjouterReclamation(Reclamation r) {
        String url = "http://localhost/MonProjet1/web/app_dev.php/reclamation/AjouterReclamationMobile?sujet=" +r.getSujet()+"&texte="+r.getTexte();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
                            }
          
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public boolean SupprimerReclamation(Reclamation r) {
        String Url = "http://localhost/MonProjet1/web/app_dev.php/reclamation/SupprimerReclamationMobile?id=" +r.getId();
        req.setUrl(Url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public boolean ModifierReclamation(Reclamation r) {
        
        return resultOK;
    }
}