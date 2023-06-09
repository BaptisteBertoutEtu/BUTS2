package tp1;

import java.rmi.server.RMIFailureHandler;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tp1 extends Application {

  public void start(Stage stage) {


    /* exercice 4
    VBox root = new VBox();
    Label msg = new Label("Hello JavaFX");
    root.getChildren().add(msg);

    Scene scene = new Scene(root, 300, 50);
    stage.setScene(scene);
    stage.setTitle("Hello JavaFX");
    // stage.setFullScreen(true);
    // stage.setAlwaysOnTop(true);
    // stage.setOpacity(0.50);
    // stage.setResizable(false);
    stage.show();

    //boite verticale
    VBox fenetre2 = new VBox();
    Label msgFenetre2= new Label("Deuxieme fenetre modale");
    fenetre2.getChildren().add(msgFenetre2);

    Scene sceneFenetre2 = new Scene(fenetre2, 300, 50);
    Stage stage2 = new Stage();
    stage2.setScene(sceneFenetre2);
    stage2.setTitle("titre fenetere 2");
    // initialisation de la dépendance entre la deuxieme fenetre et la premiere, fille et mere
    stage2.initOwner(stage);
    // initialisation de la modalité, ici la premiere fenetre ne peux pas etre fermer tant que la deuxieme n'est pas fermée
    stage2.initModality(Modality.WINDOW_MODAL);

    stage2.setX(stage.getX()+300);
    stage2.setY(stage.getY()+50);
    stage2.show();*/

    //exercice 5
    /*avec flowpane
    FlowPane root = new FlowPane();
    Scene scene = new Scene(root, 1000, 500);
    stage.setScene(scene);
    stage.setTitle("FlowPane exemple");
    
    for (int i = 1; i < 11; i++) {
        root.getChildren().add(new Button("button"+i));
    }
    */

    /*hbox et vbox
    VBox vBox = new VBox();
    HBox hBox1 = new HBox();
    HBox hBox2 = new HBox();
    HBox hBox3 = new HBox();

    Scene scene = new Scene(vBox, 1000, 500);
    vBox.getChildren().add(hBox1);
    vBox.getChildren().add(hBox2);
    vBox.getChildren().add(hBox3);
    stage.setScene(scene);

    for (int i = 1; i < 6; i++) {
        hBox1.getChildren().add(new Button("button "+i));
    }
    for (int i = 6; i < 10; i++) {
        hBox2.getChildren().add(new Button("button "+i));
    }
    hBox3.getChildren().add(new Button("button 10"));
    stage.show();
    */

    /*Border pane
    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 1000, 500);
    stage.setScene(scene);

    Button b1 = new Button("Nord");
    Button b2 = new Button("Sud");
    Button b3 = new Button("Est");
    Button b4 = new Button("Ouest");
    Button b5 = new Button("Centre");
    root.setTop(b1);
    root.setBottom(b2);
    root.setLeft(b4);
    root.setRight(b3);
    root.setCenter(b5);
    b1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    stage.show();
    */

    /*tilepane
    TilePane root = new TilePane();
    Scene scene = new Scene(root, 1000,500);
    stage.setScene(scene);
    for (int i = 1; i < 17; i++) {
        root.getChildren().add(new Button("button "+i));
    }
    stage.show();
    */


    /* gridpane
    GridPane root = new GridPane();
    Scene scene = new Scene(root, 400, 200);
    stage.setScene(scene);
    Button b1 = new Button("boutton 1");
    Button b2 = new Button("boutton 2");
    Button b3 = new Button("boutton 3");
    Button b4 = new Button("boutton 4");
    Button b5 = new Button("boutton 5");
    Button b6 = new Button("boutton 6");
    Button b7 = new Button("boutton 7");
    Button b8 = new Button("boutton 8");
    Button b9 = new Button("boutton 9");
    Button b10 = new Button("boutton 10");

    root.getChildren().add(b1);
    root.getChildren().add(b2);
    root.getChildren().add(b3);
    root.getChildren().add(b4);
    root.getChildren().add(b5);
    root.getChildren().add(b6);
    root.getChildren().add(b7);
    root.getChildren().add(b8);
    root.getChildren().add(b9);
    root.getChildren().add(b10);

    b1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b7.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b8.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b9.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    b10.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


    GridPane.setColumnIndex(b1, 0);
    GridPane.setColumnIndex(b2, 1);
    GridPane.setColumnIndex(b3, 2);
    GridPane.setColumnIndex(b4, 3);

    GridPane.setRowIndex(b5, 1);
    GridPane.setColumnIndex(b5, 0);
    GridPane.setColumnSpan(b5, 4);

    GridPane.setRowIndex(b6, 2);
    GridPane.setColumnIndex(b6, 0);
    GridPane.setColumnSpan(b6, 3);

    GridPane.setRowIndex(b7, 2);
    GridPane.setColumnIndex(b7, 3);
    
    GridPane.setRowIndex(b8, 3);
    GridPane.setColumnIndex(b8, 0);
    GridPane.setRowSpan(b8, 2);

    GridPane.setRowIndex(b9, 3);
    GridPane.setColumnIndex(b9, 1);
    GridPane.setColumnSpan(b9, 3);

    GridPane.setRowIndex(b10, 4);
    GridPane.setColumnIndex(b10, 1);
    GridPane.setColumnSpan(b10, 3);


    stage.show();
    */

    /*Pane 
    Pane root = new Pane();
    Scene scene= new Scene(root, 400, 200);

    stage.setScene(scene);

    Button b1 = new Button("boutton 1");
    Button b2 = new Button("boutton 2");

    root.getChildren().add(b1);
    root.getChildren().add(b2);

    b1.setLayoutX(20);
    b1.setLayoutY(50);

    b2.setLayoutX(100);
    b2.setLayoutY(25);

    stage.show();
    */

    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 1000, 600);
    stage.setScene(scene);
    stage.setTitle("Editeur de texte");
    Menu fichier = new Menu("Fichier");
    Menu edition = new Menu("Edition");
    MenuBar menuBar = new MenuBar(new Menu[]{fichier,edition});

    TextArea text = new TextArea();

    Label recherche = new Label("Recherche : ");
    TextArea textRecherche = new TextArea();

    Image droite = new Image("C:/Users/bapti/Documents/cours/BUT_s2/IHM/tp1/images/droite.gif");
    Image gauche = new Image("C:/Users/bapti/Documents/cours/BUT_s2/IHM/tp1/images/gauche.gif");
    ImageView viewDroite = new ImageView(droite);
    ImageView viewGauche = new ImageView(gauche);
    Button right = new Button("",viewDroite);
    Button left = new Button("", viewGauche);
    Button surlign = new Button("Tout Surligner");

    root.getChildren().addAll(recherche,textRecherche,right,left,surlign);

    root.setTop(menuBar);
    root.setCenter(text);
    
    GridPane newGridPane= new GridPane();
    root.setBottom(newGridPane);
    newGridPane.getChildren().addAll(recherche,textRecherche,left,right,surlign);

    GridPane.setColumnIndex(recherche, 0);
    GridPane.setColumnIndex(textRecherche, 1);
    GridPane.setColumnIndex(left, 2);
    GridPane.setColumnIndex(right, 3);
    GridPane.setColumnIndex(surlign, 4);

    MenuItem nouveau = new MenuItem("Nouveau");
    MenuItem ouvrir = new MenuItem("Ouvrir");
    MenuItem enregistrer = new MenuItem("Enregistrer");
    MenuItem enregistrerSous = new MenuItem("Enregistrer sous");
    MenuItem miseEnPage = new MenuItem("Mise en page");
    MenuItem imprimer = new MenuItem("Imprimer");
    MenuItem quitter = new MenuItem("Quitter");

    fichier.getItems().addAll(nouveau,ouvrir,enregistrer,enregistrerSous,new SeparatorMenuItem(),miseEnPage,imprimer,new SeparatorMenuItem(),quitter);

    stage.show();

  }

    
  




  public static void main(String[] args) {
    Application.launch(args);
  }
}