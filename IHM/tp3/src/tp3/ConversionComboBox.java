package tp3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ConversionComboBox extends Application{
	public void start(Stage stage) {

		TextField textRight = new TextField("0");
		TextField textLeft = new TextField("0");
		Label toL = new Label("Euros <-> Livres");
		Label toD = new Label("Euros <-> Dollars");
		Label euro = new Label("€");
		Label livre = new Label("£");
		ComboBox<Label> box = new ComboBox<>();
		
		
		

		HBox hbox = new HBox(4);
        hbox.setPadding(new Insets(3, 3, 3, 3));
        hbox.setAlignment(Pos.CENTER);
        box.getItems().add(toL);
        box.getItems().add(toD);
        box.getSelectionModel().selectFirst();
        
        hbox.getChildren().addAll(textLeft,euro,box,textRight,livre);

        
        textLeft.setOnKeyReleased(e -> {
        	double value = Double.parseDouble(textLeft.getText());
        	textRight.setText("" + (value * 0.87));
        });
        
        textRight.setOnKeyReleased(e -> {
        	double value = Double.parseDouble(textRight.getText());
        	textLeft.setText("" + (value * 1.15));
        	
        });

        Scene scene = new Scene(hbox);
        stage.setTitle("Conversion");
        stage.setScene(scene);
        stage.show();
}

public static void main(String[] args) {
        Application.launch(args);
}
}
