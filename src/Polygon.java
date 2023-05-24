import java.util.ArrayList;
import java.awt.Color;

public class Polygon {

    public ArrayList<Vector> points;
    public Color color;

    public Polygon(ArrayList<Vector> points) {
        this.points = points;
        this.color = Color.WHITE;
    }

    public Polygon(ArrayList<Vector> points, Color color) {
        this.points = points;
        this.color = color;
    }

    public ArrayList<Vector> returnPointsArray() {

        ArrayList<Vector> pts = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {

            if (i != points.size() - 1) {

                LineSegment ls = new LineSegment(points.get(i), points.get(i + 1), color);
                pts.addAll(ls.returnPointsArray());

            } else {

                LineSegment ls = new LineSegment(points.get(i), points.get(0), color);
                pts.addAll(ls.returnPointsArray());

            }

        }

        return pts;

    }

}
