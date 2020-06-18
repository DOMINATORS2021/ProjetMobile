package com.mycompany.myapp.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.materialscreens.SideMenuBaseForm;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.services.ServiceProduit;
import com.mycompany.myapp.services.ServiceProduit;

import java.util.ArrayList;

public class ListeProduits extends SideMenuBaseForm {

    ArrayList<Produit> list;
    private Resources theme;

    private Resources resourceObjectInstance;

    public ListeProduits(Resources res) {
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
                                new Label("Produits", "Title")
                        )
                )
        );

        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
        FontImage arrowDown = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_DOWN, "Label", 3);

        list = new ArrayList<>();
        list = ServiceProduit.getInstance().getAllProduits();

        for (Produit p : list) {
//            Form faa = new Form();
            Container c1 = new Container(BoxLayout.y());
//            Container c5 = new Container(BoxLayout.y());
            Label l = new Label(p.getNom());
//                    String url = "http://127.0.0.1/HuntKingdom/web/Upload/"+p.getNomfile();
//                    EncodedImage enc = EncodedImage.createFromImage(theme.getImage("téléchargement.jpg"), false);
//                    URLImage urlimg = URLImage.createToStorage(enc, p.getNom(), url);
//   
////
////                    Produit p = new Produit(10, "Voopoo", urlimg, url);
//
            c1.add(l);
//            
            add(c1);

//             
            l.addPointerPressedListener(e -> {
                Form f2 = new Form("Détails Produits", BoxLayout.y());

                SpanLabel sp = new SpanLabel("Détails produit");
                sp.setWidth(20);
                //ImageViewer uni = new ImageViewer(theme.getImage("uni.jpg"));
                SpanLabel spl = new SpanLabel("Nom du produit : " + "  " + p.getNom());
                SpanLabel spl2 = new SpanLabel("Type : " + "  " + p.getType());
                SpanLabel spl3 = new SpanLabel("Prix : " + "  " + p.getPrix());
                SpanLabel spl4 = new SpanLabel("Quantite : " + "  " + p.getQuantite());
                SpanLabel spl5 = new SpanLabel("Nouveau Prix : " + "  " + p.getNvprix());
                

                System.out.println(p);
//                 Button mg= new Button("Action");
                Button modif = new Button("Modifier");
                Button sup = new Button("Supprimer");
                sup.getAllStyles().setTextDecoration(Style.BACKGROUND_GRADIENT_LINEAR_HORIZONTAL);
                sup.addActionListener((evt) -> {
                    Form f = new Form(BoxLayout.y());
                    Container c = new Container();
//                c.addAll(mg,sup);
//               TextField prixmg = new TextField( (int) p.getPrix_Mg());
//               TextField  quantitemg = new TextField(p.getNvquantite());
//                Button btnaff = new Button("Delete");
//                btnaff.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);
//                f.addAll(prixmg,quantitemg,btnaff,sup);
//                f.show();
//                 f.getToolbar().addCommandToLeftBar("Back", null, ev->{
//                    f2.show();
//                });
//                f2.show();
//                mg.addActionListener((evt2)->{
//               f.add(c);
//               f.show();
//               sup.addActionListener((v)->{

                    SupprimerStock(p.getId());
                    System.out.println("stock supprimé");
                    Dialog.show("Alert", "supprimer ce stock?", new Command("OK"));
                    Dialog.show("Success", "Stock supprimé avec succès", new Command("OK"));
                    f2.show();

//                     if (((prixmg.getText().length()==0))||((quantitemg.getText().length()==0))){
//                           Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
//                          
//                      }
//                      else {
                    ServiceProduit ser = new ServiceProduit();
////                    p.setPrix_Mg(Double.parseDouble(prixmg.getText()));
////                    p.setNvquantite(Integer.parseInt(quantitemg.getText()));

//                    ser.affecterProduit(p, res);
                });
                modif.addActionListener((evt) -> {
                    Form f3 = new Form();
                    Container Cmodif = new Container(BoxLayout.y());
                    Container Cmodif1 = new Container(BoxLayout.x());
                    Container Cmodif2 = new Container(BoxLayout.x());
                    Container Cmodif3 = new Container(BoxLayout.x());
                    Container Cmodif4 = new Container(BoxLayout.x());

                    TextField nomm = new TextField("", "nom");
                    double pricem = p.getPrix();
                    Label ln = new Label("Nom:");
                    Label lpr = new Label("Prix:");
//           Label lmrq = new Label("Marque:"); 
                    Label lqt = new Label("Quantite:");
                    TextField prixm = new TextField("prix");
//           TextField marquem = new TextField("marque");
                    TextField quantitem = new TextField("quantite");

                    Button valid = new Button("Enregistrer");
                    nomm.setText(p.getNom());
                    prixm.setText(Double.toString(pricem));
//           marquem.setText( g.getMarque());
                    quantitem.setText(Integer.toString(p.getQuantite()));
                    Cmodif1.addAll(ln, nomm);
                    Cmodif2.addAll(lpr, prixm);
//           Cmodif3.addAll(lmrq,marquem); 
                    Cmodif4.addAll(lqt, quantitem);
                    Cmodif.addAll(Cmodif1, Cmodif2, Cmodif3, Cmodif4, valid);
                    // Cmodif.addAll(nomm,prixm,marquem,quantitem,valid);
                    f3.add(Cmodif);
                    f3.show();
                    valid.addActionListener((ev) -> {
                        ModifierStock(p.getId(), nomm.getText(),Float.parseFloat(prixm.getText()), Integer.parseInt(quantitem.getText()));
                        System.out.println("stock modifié");
                        Dialog.show("Success", "Stock modifié avec succès", new Command("OK"));

                        f2.show();
                    });
                });

                Container c2 = new Container(BoxLayout.x());
                ShareButton sh = new ShareButton();
                LikeButton li = new LikeButton();
                c2.addAll(sh, li);
                Container c3 = new Container(BoxLayout.y());
                f2.setScrollableY(true);
//                c5.add(urlimg);
                c3.addAll(sp, spl, spl2, spl3, spl4,spl5,sup, modif);

                f2.addAll(c3, c2);

                f2.getToolbar().addCommandToLeftBar("Back", null, ev -> {
                    this.show();
                });
                f2.show();

            });
           c1.setLeadComponent(l);

        }

        setupSideMenu(res);

    }

    /*private void addButtonBottom(Image arrowDown, String text, int color, boolean first) {
     MultiButton finishLandingPage = new MultiButton(text);
     finishLandingPage.setEmblem(arrowDown);
     finishLandingPage.setUIID("Container");
     finishLandingPage.setUIIDLine1("TodayEntry");
     finishLandingPage.setIconUIID("Container");
     add(FlowLayout.encloseIn(finishLandingPage));
     }*/
    @Override
    protected void showOtherForm(Resources res) {
    }

    /*   void search(String text) {
     if(text == null || text.length() == 0) {
     System.out.println("sss");
     c1.setHidden(false);
     c1.setVisible(true);
               
     }
     else {
     for(Component c1 :getContentPane())
     {
     //  System.out.println(c1.);
     text = text.toLowerCase();
     }
     }
     getContentPane().animateLayout(200);
     }

     */
    public void SupprimerStock(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MonProjet1/web/app_dev.php/DeleteProductMob/" + id);
        con.setPost(false);
        con.addResponseListener((evt) -> {
            System.out.println(con.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }

    public void ModifierStock(int id, String nom, float prix, int qte) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/MonProjet1/web/app_dev.php/ModiferStockMobile/" + id + "/" + nom
                + "/" + prix + "/" + qte;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
}
