class Cylinder extends ThreeDimensionalFigure {
	private double radius, height;

	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	double calculateArea() {
		return 2 * Math.PI * radius * (radius + height);
	}

	@Override
	double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	double calculateVolume() {
		return Math.PI * Math.pow(radius, 2) * height;
	}
}