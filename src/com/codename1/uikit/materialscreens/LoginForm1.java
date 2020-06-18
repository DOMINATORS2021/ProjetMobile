/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.codename1.uikit.materialscreens;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.mycompany.myapp.entities.user;
import com.mycompany.myapp.services.ServiceUser;
import com.mycompany.myapp.services.session;

/**
 * The Login form
 *
 * @author Shai Almog
 */
public class LoginForm1 extends Form {
    public LoginForm1(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
          user u=new user();
        u=session.getLoggedUser();
        
        
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome ", "WelcomeWhite")
                
        );
        
        getTitleArea().setUIID("Container");
       
        Image profilePic = theme.getImage("mentor.png");
        Image mask = theme.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePic");
        profilePicLabel.setMask(mask.createMask());
        
        TextField login = new TextField("", "Login", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD) ;
        login.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        Label loginIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        Button loginButton = new Button("LOGIN");
        loginButton.setUIID("LoginButton");
        loginButton.addActionListener(e -> {
            if(password.getText().equals("zzz123"))
            {
            new ProfileForm(theme).show();
            }else
            {
                Dialog.show("error", "password is incorrect", "Ok", null);
            }
        });
//              ConnectionRequest req = new ConnectionRequest();
//              String url1="http://127.0.0.1/Service/Login.php?username=" + login.getText() + "&password=" + password.getText() + ""; 
//              req.setUrl(url1);
//                System.out.println(url1);
//                req.addResponseListener((NetworkEvent evt) -> {
//                    byte[] data = (byte[]) evt.getMetaData();
//                    String s = new String(data);
//                    if (s.equals("success")) {
//                        user s4=new user();
//                        s4.setUsername(login.getText());
//                        System.out.println(s4);
//                        ProfileForm h= new ProfileForm(theme);
//                        h.show();
//                        // new ProfileForm(theme).show();
//                    
//                    
//                    ConnectionRequest cn = new ConnectionRequest();
//                    cn.setUrl("http://127.0.0.1/Service/GetUser.php?username=" + login.getText());
//                    
//                    cn.addResponseListener(new ActionListener<NetworkEvent>() {
//                        
//                        @Override
//                        public void actionPerformed(NetworkEvent evt) {
//                            user u = new ServiceUser().getUserByID(new String(cn.getResponseData()));
//                            session.setLoggedUser(u);
//                            System.out.println(""+session.getLoggedUser());
//                            
//                            System.out.println("hhh"+u.getRoles());
//                            
//                            
//                            
//                            NetworkManager.getInstance().addToQueue(req);
//                            Dialog.show("welcome", "connected", null, "ok");
//                            
//                        }
//                    });
//                    new ProfileForm(theme).show();
//                    }  });
//        });
//                        
        
        
        Button createNewAccount = new Button("CREATE NEW ACCOUNT");
        createNewAccount.setUIID("CreateNewAccountButton");
        createNewAccount.addActionListener((e) -> {
        
            new SignUpForm(theme).show();
        
        });
        
        // We remove the extra space for low resolution devices so things fit better
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
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                loginButton,
                createNewAccount
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }

                }