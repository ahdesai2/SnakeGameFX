
import javafx.scene.effect.Light.Point;
import javafx.scene.paint.Color;

/**
 * A simple class to represent food that takes up only one square.
 *
 */
public class Food {
    public static final Color COLOR = Color.PINK;

    private Point point;

    Food(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}