import javax.swing.*;

class Cube extends Figure3d {
    private double side;

    public Cube(double sideLength) {
        this.side = sideLength;
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        if (side > 0) {
            // Existing area calculation logic
            return 6 * Math.pow(side, 2);
        }
        else if (side<=0)
        {
            // If invalid information is provided
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    //Method to calculate volume
    @Override
    double calculateVolume() {
        if(side>0) {
            // Existing area calculation logic
            return Math.pow(side, 3);
        }
        else if (side<=0)
        {
            // If invalid information is provided
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        else {
            // If insufficient information is provided
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate volume.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}