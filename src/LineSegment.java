import java.util.ArrayList;
import java.awt.Color;

public class LineSegment {

    public Vector start;
    public Vector end;
    public Color color;

    public LineSegment(Vector start, Vector end) {
        this.start = start;
        this.end = end;
        color = Color.WHITE; // default white color on black canvas
    }

    public LineSegment(Vector start, Vector end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public LineSegment(int x1, int y1, int x2, int y2) {
        this.start = new Vector(x1, y1);
        this.end = new Vector(x2, y2);
        color = Color.WHITE;
    }

    public LineSegment(int x1, int y1, int x2, int y2, Color color) {
        this.start = new Vector(x1, y1);
        this.end = new Vector(x2, y2);
        this.color = color;
    }

    // Bresenham's Algorithm
    public ArrayList<Vector> returnPointsArray() {

        ArrayList<Vector> points = new ArrayList<>();

        int dx = Math.abs(start.coords[0] - end.coords[0]);
        int sx = start.coords[0] < end.coords[0] ? 1 : -1;
        int dy = -Math.abs(start.coords[1] - end.coords[1]);
        int sy = start.coords[1] < end.coords[1] ? 1 : -1;
        int error = dx + dy;

        int x = start.coords[0], y = start.coords[1];

        while (true) {

            Vector p = new Vector(x, y, color);
            points.add(p);

            if (x == end.coords[0] && y == end.coords[1])
                break;
            int e2 = 2 * error;

            if (e2 >= dy) {

                if (x == end.coords[0])
                    break;
                error = error + dy;
                x += sx;

            }

            if (e2 <= dx) {

                if (y == end.coords[1])
                    break;
                error = error + dx;
                y += sy;

            }

        }

        return points;

    }

}
