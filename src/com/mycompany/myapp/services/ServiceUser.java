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
 
import com.mycompany.myapp.entities.user;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AYOUB
 */
public class ServiceUser {
    
        public ArrayList<user> users;
    public static ServiceUser instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
        public ServiceUser(){
        req= new ConnectionRequest();
        
    }
    
    public static ServiceUser getInstance(){
        if(instance==null){
           instance = new ServiceUser();
        }
        return instance;
    }
    
      public ArrayList<user> parseCours(String jsonText) throws IOException{
        
        users= new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String,Object> userListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        List<Map<String,Object>> list = (List<Map<String,Object>>)userListJson.get("root");
        for(Map<String,Object> obj : list){
            user p = new user();
            float id = Float.parseFloat(obj.get("id").toString());
            p.setId((int)id);
            p.setUsername(obj.get("username").toString());
            p.setEmail_canonical(obj.get("email_canonical").toString());
            p.setRoles(obj.get("roles").toString());
            p.setPassword(obj.get("email_canonical").toString());
             
            
            
              
            
            
            
            users.add(p);
        }
     return users ;
    }
      
       public user getUserByID(String json){
     
       
       user p = null;
      
       try {
            JSONParser j = new JSONParser();
            Map<String, Object> users = j.parseJSON(new CharArrayReader(json.toCharArray()));
            Map<String, Object> user = (Map<String, Object>) users.get("user");

           
                p = new user();
                
                p.setId(Integer.parseInt(user.get("id").toString()));
               
                p.setUsername(user.get("username").toString());
                p.setEmail_canonical(user.get("email_canonical").toString());
                p.setRoles(user.get("roles").toString());
               

          

        } catch (IOException ex) {

         }
       
       return p;
 
   }
      
        public boolean addUser(user p) {
       
       String url = Statics.BASE_URL + "/users/createUser?username="+p.getUsername()+ "&email_canonical="+p.getEmail_canonical()+"&roles="+p.getRoles() ;
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
         public void ajoutUserClient(user u){
         
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://127.0.0.1/Service/Regis.php?username=" + u.getUsername()+ "&email=" + u.getEmail_canonical()+ "&password="+ u.getPassword()+"&phoneNumber="+u.getPhoneNumber()+"&image="+u.getImage() ;
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
              System.out.println(Url);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
}
