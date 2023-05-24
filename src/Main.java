import java.awt.Color;

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

        // Adding Game Objects to Camera scene
        camera.gameObjects.add(new Vector(500, 500, Color.CYAN));
        camera.gameObjects.add(new Vector(540, 360, Color.CYAN));
        camera.gameObjects.add(new LineSegment(100, 200, 500, 600, Color.GREEN));

        frame.getContentPane().add(camera);
        frame.setVisible(true);

    }
}
