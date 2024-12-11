
class Prism extends ThreeDimensionalFigure {
	private double baseArea, height, perimeter;

	public Prism(double baseArea, double height, double perimeter) {
		this.baseArea = baseArea;
		this.height = height;
		this.perimeter = perimeter;
	}

	@Override
	double calculateArea() {
		return 2 * baseArea + perimeter * height;
	}

	@Override
	double calculatePerimeter() {
		return 0;
	}

	@Override
	double calculateVolume() {
		return baseArea * height;
	}
}