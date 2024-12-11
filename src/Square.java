
import java.lang.Math;

class Square extends TwoDimensionalFigure {
	private double sideLength;

	public Square(double sideLength) {
		this.sideLength = sideLength;
	}

	@Override
	double calculateArea() {
		return Math.pow(sideLength, 2);
	}

	@Override
	double calculatePerimeter() {
		return 4 * sideLength;
	}
}
