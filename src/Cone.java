class Cone extends ThreeDimensionalFigure {
	private double radius, height;

	public Cone(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	@Override
	double calculateArea() {
		double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
		return Math.PI * radius * (radius + slantHeight);
	}

	@Override
	double calculatePerimeter() {
		return 0;
	}

	@Override
	double calculateVolume() {
		return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
	}
}