import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Camera extends JComponent {

    ArrayList<Object> gameObjects;

    public Camera() {
        gameObjects = new ArrayList<>();
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

        // Rendering Game Objects
        for (Object gameObject : gameObjects) {

            if (gameObject instanceof Vector) {

                ((Vector) gameObject).draw(g2d);

            } else if (gameObject instanceof LineSegment) {

                ArrayList<Vector> pointsArray = ((LineSegment) gameObject).returnPointsArray();
                for (Vector p : pointsArray) {
                    p.draw(g2d);
                }

            } else if (gameObject instanceof Polygon) {

                ArrayList<Vector> pointsArray = ((Polygon) gameObject).returnPointsArray();
                for (Vector p : pointsArray) {
                    p.draw(g2d);
                }

            }

        }

    }

}
