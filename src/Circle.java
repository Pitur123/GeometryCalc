import java.lang.Math;

class Circle extends TwoDimensionalFigure {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}
}