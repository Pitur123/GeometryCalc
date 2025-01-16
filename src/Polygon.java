import javax.swing.JOptionPane;

class Polygon extends Figure2d {
    private final double side;
    private final double numSides;

    public Polygon(double side, double numSides) {
        if (side <= 0 || numSides <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Input Error", JOptionPane.ERROR_MESSAGE);
            this.side = 0;
            this.numSides = 0;
        } else {
            this.side = side;
            this.numSides = numSides;
        }
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        if(side>0 && numSides>2) {
            return (numSides * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / numSides));
        }
        return 0;
    }

    //Method to calculate perimeter
    @Override
    double calculatePerimeter() {
        if(side>0 && numSides>2) {
            return numSides * side;
        }else{
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area and perimeter.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
