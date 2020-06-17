/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
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
public class ReclamationTrouve extends SideMenuBaseForm{
    public ReclamationTrouve(SideMenuBaseForm previous,Resources res,Reclamation r)
    {
        setTitle(""+r.getSujet());
        setLayout(BoxLayout.y());
       
        Style LabelTexte1 = UIManager.getInstance().getComponentStyle("Label");
        LabelTexte1.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbtexte1 = new Label("Reclamation",FontImage.createMaterial(FontImage.MATERIAL_LOOKS_ONE,LabelTexte1));
        
        Style LabelEtat1 = UIManager.getInstance().getComponentStyle("Label");
        LabelEtat1.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbetat1 = new Label("Reclamation State",FontImage.createMaterial(FontImage.MATERIAL_LOOKS_TWO,LabelEtat1));
        
        Style LabelTexte = UIManager.getInstance().getComponentStyle("Label");
        LabelTexte.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbtexte = new Label(r.getTexte(),FontImage.createMaterial(FontImage.MATERIAL_NOTE,LabelTexte));
      
        Style LabelDate1 = UIManager.getInstance().getComponentStyle("Label");
        LabelDate1.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbdate1 = new Label("Reclamation Date",FontImage.createMaterial(FontImage.MATERIAL_CALENDAR_TODAY,LabelDate1));
        
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
        Style LabelEtat = UIManager.getInstance().getComponentStyle("Label");
        LabelEtat.setFgColor(ColorUtil.rgb(0, 58, 94));
        Label lbetat = new Label(Str,FontImage.createMaterial(FontImage.MATERIAL_LABEL,LabelEtat));
         this.addAll(lbtexte1,lbtexte,lbetat1,lbetat,lbdate1,lbdate);
        setupSideMenu(res);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
    @Override
    protected void showOtherForm(Resources res) {
    }
    
    
}
