package tp4;

import java.io.File;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ListeSimple extends Application {
  Label label;

  class MonListChangeListener implements ListChangeListener<String> {
    public void onChanged(Change<? extends String> report) {
      label.setText("Selection de " + report.getList());
    }
  }
  
  class NewList implements ListChangeListener<String> {
	public void onChanged(Change<? extends String> report) {
		label.setText("Selection de " + report.getList());
	}
  }

  public void start(Stage stage) {
    ListView<String> list = new ListView<String>();
    ListView<String> list2 = new ListView<String>();
    HBox root = new HBox();
    Scene scene = new Scene(root, 400, 150);
    File path = new File("C:/Users/bapti/Documents/gendarmerie");
    
    
    
    String[] filelist = path.list();
    
    
    label = new Label("Aucune selection");
   
    list.getItems().addAll(filelist);
    list.getSelectionModel().getSelectedItems().addListener(new MonListChangeListener());

    root.setAlignment(Pos.CENTER_LEFT);
    root.setSpacing(10.0);
    root.setPadding(new Insets(3, 3, 3, 3));
    root.getChildren().addAll(list,label);

    stage.setTitle("Simple liste");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}