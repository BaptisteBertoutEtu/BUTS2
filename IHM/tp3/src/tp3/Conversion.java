package tp3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Conversion extends Application{
	public void start(Stage stage) {
		Button toL = new Button("€ -> £");
		Button toE = new Button("£ -> €");
		TextField textRight = new TextField("0");
		TextField textLeft = new TextField("0");
		Label euro = new Label("€");
		Label livre = new Label("£");
		

		HBox hbox = new HBox(5);
        hbox.setPadding(new Insets(3, 3, 3, 3));
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(2);
        hbox.getChildren().addAll(textLeft,euro,vbox,textRight,livre);
        vbox.getChildren().addAll(toL,toE);
        
        toL.setOnMousePressed(e -> {
        	double value = Double.parseDouble(textLeft.getText());
        	textRight.setText("" + (value * 0.87));
        });
        
        toE.setOnMousePressed(e -> {
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
