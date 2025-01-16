import javax.swing.*;

class Pyramid extends Figure3d {
    private final double side;
    private final double height;
    private int numberOfSides;

    public Pyramid(double side, double height, int numberOfSides) {
        if (side <= 0 || height <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Input Error", JOptionPane.ERROR_MESSAGE);
            this.side = 0;
            this.height = 0;
        } else {
            this.side = side;
            this.height = height;
            this.numberOfSides = numberOfSides;
        }
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        if (side > 0 && height > 0) {
            if (numberOfSides == 4) {
                // Square base pyramid area calculation
                double baseArea = side * side;
                double slantHeight = Math.sqrt(Math.pow(side / 2, 2) + Math.pow(height, 2));
                double lateralArea = 2 * side * slantHeight;
                return baseArea + lateralArea;
            } else if (numberOfSides == 3) {
                // Triangular base pyramid area calculation
                double slantHeight = Math.sqrt(Math.pow(side / 2, 2) + Math.pow(height, 2));
                double baseArea = (Math.sqrt(3) / 4) * Math.pow(side, 2); // Assuming an equilateral triangle
                double lateralArea = 3 * (0.5 * side * slantHeight);
                return baseArea + lateralArea;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid number of sides. Must be 3 (triangle) or 4 (square).", "Calculation Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        }
        return 0;
    }

    //Method to calculate volume
    @Override
    double calculateVolume() {
        if (side > 0 && height > 0) {
            if (numberOfSides == 4) {
                // Square base pyramid volume calculation
                return (1.0 / 3.0) * (side * side) * height;
            } else if (numberOfSides == 3) {
                // Triangular base pyramid volume calculation
                double baseArea = (Math.sqrt(3) / 4) * Math.pow(side, 2); // Assuming an equilateral triangle
                return (1.0 / 3.0) * baseArea * height;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid number of sides. Must be 3 (triangle) or 4 (square).", "Calculation Error", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        }
        return 0;
    }
}

