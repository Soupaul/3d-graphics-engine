import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Camera extends JComponent {

    ArrayList<Object> gameObjects;
    // Culling parameters
    int minX, minY, maxX, maxY;

    public Camera(int minX, int minY, int maxX, int maxY) {
        gameObjects = new ArrayList<>();
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Rendering starts here
        renderScene(g2d);

    }

    public void renderScene(Graphics2D g2d) {

        // Setting backdrop of the Camera
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Setting the Culling boundary of the Camera
        g2d.setColor(Color.WHITE);
        g2d.drawRect(minX, minY, maxX - minX, maxY - minY);

        // Rendering Game Objects with Culling
        for (Object gameObject : gameObjects) {

            if (gameObject instanceof Vector) {

                Vector v = ((Vector) gameObject);

                if (v.coords[0] >= minX && v.coords[0] <= maxX && v.coords[1] >= minY && v.coords[1] <= maxY) {
                    v.draw(g2d);
                }

            } else if (gameObject instanceof LineSegment) {

                ArrayList<Vector> pointsArray = ((LineSegment) gameObject).returnPointsArray();
                for (Vector p : pointsArray) {
                    if (p.coords[0] >= minX && p.coords[0] <= maxX && p.coords[1] >= minY && p.coords[1] <= maxY) {
                        p.draw(g2d);
                    }
                }

            } else if (gameObject instanceof Circle) {

                ArrayList<Vector> pointsArray = ((Circle) gameObject).returnPointsArray();
                for (Vector p : pointsArray) {
                    if (p.coords[0] >= minX && p.coords[0] <= maxX && p.coords[1] >= minY && p.coords[1] <= maxY) {
                        p.draw(g2d);
                    }
                }

            } else if (gameObject instanceof Polygon) {

                ArrayList<Vector> pointsArray = ((Polygon) gameObject).returnPointsArray();
                for (Vector p : pointsArray) {
                    if (p.coords[0] >= minX && p.coords[0] <= maxX && p.coords[1] >= minY && p.coords[1] <= maxY) {
                        p.draw(g2d);
                    }
                }

            }

        }

    }

}
