
class Cube extends ThreeDimensionalFigure {
	private double sideLength;

	public Cube(double sideLength) {
		this.sideLength = sideLength;
	}

	@Override
	double calculateArea() {
		return 6 * Math.pow(sideLength, 2);
	}

	@Override
	double calculatePerimeter() {
		return 12 * sideLength;
	}

	@Override
	double calculateVolume() {
		return Math.pow(sideLength, 3);
	}
}