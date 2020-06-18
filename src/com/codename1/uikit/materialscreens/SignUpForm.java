/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.materialscreens;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.LoginForm;
import com.mycompany.myapp.entities.cours;
import com.mycompany.myapp.entities.user;
import com.mycompany.myapp.services.ServiceUser;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author AYOUB
 */
public class SignUpForm extends Form{
    
    public SignUpForm(Resources theme)
    {
         super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Join Us ", "WelcomeWhite")
                
        );
        user us= new user();
        getTitleArea().setUIID("Container");
        
           Button Upload = new Button("Upload Image");
        Upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    String fileNameInServer = "";
                    MultipartRequest cr = new MultipartRequest();
                    String filepath = Capture.capturePhoto(-1, -1);
                    cr.setUrl("http://localhost/Service/uploadimage.php");
                    cr.setPost(true);
                    String mime = "image/jpeg";
                    cr.addData("file", filepath, mime);
                    String out = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                    cr.setFilename("file", out + ".jpg");//any unique name you want
                    
                    fileNameInServer += out + ".jpg";
                    System.err.println("path2 =" + fileNameInServer);
                    us.setImage(fileNameInServer);
                    InfiniteProgress prog = new InfiniteProgress();
                    Dialog dlg = prog.showInifiniteBlocking();
                    cr.setDisposeOnCompletion(dlg);
                    NetworkManager.getInstance().addToQueueAndWait(cr);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                                        
            }
        });
                
        
        Image profilePic = theme.getImage("mentor.png");
        Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
        profilePicLabel.setMask(mask.createMask());
        
         
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD) ;
        TextField password1 = new TextField("", "Password1", 20, TextField.PASSWORD) ;
        TextField Username = new TextField("", "Username", 20, TextField.EMAILADDR) ;
        TextField Email = new TextField("", "Email", 20, TextField.EMAILADDR) ;
        TextField pn = new TextField("", "phonenumber", 20, TextField.EMAILADDR) ;
   
        
        
        password.getAllStyles().setMargin(LEFT, 0);
        Username.getAllStyles().setMargin(LEFT, 0);
        Email.getAllStyles().setMargin(LEFT, 0);
        pn.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        Label passwordIcon1 = new Label("", "TextField");
         Label UserName = new Label("", "TextField");
          Label pn1 = new Label("", "TextField");
           Label email = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        UserName.getAllStyles().setMargin(RIGHT, 0);
        pn1.getAllStyles().setMargin(RIGHT, 0);
        email.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon1, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(UserName, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(pn1, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        FontImage.setMaterialIcon(email, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        Button SButton = new Button("JOIN NOW");
        
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        
         Container by = BoxLayout.encloseY(
                welcome,
                profilePicLabel,
                spaceLabel,
                
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                 BorderLayout.center(password1).
                        add(BorderLayout.WEST, passwordIcon1),
                 BorderLayout.center(Username).
                        add(BorderLayout.WEST , UserName),
                  BorderLayout.center(Email).
                        add(BorderLayout.WEST , email),
                   BorderLayout.center(pn).
                        add(BorderLayout.WEST , pn1),
                   Upload,
                SButton
                 
                 
        );
               SButton.addActionListener(l->{
         if(Username.getText().equals("")||Email.getText().equals("")||password.getText().equals("") ){
         Dialog.show("Erreur", "Veuiller remplir tous les champs", "Ok", null);
     }else if(!password.getText().equals(password1.getText())){
       Dialog.show("Erreur", "vérifier votre mot de passe ", "Ok", null);   
     }
            ServiceUser ser = new ServiceUser();
            
           us.setUsername(Username.getText());
           us.setPassword(password.getText());
           us.setEmail_canonical(Email.getText());
           us.setPhoneNumber(Integer.parseInt(pn.getText()));
           if(us.getImage()==null) us.setImage("default.png");
            ser.ajoutUserClient(us);
                            
    Dialog.show("Success", "You are Welcom", "Ok", null);
    
    new LoginForm(theme).show();
      
       
               }
        ); 
       this.getToolbar().addMaterialCommandToLeftBar(" Back", FontImage.MATERIAL_ARROW_BACK, ev->{
                    new LoginForm1(theme).show();
                });
     add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    
}

}