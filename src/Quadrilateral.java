import javax.swing.*;

class  Quadrilateral extends Figure2d {
    private final double side1;
    private final double side2;
    private final double side3;
    private final double side4;
    private final double angle1;
    private final double angle2;

    public Quadrilateral(double side1, double side2, double side3, double side4, double angle1, double angle2) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || side4 <= 0 || angle1 > 180 || angle2 > 180) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Input Error", JOptionPane.ERROR_MESSAGE);
            this.side1 = 0;
            this.side2 = 0;
            this.side3 = 0;
            this.side4 = 0;
            this.angle1 = 0;
            this.angle2 = 0;
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.side4 = side4;
            this.angle1 = angle1;
            this.angle2 = angle2;
        }
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        if (side1 > 0 && side2 > 0 && side3 > 0 && side4 > 0 && angle1>0 && angle2>0) {
            double p = (1.0 / 2.0) * (side1 + side2 + side3 + side4);
            double alpha = Math.toRadians(angle1 + angle2);
            return Math.sqrt((p - side1) * (p - side2) * (p - side3) * (p - side4) - (side1 * side2 * side3 * side4 * (Math.pow(Math.cos(alpha / 2), 2))));
        } else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    //Method to calculate perimeter
    @Override
    double calculatePerimeter() {
        // Existing area calculation logic
        if (side1 > 0 && side2 > 0 && side3 > 0 && side4 > 0) {
            return side1 + side2 + side3 + side4;
        } else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate perimeter.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
