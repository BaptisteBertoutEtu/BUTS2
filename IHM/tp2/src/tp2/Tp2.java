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

public class Tp2 extends Application{
	private int tailleCarre = 20;
	
	public void start(Stage stage) {
        VBox root = new VBox();
        Canvas canvas = new Canvas (800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.setFill(Color.ORANGE);
//        gc.fillRect(40, 100, 20, 20);
//        gc.setStroke(Color.BLACK);
//        gc.strokeRect(40, 100, 20, 20);
        root.getChildren().add(canvas);
        ArrayList<Rectangle> keepSquare = new ArrayList<Rectangle>();

        canvas.setOnMouseClicked(e -> {
        	
        	if(e.isShiftDown()) {
        		for (Rectangle rectangle : keepSquare) {
					if(rectangle.contains(e.getSceneX(), e.getSceneY())) {
		        		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		        		keepSquare.remove(rectangle);
		        		break;
					}
				}
        		for (Rectangle rectangle2 : keepSquare) {
					gc.setFill(Color.ORANGE);
					gc.fillRect(rectangle2.getX(), rectangle2.getY(), tailleCarre, tailleCarre);
					gc.setStroke(Color.BLACK);
	        		gc.strokeRect(rectangle2.getX(), rectangle2.getY(), tailleCarre,tailleCarre);
				}
        		
        	}
        	else {
        		
        		Rectangle carre = new Rectangle(e.getSceneX()-10, e.getSceneY()-10, tailleCarre,tailleCarre);
        		keepSquare.add(carre);
        		gc.setFill(Color.ORANGE);
        		gc.fillRect(e.getSceneX()-10, e.getSceneY()-10, tailleCarre,tailleCarre);
        		gc.setStroke(Color.BLACK);
        		gc.strokeRect(e.getSceneX()-10, e.getSceneY()-10, tailleCarre,tailleCarre);
        	}
        });
        
        canvas.setOnMouseDragged(e -> {
        	gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        	for (Rectangle rectangle : keepSquare) {
				if(rectangle.contains(e.getSceneX(), e.getSceneY())) {
					rectangle.setX (e. getSceneX () - 10);
					rectangle.setY (e. getSceneY () - 10);
					gc.setFill(Color.ORANGE);
	        		gc.fillRect( rectangle.getX () , rectangle.getY () , rectangle.getWidth () , rectangle.getHeight ());
	        		gc.setStroke(Color.BLACK);
	        		gc.strokeRect( rectangle.getX () , rectangle.getY () , rectangle.getWidth () , rectangle.getHeight ());
				}
			}
        	for (Rectangle rectangle2 : keepSquare) {
				gc.setFill(Color.ORANGE);
				gc.fillRect(rectangle2.getX(), rectangle2.getY(), tailleCarre, tailleCarre);
				gc.setStroke(Color.BLACK);
        		gc.strokeRect(rectangle2.getX(), rectangle2.getY(), tailleCarre,tailleCarre);
			}
        });
        
        
        
        
        
        
        
        
        
        
        
        
        Scene scene = new Scene(root);
        stage.setTitle("Hello Paint");
        stage.setScene(scene);
        stage.show();
}

public static void main(String[] args) {
        Application.launch(args);
}
}
