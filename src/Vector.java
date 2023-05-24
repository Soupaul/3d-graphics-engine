// This class can be treated as a Point as well by assuming position vectors.
// Hence no separate implementation for Point has been done.

import java.awt.Graphics2D;
import java.awt.Color;

public class Vector {

    public int[] coords; // Faster access for arrays than normal integers
    public Color color; // Required when treating as a point

    // For 2D purposes
    public Vector(int x, int y) {

        coords = new int[3];
        coords[0] = x;
        coords[1] = y;
        coords[2] = 0;
        color = Color.WHITE;

    }

    public Vector(int x, int y, Color color) {

        coords = new int[3];
        coords[0] = x;
        coords[1] = y;
        coords[2] = 0;
        this.color = color;

    }

    public Vector(int x, int y, int z) {

        coords = new int[3];
        coords[0] = x;
        coords[1] = y;
        coords[2] = z;
        color = Color.WHITE;

    }

    public Vector(int x, int y, int z, Color color) {

        coords = new int[3];
        coords[0] = x;
        coords[1] = y;
        coords[2] = z;
        this.color = color;

    }

    public Vector(int[] arr) {

        coords = arr;
        color = Color.WHITE;

    }

    public Vector(int[] arr, Color color) {

        coords = arr;
        this.color = color;

    }

    public Vector(Vector v) {

        coords = new int[3];
        coords[0] = v.coords[0];
        coords[1] = v.coords[1];
        coords[2] = v.coords[2];
        color = v.color;

    }

    public Vector add(Vector v) {

        Vector res = new Vector(0, 0, 0);
        res.coords[0] = coords[0] + v.coords[0];
        res.coords[1] = coords[1] + v.coords[1];
        res.coords[2] = coords[2] + v.coords[2];

        return res;

    }

    public Vector subtract(Vector v) {

        Vector res = new Vector(0, 0, 0);
        res.coords[0] = coords[0] - v.coords[0];
        res.coords[1] = coords[1] - v.coords[1];
        res.coords[2] = coords[2] - v.coords[2];

        return res;

    }

    // Faster comparison than comparing magnitudes
    public int squaredMagnitude() {

        return coords[0] * coords[0] + coords[1] * coords[1] + coords[2] * coords[2];

    }

    public float magnitude() {

        return (float) Math.sqrt(squaredMagnitude());

    }

    public void normalize() {

        float mag = magnitude();
        coords[0] = Math.round(coords[0] / mag);
        coords[1] = Math.round(coords[1] / mag);
        coords[2] = Math.round(coords[2] / mag);

    }

    public int dotProduct(Vector v) {

        return coords[0] * v.coords[0] + coords[1] * v.coords[1] + coords[2] * v.coords[2];

    }

    public Vector crossProduct(Vector v) {

        Vector res = new Vector(0, 0, 0);
        res.coords[0] = coords[1] * v.coords[2] - coords[2] * v.coords[1];
        res.coords[1] = coords[2] * v.coords[0] - coords[0] * v.coords[2];
        res.coords[2] = coords[0] * v.coords[1] - coords[1] * v.coords[0];

        return res;

    }

    // Helper function to draw pixels. Note that this is not the most optimal way
    public void draw(Graphics2D g2d) {

        g2d.setColor(color);
        g2d.drawLine(coords[0], coords[1], coords[0], coords[1]);

    }

}
