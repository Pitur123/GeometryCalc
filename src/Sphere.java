import javax.swing.*;
import java.lang.Math;

class Sphere extends Figure3d {
    private final double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Input Error", JOptionPane.ERROR_MESSAGE);
            this.radius = 0;
        } else {
            this.radius = radius;
        }

    }

    @Override
    double calculateArea() {
        if (radius > 0) {
            return 4 * Math.PI * Math.pow(radius, 2);
        }
        return 0;
    }

    @Override
    double calculateVolume() {
        if (radius > 0) {
            return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area and volume.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}

