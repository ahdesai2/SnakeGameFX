//NEW NEW SNAKE







import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Snake {
    
    // snake dimensions
    private final int WIDTH = 20;
    private final int HEIGHT = 20;
    
    // create the snake rectangle
    private Rectangle snake = new Rectangle(WIDTH, HEIGHT, Color.GREEN);
    
    // snake movement
    private int dx = 0;
    private int dy = 0;
    
    // create the food rectangle
    private Rectangle food;
    
    public Snake() {
        // set the initial position of the snake
        snake.setLayoutX(250);
        snake.setLayoutY(250);
        
        // add the snake to the game window
        SnakeGame.root.getChildren().add(snake);
        
        // set up the snake movement
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move();
            }
        };
        timer.start();
        
        // create the food
        spawnFood();
    }
    
    public void move() {
        // update the position of the snake
        snake.setLayoutX(snake.getLayoutX() + dx);
        snake.setLayoutY(snake.getLayoutY() + dy);
        
        // check for collision with edges of the game window
        if (snake.getLayoutX() < 0 || snake.getLayoutX() > SnakeGame.WIDTH - WIDTH
                || snake.getLayoutY() < 0 || snake.getLayoutY() > SnakeGame.HEIGHT - HEIGHT) {
            // game over
            System.out.println("Game Over");
            System.exit(0);
        }
        
        // check for collision with food
        if (snake.getBoundsInParent().intersects(food.getBoundsInParent())) {
            // eat the food
            SnakeGame.root.getChildren().remove(food);
            spawnFood();
            growSnake();
        }
        
        // check for collision with itself
        for (Node node : SnakeGame.root.getChildren()) {
            if (node != snake && snake.getBoundsInParent().intersects(node.getBoundsInParent())) {
                // game over
                System.out.println("Game Over");
                System.exit(0);
          }
        }
    }
    
    public void setDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
    
    private void spawnFood() {
        // create the food rectangle
        food = new Rectangle(WIDTH, HEIGHT, Color.RED);
        
        // set the position of the food randomly
        Random random = new Random();
        food.setLayoutX(random.nextInt((int) (SnakeGame.WIDTH / WIDTH)) * WIDTH);
        food.setLayoutY(random.nextInt((int) (SnakeGame.HEIGHT / HEIGHT)) * HEIGHT);
            // add the food to the game window
        SnakeGame.root.getChildren().add(food);
  }
  
  private void growSnake() {
      // create a new rectangle to represent the new part of the snake
      Rectangle newPart = new Rectangle(WIDTH, HEIGHT, Color.GREEN);
      
      // set the position of the new part of the snake to be behind the current snake
      newPart.setLayoutX(snake.getLayoutX() - dx);
      newPart.setLayoutY(snake.getLayoutY() - dy);
      
      // add the new part of the snake to the game window
      SnakeGame.root.getChildren().add(newPart);
  }
  
}
//END OF WORKING SNAKE CODE!!!!*/


//old code
/* import java.util.ArrayList;
import java.util.List;

import com.sun.prism.paint.Color;

import javafx.scene.shape.Circle;

public class Snake extends Circle {
    private List<Circle> tails; 
    private int length = 0 ;
    private Direction currentDirection;
    private static final int STEP = 8;


    public Snake(double d, double d1, double d2){
        super(d, d1, d2);
        tails =  new ArrayList<>();
        currentDirection =  Direction.UP;
    }

    public void step(){
for(int i = length - 1; i >= 0; i--){
    if (i == 0){
        tails.get(i).setCenterX(getCenterX());
        tails.get(i).setCenterY(getCenterY());
    }
    else{
        tails.get(i).setCenterX(tails.get(i - 1).getCenterX());
        tails.get(i).setCenterY(tails.get(i -1).getCenterY());
    }
}


        if(currentDirection == Direction.UP){
            setCenterY(getCenterY() - STEP);
            }
            else if (currentDirection == Direction.DOWN){
                setCenterY(getCenterY() + STEP);
            }
            else if (currentDirection == Direction.LEFT){
                setCenterX(getCenterY() - STEP);
            }
            else if (currentDirection == Direction.RIGHT){
                setCenterX(getCenterY() + STEP);
            }
    }

boolean eatSelf(){
    for(int i = 0; i < length; i++){
        if(this.getCenterX() == tails.get(i).getCenterX() && this.getCenterY()==tails.getCenterY()) {
            return true; 
        }
    }
    return false;
}


    public int getLength() {
        return 0;
    }  

public Direction getCurrentDirection() {
    return currentDirection;
}
public void setCurrentDirection(Direction currentDirection) {
    this.currentDirection = currentDirection;
}

private Circle endTail(){
    if(length ==0){
        return this;
    }
    return tails.get(length - 1);
}
public void eat(Circle food) {
Circle tail = endTail();
food.setCenterX(tail.getCenterX());
food.setCenterY(tail.getCenterY());
//food.setFill(Color.BLACK);
tails.add(length++, food);
}


} */
