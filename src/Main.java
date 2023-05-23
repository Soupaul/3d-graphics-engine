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
        frame.getContentPane().add(camera);
        frame.setVisible(true);

    }
}
