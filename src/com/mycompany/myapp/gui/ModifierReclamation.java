/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Reclamation;

/**
 *
 * @author Senda
 */
public class ModifierReclamation extends SideMenuBaseForm{
    public ModifierReclamation(SideMenuBaseForm previous,Resources res,Reclamation r)
    
    {
        setTitle("");
        setLayout(BoxLayout.y());
        Label sujet = new Label("Sujet");
        TextField Sujet= new TextField("","",20,TextArea.ANY);
        Label texte = new Label("Reclamation");
        TextField Texte= new TextField("","",20,TextArea.ANY);
        Button btnModif=new Button("Modifier");
        this.addAll(sujet,Sujet,texte,Texte,btnModif);
        btnModif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Reclamation rec=new Reclamation();
                rec=r;
                rec.setSujet(Sujet.getText());
                rec.setTexte(Texte.getText());
                 try{
                 if(new com.mycompany.myapp.services.ServiceReclamation().ModifierReclamation(rec))
                    Dialog.show("Success","Reclamation has been updated",new Command("ok"));
                    else
                    Dialog.show("ERROR","Server error",new Command("ok"));
                    }catch(NumberFormatException e)
                    {
                        Dialog.show("ERROR","Status must be a number",new Command("ok"));
                    }
            }
        });
        
        setupSideMenu(res);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
    
    
    
    @Override
    protected void showOtherForm(Resources res) {
    }
   
}
