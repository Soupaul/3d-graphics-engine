import java.awt.Color;
import java.util.ArrayList;

public class Circle {

    public Vector centre;
    public int radius;
    public Color color;

    public Circle(Vector c, int r) {
        centre = c;
        radius = r;
        color = Color.WHITE;
    }

    public Circle(Vector c, int r, Color col) {
        centre = c;
        radius = r;
        color = col;
    }

    public Circle(int x, int y, int r) {
        centre = new Vector(x, y);
        radius = r;
        color = Color.WHITE;
    }

    public Circle(int x, int y, int r, Color col) {
        centre = new Vector(x, y);
        radius = r;
        color = col;
    }

    // Mid-point Circle Algorithm
    public ArrayList<Vector> returnPointsArray() {

        ArrayList<Vector> points = new ArrayList<>();

        int d = (5 - radius * 4) / 4;
        int x = 0, y = radius;

        do {

            points.add(new Vector(centre.coords[0] + x, centre.coords[1] + y, color));
            points.add(new Vector(centre.coords[0] + x, centre.coords[1] - y, color));
            points.add(new Vector(centre.coords[0] - x, centre.coords[1] + y, color));
            points.add(new Vector(centre.coords[0] - x, centre.coords[1] - y, color));
            points.add(new Vector(centre.coords[0] + y, centre.coords[1] + x, color));
            points.add(new Vector(centre.coords[0] + y, centre.coords[1] - x, color));
            points.add(new Vector(centre.coords[0] - y, centre.coords[1] + x, color));
            points.add(new Vector(centre.coords[0] - y, centre.coords[1] - x, color));

            if (d < 0) {
                d += 2 * x + 1;
            } else {
                d += 2 * (x - y) + 1;
                y--;
            }
            x++;

        } while (x <= y);

        return points;

    }

}
