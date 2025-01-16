import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeometryApp extends JFrame implements ActionListener {
    private final JComboBox<String> figureComboBox;
    private final JPanel paramsPanel;
    private JTextField[] paramFields;
    private final JLabel resultLabel;
    private final JTextArea historyTextArea;
    private final JLabel imageLabel;
    private static final String[] FIGURES = {"Circle", "Cone", "Cube", "Cylinder", "Parallelepiped", "Parallelogram", "Polygon", "Pyramid", "Quadrilateral", "Rectangle", "Rhombus", "Sphere", "Square", "Trapezoid", "Triangle"};

    public GeometryApp() {
        setTitle("Geometry Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        figureComboBox = new JComboBox<>(FIGURES);
        figureComboBox.setFont(new Font("Arial", Font.BOLD, 18));
        figureComboBox.setPreferredSize(new Dimension(350, 40));
        figureComboBox.addActionListener(this);

        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        comboPanel.add(figureComboBox);

        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane historyScrollPane = new JScrollPane(historyTextArea);
        historyScrollPane.setPreferredSize(new Dimension(getWidth(), 200));

        paramsPanel = new JPanel();
        paramsPanel.setLayout(new GridLayout(0, 2));

        resultLabel = new JLabel("Enter Circle parameters and click Calculate");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 34));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateImage("circle.png");
        updateImage("cone.png");
        updateImage("cubic.png");
        updateImage("cylinder.png");
        updateImage("parallelepiped.png");
        updateImage("parallelogram.png");
        updateImage("polygon.png");
        updateImage("quadrilateral.png");
        updateImage("rectangle.png");
        updateImage("rhombus.png");
        updateImage("sphere.png");
        updateImage("square.png");
        updateImage("trapezoid.png");
        updateImage("triangle.png");

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(historyScrollPane, BorderLayout.NORTH);
        contentPanel.add(paramsPanel, BorderLayout.CENTER);

        add(comboPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
        add(imageLabel, BorderLayout.EAST);

        loadHistory();
        addParamFields("Radius:");

        setVisible(true);
    }

    private void loadHistory() {
        try {
            String content = Files.readString(Paths.get("history.txt"));
            historyTextArea.setText(content);
            historyTextArea.setCaretPosition(historyTextArea.getDocument().getLength());
        } catch (IOException e) {
            historyTextArea.setText("No history available");
        }
    }

    private void saveToHistory(String calculation) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String historyEntry = timestamp + " - " + calculation + System.lineSeparator();
            Files.write(Paths.get("history.txt"), historyEntry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            loadHistory();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to history: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paramsPanel.removeAll();
        String figure = (String) figureComboBox.getSelectedItem();

        String labelText = String.format("Enter %s parameters and click Calculate", figure);
        resultLabel.setText(labelText);

        switch (figure) {
            case "Circle":
                updateImage("circle.png");
                addParamFields("Radius:");
                break;
            case "Cone":
                updateImage("cone.png");
                addParamFields("Radius:", "Height:");
                break;
            case "Cube":
                updateImage("cubic.png");
                addParamFields("Side:");
                break;
            case "Cylinder":
                updateImage("cylinder.png");
                addParamFields("Radius:", "Height:");
                break;
            case "Parallelepiped":
                updateImage("parallelepiped.png");
                addParamFields("Length:", "Width:", "Height:");
                break;
            case "Parallelogram":
                updateImage("parallelogram.png");
                addParamFields("Side 1:", "Side 2:", "Height 1:", "Height 2:", "Angle 1:", "Angle 2:", "Diagonal 1:", "Diagonal 2:");
                break;
            case "Polygon":
                updateImage("polygon.png");
                addParamFields("Number of Sides:", "Side Length:");
                break;
            case "Pyramid":
                updateImage("pyramid.png");
                addParamFields("Number of sides(3 or 4):", "Side:", "Height:");
                break;
            case "Quadrilateral":
                updateImage("quadrilateral.png");
                addParamFields("Side 1:", "Side 2:", "Side 3:", "Side 4:", "Angle 1:", "Angle 2:");
                break;
            case "Rectangle":
                updateImage("rectangle.png");
                addParamFields("Length:", "Width:");
                break;
            case "Rhombus":
                updateImage("rhombus.png");
                addParamFields("Side:", "Height:", "Angle 1:", "Angle 2:", "Diagonal 1:", "Diagonal 2:");
                break;
            case "Sphere":
                updateImage("sphere.png");
                addParamFields("Radius:");
                break;
            case "Square":
                updateImage("square.png");
                addParamFields("Side:", "Diagonal:");
                break;
            case "Trapezoid":
                updateImage("trapezoid.png");
                addParamFields("Base 1:", "Base 2:", "Height:");
                break;
            case "Triangle":
                updateImage("triangle.png");
                addParamFields("Side А:", "Side B:", "Side C:", "Angle A:", "Angle B:", "Angle C:");
                break;
            default:
                imageLabel.setIcon(null);
                addParamFields();
                break;
        }
        paramsPanel.revalidate();
        paramsPanel.repaint();
    }

    private void updateImage(String imageName) {
        try {
            URL imageUrl = getClass().getResource("/images/" + imageName);
            if (imageUrl != null) {
                ImageIcon icon = new ImageIcon(imageUrl);
                imageLabel.setIcon(icon);
            }else {
                throw new Exception("Image not found");
            }
        } catch (Exception ex) {
            imageLabel.setIcon(null);
            JOptionPane.showMessageDialog(this, "Image not found: " + imageName, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addParamFields(String... labels) {
        paramFields = new JTextField[labels.length];
        for (String label : labels) {
            JLabel fieldLabel = new JLabel(label);
            fieldLabel.setFont(new Font("Arial", Font.BOLD, 20));
            paramsPanel.add(fieldLabel);

            JTextField field = new JTextField();
            field.setFont(new Font("Arial", Font.BOLD, 20));
            field.setPreferredSize(new Dimension(200, 35));
            paramsPanel.add(field);
            paramFields[paramsPanel.getComponentCount() / 2 - 1] = field;
        }

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 20));
        calculateButton.setPreferredSize(new Dimension(150, 40));
        calculateButton.addActionListener(e -> calculate());
        paramsPanel.add(calculateButton);
    }

    private void calculate() {
        String figure = (String) figureComboBox.getSelectedItem();
        try {
            switch (figure) {
                case "Circle":
                    calculateCircle();
                    break;
                case "Cone":
                    calculateCone();
                    break;
                case "Cube":
                    calculateCube();
                    break;
                case "Cylinder":
                    calculateCylinder();
                    break;
                case "Parallelepiped":
                    calculateParallelepiped();
                    break;
                case "Parallelogram":
                    calculateParallelogram();
                    break;
                case "Polygon":
                    calculatePolygon();
                    break;
                case "Pyramid":
                    calculatePyramid();
                    break;
                case "Quadrilateral":
                    calculateQuadrilateral();
                    break;
                case "Rectangle":
                    calculateRectangle();
                    break;
                case "Rhombus":
                    calculateRhombus();
                    break;
                case "Sphere":
                    calculateSphere();
                    break;
                case "Square":
                    calculateSquare();
                    break;
                case "Trapezoid":
                    calculateTrapezoid();
                    break;
                case "Triangle":
                    calculateTriangle();
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateCircle() {
        double radius = getFieldValue(0);
        Circle circle = new Circle(radius);
        showResults2D(circle.calculateArea(), circle.calculatePerimeter());
        String result = String.format("Circle - Radius: %.2f, Area: %.2f, Perimeter: %.2f", radius, circle.calculateArea(), circle.calculatePerimeter());
        saveToHistory(result);
    }

    private void calculateCone() {
        double radius = getFieldValue(0);
        double height = getFieldValue(1);
        Cone cone = new Cone(radius, height);
        showResults3D(cone.calculateArea(), cone.calculateVolume());
        String result = String.format("Cone - Radius: %.2f, Height: %.2f, Surface Area: %.2f, Volume: %.2f", radius, height, cone.calculateArea(), cone.calculateVolume());
        saveToHistory(result);
    }

    private void calculateCube() {
        double side = getFieldValue(0);
        Parallelepiped cube = new Parallelepiped(side, side, side);
        showResults3D(cube.calculateArea(), cube.calculateVolume());
        String result = String.format("Cube - Side: %.2f, Surface Area: %.2f, Volume: %.2f", side, cube.calculateArea(), cube.calculateVolume());
        saveToHistory(result);
    }

    private void calculateCylinder() {
        double radius = getFieldValue(0);
        double height = getFieldValue(1);
        Cylinder cylinder = new Cylinder(radius, height);
        showResults3D(cylinder.calculateVolume(), cylinder.calculateArea());
        String result = String.format("Cylinder - Radius: %.2f, Height: %.2f, Surface Area: %.2f, Volume: %.2f", radius, height, cylinder.calculateArea(), cylinder.calculateVolume());
        saveToHistory(result);
    }

    private void calculateParallelepiped() {
        double length = getFieldValue(0);
        double width = getFieldValue(1);
        double height = getFieldValue(2);
        Parallelepiped parallelepiped = new Parallelepiped(length, width, height);
        showResults3D(parallelepiped.calculateArea(), parallelepiped.calculateVolume());
        String result = String.format("Parallelepiped - Length: %.2f, Width: %.2f, Height: %.2f, Surface Area: %.2f, Volume: %.2f", length, width, height, parallelepiped.calculateArea(), parallelepiped.calculateVolume());
        saveToHistory(result);
    }

    private void calculateParallelogram() {
        double side1 = getFieldValue(0);
        double side2 = getFieldValue(1);
        double height1 = getFieldValue(2);
        double height2 = getFieldValue(3);
        double angle1 = getFieldValue(4);
        double angle2 = getFieldValue(5);
        double diagonal1 = getFieldValue(6);
        double diagonal2 = getFieldValue(7);
        Parallelogram parallelogram = new Parallelogram(side1, side2, height1, height2, angle1, angle2, diagonal1, diagonal2);
        showResults2D(parallelogram.calculateArea(), parallelogram.calculatePerimeter());
        String result = String.format("Parallelogram - Sides: %.2f, %.2f, Heights: %.2f, %.2f, Angles: %.2f, %.2f, Diagonals: %.2f, %.2f, Area: %.2f, Perimeter: %.2f", side1, side2, height1, height2, angle1, angle2, diagonal1, diagonal2, parallelogram.calculateArea(), parallelogram.calculatePerimeter());
        saveToHistory(result);
    }

    private void calculatePolygon() {
        double sides = getFieldValue(0);
        double length = getFieldValue(1);
        Polygon polygon = new Polygon(length, sides);
        showResults2D(polygon.calculateArea(), polygon.calculatePerimeter());
        String result = String.format("Polygon - Number of Sides: %.0f, Side Length: %.2f, Area: %.2f, Perimeter: %.2f", sides, length, polygon.calculateArea(), polygon.calculatePerimeter());
        saveToHistory(result);
    }

    private void calculatePyramid() {
        int numberOfSides = (int) getFieldValue(0);
        double side = getFieldValue(1);
        double height = getFieldValue(2);
        Pyramid pyramid = new Pyramid(side, height, numberOfSides);
        showResults3D(pyramid.calculateArea(), pyramid.calculateVolume());
        String result = String.format("Pyramid - Number of Sides: %d, Side Length: %.2f, Height: %.2f, Surface Area: %.2f, Volume: %.2f", numberOfSides, side, height, pyramid.calculateArea(), pyramid.calculateVolume());
        saveToHistory(result);
    }

    private void calculateQuadrilateral() {
        double side1 = getFieldValue(0);
        double side2 = getFieldValue(1);
        double side3 = getFieldValue(2);
        double side4 = getFieldValue(3);
        double angle1 = getFieldValue(4);
        double angle2 = getFieldValue(5);
        Quadrilateral quadrilateral = new Quadrilateral(side1, side2, side3, side4, angle1, angle2);
        showResults2D(quadrilateral.calculateArea(), quadrilateral.calculatePerimeter());
        String result = String.format("Quadrilateral - Sides: %.2f, %.2f, %.2f, %.2f, Angles: %.2f, %.2f, Area: %.2f, Perimeter: %.2f", side1, side2, side3, side4, angle1, angle2, quadrilateral.calculateArea(), quadrilateral.calculatePerimeter());
        saveToHistory(result);
    }

    private void calculateRectangle() {
        double length = getFieldValue(0);
        double width = getFieldValue(1);
        double diagonal = Math.sqrt(length * length + width * width);
        Parallelogram rectangle = new Parallelogram(length, width, width, length, 90, 90, diagonal, diagonal);
        showResults2D(rectangle.calculateArea(), rectangle.calculatePerimeter());
        String result = String.format("Rectangle - Length: %.2f, Width: %.2f, Area: %.2f, Perimeter: %.2f", length, width, rectangle.calculateArea(), rectangle.calculatePerimeter());
        saveToHistory(result);
    }

    private void calculateRhombus() {
        double side1 = getFieldValue(0);
        double height1 = getFieldValue(1);
        double angle1 = getFieldValue(2);
        double angle2 = getFieldValue(3);
        double diagonal1 = getFieldValue(4);
        double diagonal2 = getFieldValue(5);
        Parallelogram rhombus = new Parallelogram(side1, side1, height1, height1, angle1, angle2, diagonal1, diagonal2);
        showResults2D(rhombus.calculateArea(), rhombus.calculatePerimeter());
        String result = String.format("Rhombus - Side: %.2f, Height: %.2f, Angles: %.2f, %.2f, Diagonals: %.2f, %.2f, Area: %.2f, Perimeter: %.2f", side1, height1, angle1, angle2, diagonal1, diagonal2, rhombus.calculateArea(), rhombus.calculatePerimeter());
        saveToHistory(result);
    }

    private void calculateSphere() {
        double radius = getFieldValue(0);
        Sphere sphere = new Sphere(radius);
        showResults3D(sphere.calculateArea(), sphere.calculateVolume());
        String result = String.format("Sphere - Radius: %.2f, Surface Area: %.2f, Volume: %.2f", radius, sphere.calculateArea(), sphere.calculateVolume());
        saveToHistory(result);
    }

    private void calculateSquare() {
        double side = getFieldValue(0);
        double diagonal = getFieldValue(1);
        Parallelogram square = new Parallelogram(side, side, side, side, 90, 90, diagonal, diagonal);
        showResults2D(square.calculateArea(), square.calculatePerimeter());
        String result = String.format("Square - Side: %.2f, Diagonal: %.2f, Area: %.2f, Perimeter: %.2f", side, diagonal, square.calculateArea(), square.calculatePerimeter());
        saveToHistory(result);
    }

    private void calculateTrapezoid() {
        double base1 = getFieldValue(0);
        double base2 = getFieldValue(1);
        double height = getFieldValue(2);
        Trapezoid trapezoid = new Trapezoid(base1, base2, height);
        showResults2D(trapezoid.calculateArea(), trapezoid.calculatePerimeter());
        String result = String.format("Trapezoid - Bases: %.2f, %.2f, Height: %.2f, Area: %.2f, Perimeter: %.2f", base1, base2, height, trapezoid.calculateArea(), trapezoid.calculatePerimeter());
        saveToHistory(result);
    }

    private void calculateTriangle() {
        double side1 = getFieldValue(0);
        double side2 = getFieldValue(1);
        double side3 = getFieldValue(2);
        double angle1 = getFieldValue(3);
        double angle2 = getFieldValue(4);
        double angle3 = getFieldValue(5);
        Triangle triangle = new Triangle(side1, side2, side3, angle1, angle2, angle3);
        showResults2D(triangle.calculateArea(), triangle.calculatePerimeter());
        String result = String.format("Triangle - Sides: %.2f, %.2f, %.2f, Angles: %.2f, %.2f, %.2f, Area: %.2f, Perimeter: %.2f", side1, side2, side3, angle1, angle2, angle3, triangle.calculateArea(), triangle.calculatePerimeter());
        saveToHistory(result);
    }

    private double getFieldValue(int index) {
        return paramFields[index].getText().trim().isEmpty() ? 0 : Double.parseDouble(paramFields[index].getText().trim());
    }

    private void showResults2D(double area, double perimeter) {
        resultLabel.setText(String.format("Area: %.2f   Perimeter: %.2f", area, perimeter));
    }

    private void showResults3D(double area, double volume) {
        resultLabel.setText(String.format("Surface Area: %.2f   Volume: %.2f", area, volume));
    }

    public static void main(String[] args) {
        new GeometryApp();
    }
}