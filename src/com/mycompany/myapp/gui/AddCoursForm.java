/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.cours;
import com.mycompany.myapp.services.ServiceCours;
 import com.codename1.ext.filechooser.FileChooser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Image;
import com.mycompany.myapp.services.ServiceUser;
import java.io.IOException;
import java.util.Date;
/**
 *
 * @author AYOUB
 */
public class AddCoursForm extends Form{
     TextField ima1 ;
    String filePath="";
    Label im=new Label();
     Image aaz;
     public AddCoursForm(Form previous){
        setTitle("Add a new Courses");
        
        setLayout(BoxLayout.y());
        
        TextField tfName = new TextField("","CoursesName");
        ComboBox type = new ComboBox("Chasseur","Pecheur");
        TextField tfdesc = new TextField("","description");
        Button Upload = new Button("Upload Image");
         cours us= new cours();
        /***************************/
          Label imga=new Label("import Image");
        Style imgaStyle = new Style(imga.getUnselectedStyle());
        imgaStyle.setFgColor(0x2576f9);
        FontImage imgaImage = FontImage.createMaterial(FontImage.MATERIAL_COLLECTIONS, imgaStyle);
        imga.setIcon(imgaImage);
        imga.setTextPosition(RIGHT);

        
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
                    us.setNomfile(fileNameInServer);
                    InfiniteProgress prog = new InfiniteProgress();
                    Dialog dlg = prog.showInifiniteBlocking();
                    cr.setDisposeOnCompletion(dlg);
                    NetworkManager.getInstance().addToQueueAndWait(cr);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                                        
            }
        });
 
     //   aaz.setImageName(filePath.toString());
        /****************************/
        
      
        Button btnValider = new Button("Add Courses");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfName.getText().length()==0)||(tfName.getText().length()==0) ||(tfdesc.getText().length()==0) )
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                       // cours p = new cours(tfName.getText(),tfdesc.getText(),String.valueOf(type.getSelectedItem()));
                               
      
                       cours p1=new cours();
                        p1.setName(tfName.getText());
                        p1.setType(String.valueOf(type.getSelectedItem()));
                        p1.setDescription(tfdesc.getText());
                         
                        if( ServiceCours.getInstance().addCour(p1))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                       // new ListCoursForm(res).show();
                    } catch (NumberFormatException e) {
                       
                    }
                    
                }
                
                
            }
        });
       
        
        
    
        
        addAll(tfName,type,tfdesc,Upload, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
    
    
    
    
    
    
    
    
    

    
    
}
