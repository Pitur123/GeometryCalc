
class Polygon extends TwoDimensionalFigure {
	private double sideLength, numSides;

	public Polygon(double sideLength, double numSides) {
		this.sideLength = sideLength;
		this.numSides = numSides;
	}

	@Override
	double calculateArea() {
		return (numSides * Math.pow(sideLength, 2)) / (4 * Math.tan(Math.PI / numSides));
	}

	@Override
	double calculatePerimeter() {
		return numSides * sideLength;
	}
}