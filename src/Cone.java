import javax.swing.*;

class Cone extends Figure3d {
    private final double radius;
    private final double height;

    public Cone(double radius, double height) {
        if (radius <= 0 || height <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Input Error", JOptionPane.ERROR_MESSAGE);
            this.radius = 0;
            this.height = 0;
        } else {
            this.radius = radius;
            this.height = height;
        }
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        if (radius > 0 && height > 0) {
            double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
            return Math.PI * radius * (radius + slantHeight);
        }
        return 0;
    }

    //Method to calculate volume
    @Override
    double calculateVolume() {
        if(radius>0 && height>0) {
            return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
        } else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area and volume.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
