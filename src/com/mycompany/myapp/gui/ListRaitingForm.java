/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.cours;
import com.mycompany.myapp.gui.LikeButton;
import com.mycompany.myapp.gui.ShareButton;
import com.mycompany.myapp.services.ServiceCours;
import java.util.ArrayList;

/**
 *
 * @author AYOUB
 */
public class ListRaitingForm  extends SideMenuBaseForm{

    ArrayList<cours> list;
   private Resources theme;
   public boolean resultOK;
    private ConnectionRequest req;
    
    private Resources resourceObjectInstance;
    
      public ListRaitingForm(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar(); 
        tb.setTitleCentered(false);
        
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label("Courses", "Title")
                                )
                            )
                );
        
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);
       
         list=new ArrayList<>();
         list=ServiceCours.getInstance().getAllRate();
        
          
         for(cours p:list){
          Container c1=new Container(BoxLayout.y());
          Style Label1 = UIManager.getInstance().getComponentStyle("Label");
          Label1.setFgColor(ColorUtil.rgb(0, 58, 94));
          Label l = new Label(p.getName(),FontImage.createMaterial(FontImage.MATERIAL_IMPORT_CONTACTS,Label1));
 
           
            c1.add(l);
             add(c1);
           
      
            
             l.addPointerPressedListener((ActionEvent e)->{
                Form f2=new Form(" All Courses Available with Rates  ", BoxLayout.y());
             
                SpanLabel sp=new SpanLabel("Details Rating of courses");
                sp.setWidth(20);
               // ImageViewer uni = new ImageViewer(theme.getImage("uni.jpg"));
                 TextField spl=new  TextField(p.getName());
                int id = p.getId();
               TextField spl2=new  TextField(p.getType(),"Type : ");
                 TextField spl3=new  TextField(p.getDescription(),"description : ");
                TextField spl4=new  TextField(p.getNomfile(),"nomfile : ");
                  TextField spl5=new  TextField(""+p.getEnable());
//                ConnectionRequest con = new ConnectionRequest(); 
//                con.addResponseListener((event) -> {
//
//            String reponse = new String(con.getResponseData());
//            
//            System.out.println(reponse);
            
                 System.out.println(p);
                 Button mg= new Button("Click here to rate this Courses ");mg.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
                 Button up= new Button("Update this Courses ");up.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
                 Button de= new Button(" Delete "+p.getName());de.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
                        
                  up.addActionListener( new ActionListener()  {
                   @Override
            public void actionPerformed(ActionEvent evt) {
                  //ServiceCours sc= new ServiceCours();
                 cours p=new cours();
                 
                 p.setId(id);
                 p.setName(spl.getText());
                 p.setType(spl2.getText());
                 p.setDescription(spl3.getText());
                 
               if(ServiceCours.getInstance().UpdateCour(p))
                  Dialog.show("Update", " Courses has been updtated", "ok", null);
                  else
                   Dialog.show("Error", "error servor", "ok", null);
                  new ListRaitingForm(res).show();
                  
                  }
                  }); 

                






                  de.addActionListener( new ActionListener()  {
                   @Override
            public void actionPerformed(ActionEvent evt) {
                  //ServiceCours sc= new ServiceCours();
               if(ServiceCours.getInstance().deleteCour(p))
                  Dialog.show("Supp", "Suppression éffectuée avec succés", "ok", null);
                  else
                   Dialog.show("Error", "error servor", "ok", null);
                  new ListRaitingForm(res).show();
                  
                  }
                  });
                 Slider ss=new Slider();
                 Label qte = new Label("RATING : 0 / 5 ");
                  
                 qte.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
                 ss.setEditable(true);
                 ss.setMinValue(0);
                 ss.setMaxValue(5);
                  ss.addActionListener((e1) -> {

                qte.setText("Note :" + ss.getProgress());
            });
                  
                  mg.addActionListener( new ActionListener()  {
                   @Override
            public void actionPerformed(ActionEvent evt) {
                  //ServiceCours sc= new ServiceCours();
               if(ServiceCours.getInstance().RateCour(p))
                  Dialog.show("Rate", "Rating éffectué avec succés avec une note de :"+qte.getText(), "ok", null);
                  else
                   Dialog.show("Error", "error servor", "ok", null);
                  new ListRaitingForm(res).show();
                  
                  }
                  }); 
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
//                  mg.addActionListener(( evt1) -> {
//                   
//         String url = Statics.BASE_URL+"/mobile/rate/" +p.getId();
//                       
//                   System.out.println(url);
//                       
//        req.setUrl(url);
//        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//// produits = parseProduits(new String(req.getResponseData()));
//
//
//                                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//                   
//                   
//                    Dialog.show("RAITING", "Raiting éffectuée avec succés", "ok", null);
//                   
//                   
//                   
//                   
//                   
//                   
//                   });
                  
                
                Container c2 = new Container(BoxLayout.x());
                ShareButton sh = new ShareButton();
                LikeButton li = new LikeButton();
                c2.addAll(sh,li);
                Container c3 = new Container(BoxLayout.y());
                f2.setScrollableY(true);
                c3.addAll(sp,spl,spl2,spl3,spl5,ss,up,mg,de);
             
                f2.addAll(c3);


                f2.getToolbar().addCommandToLeftBar("Back", null, ev->{
                    this.show();
                });
                f2.show();
               
            });
            c1.setLeadComponent(l);
           
         }
        
        setupSideMenu(res);
        
       
      
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    protected void showOtherForm(Resources res) {
        
     }
    
    
}
