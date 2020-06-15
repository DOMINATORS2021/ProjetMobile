/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Reclamation;

/**
 *
 * @author Senda
 */
public class AfficherReclamationDetails extends SideMenuBaseForm{

    
    public AfficherReclamationDetails(SideMenuBaseForm previous,Reclamation r)
    {
     setTitle(r.getSujet());
     setLayout(BoxLayout.y()); 
     
     getToolbar().addMaterialCommandToLeftBar("Back",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
    
    
    @Override
    protected void showOtherForm(Resources res) {
    }
    
}
