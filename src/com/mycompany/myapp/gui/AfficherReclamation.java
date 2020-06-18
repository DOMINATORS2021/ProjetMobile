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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
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
    Resources ress;
    public AfficherReclamation(SideMenuBaseForm previous,Resources res){
        setTitle("Reclamations List");
        setLayout(BoxLayout.y()); 
        ress=res;
         for(Reclamation r:ServiceReclamation.getInstance().getAllReclamations())
        {
            this.add(setReclamation(r));
        }
   
          getToolbar().addCommandToOverflowMenu("Add Reclamation", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AjoutReclamation(res).show();               }
           
             }); 
          
          
           getToolbar().addCommandToOverflowMenu("Search Reclamation", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new RechercheReclamation(res).show();               
            }
             }); 
        
       getToolbar().addMaterialCommandToLeftBar("Back",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());

    } 
     private Container setReclamation(Reclamation r)
    {
        Container cnt=new Container(BoxLayout.y());
        Style LabelSujet1 = UIManager.getInstance().getComponentStyle("Label");
        LabelSujet1.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbsujet1 = new Label("Reclamation Subject",FontImage.createMaterial(FontImage.MATERIAL_LOOKS_ONE,LabelSujet1));
        Style LabelSujet = UIManager.getInstance().getComponentStyle("Label");
        LabelSujet.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbsujet = new Label(r.getSujet(),FontImage.createMaterial(FontImage.MATERIAL_HDR_STRONG,LabelSujet));
        Style LabelEtat1 = UIManager.getInstance().getComponentStyle("Label");
        LabelEtat1.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbetat1 = new Label("Reclamation State",FontImage.createMaterial(FontImage.MATERIAL_LOOKS_TWO,LabelEtat1));

        String Str="";
        if (r.getEtatReclamation()==0)
        {
            Str=Str+"Reclamation has not been treated yet";
        }
        else
        {
            Str=Str+"Problem Solved";

        }
        Style LabelEtat = UIManager.getInstance().getComponentStyle("Label");
        LabelEtat.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbetat = new Label(Str,FontImage.createMaterial(FontImage.MATERIAL_LABEL,LabelEtat));
    
 
        
        Button btn=new Button();
        
     
        cnt.addAll(lbsujet1,lbsujet,lbetat1,lbetat,btn);
        btn.addActionListener((e)->{
            new AfficherReclamationDetails(this,r,ress).show(); 
        });
               
        cnt.setLeadComponent(btn);
        return cnt;
    }

    @Override
    protected void showOtherForm(Resources res) {
    }

    
}
