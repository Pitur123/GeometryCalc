
class Pyramid extends ThreeDimensionalFigure {
	private double baseArea, height;

	public Pyramid(double baseArea, double height) {
		this.baseArea = baseArea;
		this.height = height;
	}

	@Override
	double calculateArea() {
		double side = Math.sqrt(baseArea);
		double slantHeight = Math.sqrt(Math.pow(side / 2, 2) + Math.pow(height, 2));
		return baseArea + 2 * side * slantHeight;
	}

	@Override
	double calculatePerimeter() {
		return 0;
	}

	@Override
	double calculateVolume() {
		return (1.0 / 3.0) * baseArea * height;
	}
}