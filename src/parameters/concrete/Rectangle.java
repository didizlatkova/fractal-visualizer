package parameters.concrete;

import parameters.common.*;

public class Rectangle {
	
	private static final Coordinate DEFAULT_A = new Coordinate(-2, 2);
	private static final Coordinate DEFAULT_B = new Coordinate(-2, 2);
	private static final String INVALID_RECTANGLE_ERROR_MESSAGE = "The rectangle parameter is invalid.";

	public static ParameterOption parameterOptions;

	private Coordinate a;
	
	private Coordinate b;

	public Coordinate getA() {
		return a;
	}

	public void setA(Coordinate a) {
		this.a = a;
	}

	public Coordinate getB() {
		return b;
	}

	public void setB(Coordinate b) {
		this.b = b;
	}
	
	static {
		Size.parameterOptions = new ParameterOption(
				new String[] { "r", "rect" }, true,
				"rectangle part of the complex field");
	}
	
	private Rectangle(Coordinate a, Coordinate b) {
		this.setA(a);
		this.setB(b);
	}
	
	public static Rectangle getRectangle(String rectangleCoordinates) {
		// expected format is ­2.0:2.0:­2.0:2.0
		if (rectangleCoordinates == null) {
			return new Rectangle(Rectangle.DEFAULT_A, Rectangle.DEFAULT_B);
		}

		String[] rectangleCoordinatesArray = rectangleCoordinates.split(":");
		if (rectangleCoordinatesArray.length == 4) {
			try {
				int aX = Integer.parseInt(rectangleCoordinatesArray[0]);
				int aY = Integer.parseInt(rectangleCoordinatesArray[1]);
				int bX = Integer.parseInt(rectangleCoordinatesArray[2]);
				int bY = Integer.parseInt(rectangleCoordinatesArray[3]);

				return new Rectangle(new Coordinate(aX, aY), new Coordinate(bX, bY));
			} catch (NumberFormatException e) {
				// size is invalid
				throw new IllegalArgumentException(
						Rectangle.INVALID_RECTANGLE_ERROR_MESSAGE);
			}
		} else {
			throw new IllegalArgumentException(Rectangle.INVALID_RECTANGLE_ERROR_MESSAGE);
		}
	}
	
}
