import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Camera extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Rendering starts here
        renderScene(g2d);

    }

    public void renderScene(Graphics2D g2d) {

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.CYAN);
        new Vector(500, 500).draw(g2d);
        new Vector(540, 360).draw(g2d);

        g2d.setColor(Color.GREEN);
        new LineSegment(100, 200, 500, 600).draw(g2d);

        g2d.setColor(Color.RED);
        g2d.drawOval(600, 100, 400, 400);

    }

}
