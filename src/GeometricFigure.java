
abstract class GeometricFigure {
	abstract double calculateArea();

	abstract double calculatePerimeter();
}

abstract class TwoDimensionalFigure extends GeometricFigure {
}

abstract class ThreeDimensionalFigure extends GeometricFigure {
	abstract double calculateVolume();
}