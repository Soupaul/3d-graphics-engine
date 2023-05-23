import java.util.ArrayList;
import java.awt.Graphics2D;

public class LineSegment {

    public ArrayList<Vector> points;
    public Vector start;
    public Vector end;

    public LineSegment(Vector start, Vector end) {
        this.start = start;
        this.end = end;
        points = new ArrayList<>();
    }

    public LineSegment(int x1, int y1, int x2, int y2) {
        this.start = new Vector(x1, y1);
        this.end = new Vector(x2, y2);
        points = new ArrayList<>();
    }

    // Bresenham's Algorithm
    public void draw(Graphics2D g2d) {

        int dx = Math.abs(start.coords[0] - end.coords[0]);
        int sx = start.coords[0] < end.coords[0] ? 1 : -1;
        int dy = -Math.abs(start.coords[1] - end.coords[1]);
        int sy = start.coords[1] < end.coords[1] ? 1 : -1;
        int error = dx + dy;

        int x = start.coords[0], y = start.coords[1];

        while (true) {

            Vector p = new Vector(x, y);
            points.add(p);
            p.draw(g2d);

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

    }

}
