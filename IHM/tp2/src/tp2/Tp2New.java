package tp2;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Tp2New extends Application {
	private int tailleCarre = 20;

    public void start(Stage stage) {
            VBox root = new VBox();
            Canvas canvas = new Canvas (300, 300);
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Scene scene = new Scene(root);
            ArrayList<Rectangle> keepScare = new ArrayList<Rectangle>();
            root.getChildren().add(canvas);
            
            
            canvas.setOnMouseClicked(e -> {
            	
            	if(e.isShiftDown()) {
            		for (Rectangle rectangle : keepScare) {
						if(rectangle.contains(e.getSceneX(), e.getSceneY())) {
							gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
							keepScare.remove(rectangle);
							break;
						}
					}
            		
            		for (Rectangle rectangle2 : keepScare) {
            			gc.setFill(Color.ORANGE);
                        gc.fillRect(rectangle2.getX(), rectangle2.getY(), tailleCarre, tailleCarre);
                        gc.setStroke(Color.BLACK);
                        gc.strokeRect(rectangle2.getX(), rectangle2.getY(), tailleCarre, tailleCarre);
					}
            	}
            	else {
            		
            		Rectangle square =new Rectangle(e.getSceneX()-10,e.getSceneY()-10,tailleCarre,tailleCarre);
            		keepScare.add(square);
            		gc.setFill(Color.ORANGE);
            		gc.fillRect(e.getSceneX()-10, e.getSceneY()-10, tailleCarre, tailleCarre);
            		gc.setStroke(Color.BLACK);
            		gc.strokeRect(e.getSceneX()-10, e.getSceneY()-10, tailleCarre, tailleCarre);
            	}
            });
            
            canvas.setOnMouseDragged(e -> {
            	
            });
            

            stage.setTitle("Hello Paint");
            stage.setScene(scene);
            stage.show();
    }
    
    

    public static void main(String[] args) {
            Application.launch(args);
    }
}
