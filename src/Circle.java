import javax.swing.*;
import java.lang.Math;

class Circle extends Figure2d {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Input Error", JOptionPane.ERROR_MESSAGE);
            this.radius = 0;
        } else {
            this.radius = radius;
        }
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        if (radius > 0)
            return Math.PI * Math.pow(radius, 2);
        return 0;
    }

    //Method to calculate perimeter
    @Override
    double calculatePerimeter() {
        if(radius>0) {
            return 2 * Math.PI * radius;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area and perimeter.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
