/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;

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
     Button valider = new Button("Envoyer Réclamation");
     this.addAll(sujet,Sujet,texte,Texte,valider);
     setupSideMenu(res);
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e->new ProfileForm(res).show());
     
    }

    @Override
    protected void showOtherForm(Resources res) {
    }
    
}
