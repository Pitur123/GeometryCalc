
class Parallelogram extends TwoDimensionalFigure {
	private double base, height, side;

	public Parallelogram(double base, double height, double side) {
		this.base = base;
		this.height = height;
		this.side = side;
	}

	@Override
	double calculateArea() {
		return base * height;
	}

	@Override
	double calculatePerimeter() {
		return 2 * (base + side);
	}
}