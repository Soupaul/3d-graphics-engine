import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

    private static final int WIDTH = 1080;
    private static final int HEIGHT = 720;
    private static Camera camera;

    public static void main(String[] args) throws Exception {

        camera = new Camera();

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("3D Graphics Engine");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Start time
        long start = System.nanoTime();

        // Adding Game Objects to Camera scene
        camera.gameObjects.add(new Vector(500, 500, Color.CYAN));
        camera.gameObjects.add(new Vector(540, 360, Color.CYAN));

        camera.gameObjects.add(new LineSegment(100, 200, 500, 600, Color.GREEN));

        ArrayList<Vector> triangle = new ArrayList<>();
        triangle.add(new Vector(700, 300));
        triangle.add(new Vector(850, 230));
        triangle.add(new Vector(630, 490));
        camera.gameObjects.add(new Polygon(triangle, Color.BLUE));

        ArrayList<Vector> quad = new ArrayList<>();
        quad.add(new Vector(100, 300));
        quad.add(new Vector(368, 244));
        quad.add(new Vector(562, 444));
        quad.add(new Vector(159, 677));
        camera.gameObjects.add(new Polygon(quad, Color.RED));

        camera.gameObjects.add(new Circle(new Vector(800, 300), 200, Color.YELLOW));

        // End time
        long end = System.nanoTime();
        // Elapsed time
        long elapsed = end - start;
        System.out.println("Time elapsed(in ns) = " + elapsed);

        frame.getContentPane().add(camera);
        frame.setVisible(true);

    }
}
