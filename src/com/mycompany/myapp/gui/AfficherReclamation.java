/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamation;

/**
 *
 * @author Senda
 */
public class AfficherReclamation extends SideMenuBaseForm
{
    
    public AfficherReclamation(SideMenuBaseForm previous,Resources res){
        
        setTitle("Reclamations List");
        setLayout(BoxLayout.y()); 
        
         for(Reclamation r:ServiceReclamation.getInstance().getAllReclamations())
        {
            this.add(setReclamation(r));
        }
   
        
        
       getToolbar().addMaterialCommandToLeftBar("Back",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());

    } 
     private Container setReclamation(Reclamation r)
    {
        Container cnt=new Container(BoxLayout.y());
        Style LabelSujet = UIManager.getInstance().getComponentStyle("Label");
        LabelSujet.setFgColor(ColorUtil.rgb(255,0,0));
        Label lbsujet = new Label(r.getSujet(),FontImage.createMaterial(FontImage.MATERIAL_TOYS,LabelSujet));

        Label lbtexte=new Label(r.getTexte());
        Label lbdate=new Label(""+r.getDateReclamation());
        String Str="";
        if (r.getEtatReclamation()==0)
        {
            Str=Str+"Reclamation has not been treated yet";
        }
        else
        {
            Str=Str+"Problem Solved";

        }
        Label lbetat=new Label(Str);
 
        
        Button btn=new Button();
        
     
        cnt.addAll(lbsujet,lbtexte,lbdate,lbetat,btn);
        btn.addActionListener((e)->{
            new AfficherReclamationDetails(this,r).show(); 
        });
               
        cnt.setLeadComponent(btn);
        return cnt;
    }

    @Override
    protected void showOtherForm(Resources res) {
    }

    
}
