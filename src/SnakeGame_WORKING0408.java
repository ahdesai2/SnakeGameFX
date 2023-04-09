import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SnakeGame extends Application {
    
    // window dimensions
    final static int WIDTH = 600;
    final static int HEIGHT = 600;
    
    // create the game window
    public static Pane root = new Pane();
    private Scene scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);
    
    // create the snake object
    Snake snake = new Snake();

    public SnakeGame() {
    }

    public void start(Stage stage) throws Exception {
        // set up the game window
        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.show();
        
        // set up the event listeners
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                snake.setDirection(-2, 0);
            } else if (e.getCode() == KeyCode.RIGHT) {
                snake.setDirection(2, 0);
            } else if (e.getCode() == KeyCode.UP) {
                snake.setDirection(0, -2);
            } else if (e.getCode() == KeyCode.DOWN) {
                snake.setDirection(0, 2);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}




//old code
/*import java.util.Random;

import com.sun.glass.events.KeyEvent;
import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SnakeGame extends Application{

private static final int PREFERRED_WIDTH = 600;
private static final int PREFERRED_HIGHT = 500;
private static final int RADIUS = 5;
//private static final int STEP = 8;

private Pane root; 
private Text score;
private Circle food;
private Random random;
private Snake snake;

//private Direction currentDirection;

private void newFood(){
food = new Circle(random.nextInt(PREFERRED_WIDTH), random.nextInt(PREFERRED_HIGHT), RADIUS);
//food. setFill(Color.RED);
root.getChildren().add(food);
}

private void newSnake () {
 snake = new Snake (PREFERRED_WIDTH / 2, PREFERRED_HIGHT / 2, RADIUS +2);
root.getChildren().add(snake);
for(int i = 0; i < 25; i ++ ){
    newFood();
    snake.eat(food);
}
}

private boolean hit(){
    return food.intersects(snake.getBoundsInLocal());
}

private boolean gameOver(){
    return snake.eatSelf();
}




private void move(){
    Platform.runLater(() -> {
snake.step();
adjustLocation();
if(hit()){
    snake.eat(food);
    score.setText(""+ snake.getLength());
    newFood();
}
else if (gameOver()){
   root.getChildren().clear();
   root.getChildren().add(score);
   score.setText("Game Over " + snake.getLength());
   newSnake();
   newFood();
}
});

}

private void adjustLocation(){
    if(snake.getCenterX() < 0){
     snake.setCenterX(PREFERRED_WIDTH);
    }
    else if(snake.getCenterX() > PREFERRED_WIDTH){
    snake.setCenterX(0);
}
if(snake.getCenterY() < 0){
    snake.setCenterY(PREFERRED_HIGHT);
   }
   else if(snake.getCenterY() > PREFERRED_HIGHT){
   snake.setCenterY(0);
}
}

@Override  
    public void start(Stage primaryStage) throws Exception {  
       
        root = new Pane();
        root.setPrefSize (PREFERRED_WIDTH, PREFERRED_HIGHT);
        random = new Random();
        
    newFood();
    newSnake();

    Runnable r = () -> {
    try {
        for(;;){
           move();
           Thread.sleep(100/(1+snake.getLength()/10));  
           
    }
} catch (InterruptedException ie){
}
    };

    Scene scene = new Scene(root);

   
   
   
   
   
    primaryStage.setTitle("Snake Game!");  
    primaryStage.setScene(scene); 
    primaryStage.setResizable(false); 
    primaryStage.show(); 
    Thread th = new Thread(r);
    th.setDaemon(true); 
    th.start();
}  
public static void main(String[] args) {  
    launch(args);  
}
  
} */