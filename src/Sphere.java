
class Sphere extends ThreeDimensionalFigure {
	private double radius;

	public Sphere(double radius) {
		this.radius = radius;
	}

	@Override
	double calculateArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	@Override
	double calculatePerimeter() {
		return 0;
	}

	@Override
	double calculateVolume() {
		return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	}
}