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
import com.codename1.ui.events.ActionListener;
import com.mycomapny.myapp.utils.Statics;
import com.mycompany.myapp.entities.cours;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AYOUB
 */
public class ServiceCours {
        public ArrayList<cours> cour;
    public static ServiceCours instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    public ServiceCours(){
        req= new ConnectionRequest();
        
    }
    
    public static ServiceCours getInstance(){
        if(instance==null){
           instance = new ServiceCours();
        }
        return instance;
    }
    
    
        public ArrayList<cours> parseCours(String jsonText) throws IOException{
        
        cour= new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String,Object> courListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        List<Map<String,Object>> list = (List<Map<String,Object>>)courListJson.get("root");
        for(Map<String,Object> obj : list){
            cours p = new cours();
            float id = Float.parseFloat(obj.get("id").toString());
            p.setId((int)id);
            p.setName(obj.get("name").toString());
            p.setDescription(obj.get("description").toString());
            p.setType(obj.get("type").toString());
            p.setNomfile((String) obj.get("nomfile"));
            
              
            
            
            
            cour.add(p);
        }
     return cour ;
    }
        
 
          
        
        
       public ArrayList<cours> getAllCours(){
        String url =" http://localhost/MonProjet1/web/app_dev.php/mobile/affichecourses";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    cour = parseCours(new String(req.getResponseData()));
                } catch (IOException ex) {
                    
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cour;
    }
         public boolean addCour(cours p) {
       
       String url =   "http://localhost/MonProjet1/web/app_dev.php/mobile/ajoutercourses?name="+p.getName()+ "&type="+p.getType()+"&description="+p.getDescription()+"&nomfile="+p.getNomfile();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
                 public boolean deleteCour(cours p) {
       // ConnectionRequest con = new ConnectionRequest();
String url =  "http://localhost/MonProjet1/web/app_dev.php/mobile/delete/"+p.getId();
        
       req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
}

                public boolean RateCour(cours p) {
       // ConnectionRequest con = new ConnectionRequest();
String url =  "http://localhost/MonProjet1/web/app_dev.php/mobile/rate/"+p.getId();
        
       req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
}
                
     public boolean UpdateCour(cours p) {
       // ConnectionRequest con = new ConnectionRequest();
String url =  "http://localhost/MonProjet1/web/app_dev.php/mobile/update?id="+p.getId()+"&name="+p.getName()+"&type="+p.getType()+"&desc="+p.getDescription() ;
        
       req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
}
     
      public ArrayList<cours> getAllRate(){
        String url =  "http://localhost/MonProjet1/web/app_dev.php/mobile/affichecourses";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    cour = parseCours(new String(req.getResponseData()));
                } catch (IOException ex) {
                    
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cour;
    }
}

//