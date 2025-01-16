import javax.swing.*;

class Parallelepiped extends Figure3d {
    private double length, width, height;

    public Parallelepiped(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            this.length = 0;
            this.width = 0;
            this.height = 0;
        } else {
            this.length = length;
            this.width = width;
            this.height = height;
        }
    }

    @Override
    double calculateArea() {
        if (length > 0 && width > 0 && height > 0) {
            // Existing area calculation logic
            return 2 * (length * width + length * height + width * height);
        }
        return 0;
    }

    @Override
    double calculateVolume() {
        if(length>0 && width>0 && height>0) {
            return length * width * height;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area and volume.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}