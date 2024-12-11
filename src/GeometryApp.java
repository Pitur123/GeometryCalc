import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeometryApp extends JFrame implements ActionListener {
	private JComboBox<String> figureComboBox;
	private JPanel paramsPanel;
	private JTextField[] paramFields;
	private JLabel resultLabel;

	public GeometryApp() {
		setTitle("Geometry Calculator");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		figureComboBox = new JComboBox<>(new String[] { "Circle", "Rectangle", "Triangle", "Square" });
		figureComboBox.addActionListener(this);

		paramsPanel = new JPanel();
		paramsPanel.setLayout(new GridLayout(0, 2));

		resultLabel = new JLabel("Results will be shown here");

		add(figureComboBox, BorderLayout.NORTH);
		add(paramsPanel, BorderLayout.CENTER);
		add(resultLabel, BorderLayout.SOUTH);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		paramsPanel.removeAll();
		String figure = (String) figureComboBox.getSelectedItem();

		if (figure.equals("Circle")) {
			addParamFields("Radius:");
		} else if (figure.equals("Rectangle")) {
			addParamFields("Length:", "Width:");
		} else if (figure.equals("Triangle")) {
			addParamFields("Base:", "Height:", "Side 1:", "Side 2:", "Side 3:");
		} else if (figure.equals("Square")) {
			addParamFields("Side Length:");
		}

		paramsPanel.revalidate();
		paramsPanel.repaint();
	}

	private void addParamFields(String... labels) {
		paramFields = new JTextField[labels.length];
		for (int i = 0; i < labels.length; i++) {
			paramsPanel.add(new JLabel(labels[i]));
			paramFields[i] = new JTextField();
			paramsPanel.add(paramFields[i]);
		}

		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(e -> calculate());
		paramsPanel.add(calculateButton);
	}

	private void calculate() {
		String figure = (String) figureComboBox.getSelectedItem();
		try {
			if (figure.equals("Circle")) {
				double radius = Double.parseDouble(paramFields[0].getText());
				Circle circle = new Circle(radius);
				showResults(circle.calculateArea(), circle.calculatePerimeter());
			} else if (figure.equals("Rectangle")) {
				double length = Double.parseDouble(paramFields[0].getText());
				double width = Double.parseDouble(paramFields[1].getText());
				Rectangle rectangle = new Rectangle(length, width);
				showResults(rectangle.calculateArea(), rectangle.calculatePerimeter());
			} else if (figure.equals("Triangle")) {
				double base = Double.parseDouble(paramFields[0].getText());
				double height = Double.parseDouble(paramFields[1].getText());
				double side1 = Double.parseDouble(paramFields[2].getText());
				double side2 = Double.parseDouble(paramFields[3].getText());
				double side3 = Double.parseDouble(paramFields[4].getText());
				Triangle triangle = new Triangle(base, height, side1, side2, side3);
				showResults(triangle.calculateArea(), triangle.calculatePerimeter());
			} else if (figure.equals("Square")) {
				double sideLength = Double.parseDouble(paramFields[0].getText());
				Square square = new Square(sideLength);
				showResults(square.calculateArea(), square.calculatePerimeter());
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Please enter valid numbers");
		}
	}

	private void showResults(double area, double perimeter) {
		resultLabel.setText(String.format("Area: %.2f, Perimeter: %.2f", area, perimeter));
	}

	public static void main(String[] args) {
		new GeometryApp();
	}
}
