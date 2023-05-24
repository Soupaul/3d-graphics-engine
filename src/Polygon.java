import java.util.ArrayList;
import java.awt.Color;

public class Polygon {

    public ArrayList<Vector> vertices;
    public Color color;

    public Polygon(ArrayList<Vector> vertices) {
        this.vertices = vertices;
        this.color = Color.WHITE;
    }

    public Polygon(ArrayList<Vector> vertices, Color color) {
        this.vertices = vertices;
        this.color = color;
    }

    public ArrayList<Vector> returnPointsArray() {

        ArrayList<Vector> pts = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {

            if (i != vertices.size() - 1) {

                LineSegment ls = new LineSegment(vertices.get(i), vertices.get(i + 1), color);
                pts.addAll(ls.returnPointsArray());

            } else {

                LineSegment ls = new LineSegment(vertices.get(i), vertices.get(0), color);
                pts.addAll(ls.returnPointsArray());

            }

        }

        return pts;

    }

}
