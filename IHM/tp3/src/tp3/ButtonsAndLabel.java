package tp3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonsAndLabel extends Application{
	int getX;
	
	public void start(Stage stage) {
        Label label = new Label("0");
        Button bmoins = new Button("  -  ");
        Button bplus = new Button("  +  ");
        VBox vbox = new VBox(3);
        HBox hbox = new HBox(3);
        
        
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        label.setStyle("-fx-background-color: lightblue;"
        		+ " -fx-alignment: center;"
        		+ " -fx-font: 30px Verdana;");
        vbox.setPadding(new Insets(3, 3, 3, 3));
        vbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(bmoins, bplus);
        vbox.getChildren().addAll(label, hbox);
        
        bplus.setOnMouseClicked(e -> {
        	int value = Integer.parseInt(label.getText());
        	label.setText(""+ (value +1));
        });
        
        bmoins.setOnMouseClicked(e -> {
        	int value = Integer.parseInt(label.getText());
        	label.setText(""+ (value - 1));
        });
        
        label.setOnMousePressed(e -> {
        	getX = (int) e.getX();
        	
        	if(e.isPrimaryButtonDown()) {
        		int value = Integer.parseInt(label.getText());
            	label.setText(""+ (value -1));
        	}
        	else if(e.isSecondaryButtonDown()) {
        		int value = Integer.parseInt(label.getText());
            	label.setText(""+ (value +1));
        	}
        });
        
        label.setOnMouseDragged(e -> {
        	int value = Integer.parseInt(label.getText());
        	int getXDeux = (int) e.getX();
        	label.setText(""+ (value + getXDeux - getX));
   
        });
        
        label.setOnScroll(e -> {
        	int value = Integer.parseInt(label.getText());
        	if(e.getDeltaY() > 1) {
        		label.setText("" + (value + 1));
        	}
        	else {
        		label.setText("" + (value - 1));
        	}
        });

        Scene scene = new Scene(vbox);
        stage.setTitle("Counter");
        stage.setScene(scene);
        stage.show();
}

public static void main(String[] args) {
        Application.launch(args);
}
}
