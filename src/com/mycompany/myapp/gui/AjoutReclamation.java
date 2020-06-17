/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Reclamation;

/**
 *
 * @author Senda
 */
public class AjoutReclamation extends SideMenuBaseForm{
    
    public AjoutReclamation(Resources res)
    {
     setTitle("Add Reclamation");
     setLayout(BoxLayout.y());
     Label sujet = new Label("Sujet");
     TextField Sujet= new TextField("","Sujet",20,TextArea.ANY);
     Label texte = new Label("Reclamation");
     TextField Texte= new TextField("","Reclamation",20,TextArea.ANY);
     
     Style btnValider = UIManager.getInstance().getComponentStyle("Button");
     btnValider.setFgColor(ColorUtil.rgb(0, 58, 94));
     Button valider = new Button("Add Reclamation",FontImage.createMaterial(FontImage.MATERIAL_ADD,btnValider));
     this.addAll(sujet,Sujet,texte,Texte,valider);
       valider.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
               Reclamation r = new Reclamation();
               r.setSujet(Sujet.getText());
               r.setTexte(Texte.getText());
            try {
               if( new com.mycompany.myapp.services.ServiceReclamation().AjouterReclamation(r))
                   Dialog.show("Success","Connection accepted",new Command("ok"));
                 else
                   Dialog.show("ERROR","Server error",new Command("ok"));
              }
                 catch(NumberFormatException e)
               {
                   Dialog.show("ERROR","Status must be a number",new Command("ok"));
               }
         }
          
            });  
          
      
     setupSideMenu(res);
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e->new ProfileForm(res).show());
    }

    @Override
    protected void showOtherForm(Resources res) {
    }
    
}
