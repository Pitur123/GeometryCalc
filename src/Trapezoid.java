import javax.swing.*;

class Trapezoid extends Figure2d {
    private final double base1;
    private final double base2;
    private final double height;

    public Trapezoid(double base1, double base2, double height) {
        if (base1 <= 0 || base2 <= 0 || height <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Input Error", JOptionPane.ERROR_MESSAGE);
            this.base1 = 0;
            this.base2 = 0;
            this.height = 0;
        } else {
            this.base1 = base1;
            this.base2 = base2;
            this.height = height;
        }
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        // Existing area calculation logic
        if (base1 > 0 && base2 > 0 && height > 0) {
            return (1.0 / 2.0) * (base1 + base2) * height;
        }
        return 0;
    }

    //Method to calculate perimeter
    @Override
    double calculatePerimeter(){
        // Existing area calculation logic
        if (base1 > 0 && base2 > 0 && height > 0) {
            double part = (base1 - base2) * (1.0 / 2.0);
            double side = Math.sqrt(Math.pow(part, 2) + Math.pow(height, 2));
            return base1 + base2 + (2 * side);
        } else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area and perimeter.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
