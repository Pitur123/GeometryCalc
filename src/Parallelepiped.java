
class Parallelepiped extends ThreeDimensionalFigure {
	private double length, width, height;

	public Parallelepiped(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	@Override
	double calculateArea() {
		return 2 * (length * width + length * height + width * height);
	}

	@Override
	double calculatePerimeter() {
		return 4 * (length + width + height);
	}

	@Override
	double calculateVolume() {
		return length * width * height;
	}
}