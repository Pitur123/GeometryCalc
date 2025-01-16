/*import javax.swing.JOptionPane;
import java.lang.Math;

class Triangle extends Figure2d {
    private double angle1, angle2, angle3, side1, side2, side3;

    public Triangle(double angle1, double angle2, double angle3, double side1, double side2, double side3) {
        this.angle1 = angle1;
        this.angle2 = angle2;
        this.angle3 = angle3;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //Method to calculate area
    @Override
    double calculateArea() {
        // If invalid information is provided
        if (side1 < 0 || side2 < 0 || side3 < 0 || angle1 < 0 || angle2 < 0 || angle3 < 0 || (angle1 + angle2 + angle3 > 180)) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        // Check if all three sides are provided (SSS)
        if (side1 > 0 && side2 > 0 && side3 > 0) {
            double p = (side1 + side2 + side3) / 2;
            return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

        }// Check if two sides and the included angle are provided (SAS)
        else if (side1 > 0 && side2 > 0 && angle3 > 0) {
            return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
        } else if (side1 > 0 && side3 > 0 && angle2 > 0) {
            return (1.0 / 2) * side1 * side3 * Math.sin(Math.toRadians(angle2));

        } else if (side2 > 0 && side3 > 0 && angle1 > 0) {
            return (1.0 / 2) * side2 * side3 * Math.sin(Math.toRadians(angle1));

        }// Check if two angles and the included side are provided
        else if (angle1 > 0 && angle2 > 0 && side3 > 0) {
            angle3 = 180 - angle1 - angle2;
            double side1 = (side3 * Math.sin(Math.toRadians(angle1))) / Math.sin(Math.toRadians(angle3));
            double side2 = (side3 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle3));
            return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
        } else if (angle1 > 0 && angle3 > 0 && side2 > 0) {
            angle2 = 180 - angle1 - angle3;
            double side1 = (side2 * Math.sin(Math.toRadians(angle1))) / Math.sin(Math.toRadians(angle2));
            double side3 = (side2 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle2));
            return (1.0 / 2) * side1 * side3 * Math.sin(Math.toRadians(angle2));
        } else if (angle2 > 0 && angle3 > 0 && side1 > 0) {
            angle1 = 180 - angle2 - angle3;
            double side2 = (side1 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle1));
            double side3 = (side1 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle1));
            return (1.0 / 2) * side2 * side3 * Math.sin(Math.toRadians(angle1));
        }
        // Check if two angles and a non-included side are provided
        else if (angle1 > 0 && angle2 > 0 && side1 > 0) {
            angle3 = 180 - angle1 - angle2;
            double side2 = (side1 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle1));
            double side3 = (side1 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle1));
            return (1.0 / 2) * side3 * side2 * Math.sin(Math.toRadians(angle1));
        } else if (angle1 > 0 && angle3 > 0 && side1 > 0) {
            angle2 = 180 - angle1 - angle2;
            double side2 = (side1 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle1));
            double side3 = (side1 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle1));
            return (1.0 / 2) * side3 * side2 * Math.sin(Math.toRadians(angle1));
        } else if (angle1 > 0 && angle3 > 0 && side3 > 0) {
            angle2 = 180 - angle1 - angle2;
            double side2 = (side3 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle3));
            double side1 = (side3 * Math.sin(Math.toRadians(angle1))) / Math.sin(Math.toRadians(angle3));
            return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
        }


        else if (angle1 > 0 && angle2 > 0 && side2>0) {
            angle2 = 180 - angle1 - angle2;
            double side3 = (side2 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle2));
            double side1 = (side2 * Math.sin(Math.toRadians(angle1))) / Math.sin(Math.toRadians(angle2));
            return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
        }
        else if (angle3 > 0 && angle2 > 0 && side2 > 0) {
            angle1 = 180 - angle1 - angle3;
            double side3 = (side2 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle2));
            double side1 = (side2 * Math.sin(Math.toRadians(angle1))) / Math.sin(Math.toRadians(angle2));
            return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
        }
        else if (angle3 > 0 && angle2 > 0 && side3 > 0) {
            angle1 = 180 - angle2 - angle2;
            double side2 = (side3 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle3));
            double side1 = (side3 * Math.sin(Math.toRadians(angle1))) / Math.sin(Math.toRadians(angle3));
            return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
        }

        // Check if two sides and one angle are provided (ASS)
        else if (side1 > 0 && side3 > 0 && angle1 > 0) {
            if (side1 < side3) {
                angle3 = 180 - angle1 - angle2;
                double side2 = (side1 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle1));
                double side3 = (side1 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle1));
                return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
            } else if (angle1 >= 90 && (side1 > side3)) {
                angle3 = (side3 * Math.sin(Math.toRadians(angle1))) / side1;
                angle2 = 180 - angle1 - angle3;
                double side2 = (side1 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle1));
                return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
            } else if (angle1 < 90 && side1 >= side3) {
                angle3 = (side3 * Math.sin(Math.toRadians(angle1))) / side1;
                angle2 = 180 - angle1 - angle3;
                double side2 = (side1 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle1));
                return (1.0 / 2) * side1 * side2 * Math.sin(Math.toRadians(angle3));
            }
        }

        // If insufficient information is provided
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return 0;
    }



    @Override
    double calculatePerimeter() {
        if (side1 < 0 || side2 < 0 || side3 < 0 || angle1 < 0 || angle2 < 0 || angle3 < 0 || (angle1 + angle2 + angle3 > 180)) {
            JOptionPane.showMessageDialog(null, "Invalid input.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
            // Check if all three sides are provided (SSS)
        }else if (side1 > 0 && side2 > 0 && side3 > 0) {
            return side1 + side2 + side3;
        }
        // Check if two sides and the included angle are provided (SAS)
        else if (side1 > 0 && side2 > 0 && angle3 > 0) {
            double side3 = Math.sqrt(side1 * side1 + side2 * side2 - 2 * side1 * side2 * Math.cos(Math.toRadians(angle3)));
            return side1 + side2 + side3;
        }
        // Check if two angles and the included side are provided (ASA)
        else if (angle1 > 0 && angle2 > 0 && side3 > 0) {
            angle3 = 180 - angle1 - angle2;
            double side1 = (side3 * Math.sin(Math.toRadians(angle1))) / Math.sin(Math.toRadians(angle3));
            double side2 = (side3 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle3));
            return side1 + side2 + side3;
        }
        // Check if two angles and a non-included side are provided (AAS)
        else if (angle1 > 0 && angle2 > 0 && side1 > 0) {
            angle3 = 180 - angle1 - angle2;
            double side2 = (side1 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle1));
            double side3 = (side1 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle1));
            return side1 + side2 + side3;
        }
        // Check if one side and two angles are provided (SSA)
        else if (side1 > 0 && angle1 > 0 && angle2 > 0) {
            angle3 = 180 - angle1 - angle2;
            double side2 = (side1 * Math.sin(Math.toRadians(angle2))) / Math.sin(Math.toRadians(angle1));
            double side3 = (side1 * Math.sin(Math.toRadians(angle3))) / Math.sin(Math.toRadians(angle1));
            return side1 + side2 + side3;
        }
        // If insufficient information is provided
        else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate perimeter.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}

*/

import javax.swing.JOptionPane;
        import java.lang.Math;

class Triangle extends Figure2d {
    private  double angle1, angle2, angle3, side1, side2, side3;

    public Triangle(double side1, double side2, double side3, double angle1, double angle2, double angle3) {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
        setAngle1(angle1);
        setAngle2(angle2);
        setAngle3(angle3);
    }

    public void setAngle1(double angle1) {
        if(angle1>0)
            this.angle1 = angle1;
    }

    public void setAngle2(double angle2) {
        if(angle2>0)
        this.angle2 = angle2;
    }

    public void setAngle3(double angle3) {
        if(angle3>0)
        this.angle3 = angle3;
    }

    public void setSide1(double side1) {
        if(side1>0)
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        if(side2>0)
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        if(side3>0)
        this.side3 = side3;
    }

    // Method to calculate area
    @Override
    double calculateArea() {

        // Check if all three sides are provided (SSS)
        if (side1 > 0 && side2 > 0 && side3 > 0) {
            double p = (side1 + side2 + side3) / 2;
            return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        }

        // Check if two sides and the included angle are provided (SAS)
        if (side1 > 0 && side2 > 0 && angle3 > 0) {
            return 0.5 * side1 * side2 * Math.sin(Math.toRadians(angle3));
        } else if (side1 > 0 && side3 > 0 && angle2 > 0) {
            return 0.5 * side1 * side3 * Math.sin(Math.toRadians(angle2));
        } else if (side2 > 0 && side3 > 0 && angle1 > 0) {
            return 0.5 * side2 * side3 * Math.sin(Math.toRadians(angle1));
        }

        JOptionPane.showMessageDialog(null, "Insufficient information to calculate area.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
        return 0;
    }

    @Override
    double calculatePerimeter() {
        // Check if all three sides are provided (SSS)
        if (side1 > 0 && side2 > 0 && side3 > 0) {
            return side1 + side2 + side3;
        }

        // Check if two sides and the included angle are provided (SAS)
        if (side1 > 0 && side2 > 0 && angle3 > 0) {
            double side3 = Math.sqrt(side1 * side1 + side2 * side2 - 2 * side1 * side2 * Math.cos(Math.toRadians(angle3)));
            return side1 + side2 + side3;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient information to calculate perimeter.", "Calculation Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
