/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.ProfileForm;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamation;

/**
 *
 * @author Senda
 */
public class RechercheReclamation extends SideMenuBaseForm{
         Reclamation re=new Reclamation();
    public RechercheReclamation(Resources res)
    {
        setTitle("Search Reclamation");
        setLayout(BoxLayout.y());
        Label lbsujet=new Label("Sujet");
        TextField sujet= new TextField("","Sujet",20,TextArea.ANY);
        
        Style btnSearch = UIManager.getInstance().getComponentStyle("Button");
        btnSearch.setFgColor(ColorUtil.rgb(0, 58, 94));
        Button btnRechercher=new Button("Search",FontImage.createMaterial(FontImage.MATERIAL_SEARCH,btnSearch)); 
        
        this.addAll(lbsujet,sujet,btnRechercher);
       
   
        btnRechercher.addActionListener(
        (e)->{
        for(Reclamation r:ServiceReclamation.getInstance().getAllReclamations())
        {
            if(r.getSujet().equals(sujet.getText()))
                {
                    re=r;
                }
        }

           new ReclamationTrouve(this,res,re).show();     
        }
        );
        setupSideMenu(res);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e->new ProfileForm(res).show());

    }
    @Override
    protected void showOtherForm(Resources res) {
    }
    
}
