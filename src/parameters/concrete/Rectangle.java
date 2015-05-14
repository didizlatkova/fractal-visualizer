package parameters.concrete;

import parameters.common.*;

public class Rectangle {
	
	private static final Limit DEFAULT_A = new Limit(-2, 2);
	private static final Limit DEFAULT_B = new Limit(-2, 2);
	private static final String INVALID_RECTANGLE_ERROR_MESSAGE = "The rectangle parameter is invalid.";

	public static ParameterOption parameterOptions;

	private Limit a;
	
	private Limit b;

	public Limit getA() {
		return a;
	}

	private void setA(Limit a) {
		this.a = a;
	}

	public Limit getB() {
		return b;
	}

	private void setB(Limit b) {
		this.b = b;
	}
	
	static {
		Rectangle.parameterOptions = new ParameterOption(
				new String[] { "r", "rect" }, true,
				"rectangle part of the complex field");
	}
	
	private Rectangle(Limit a, Limit b) {
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
				double aX = Double.parseDouble(rectangleCoordinatesArray[0]);
				double aY = Double.parseDouble(rectangleCoordinatesArray[1]);
				double bX = Double.parseDouble(rectangleCoordinatesArray[2]);
				double bY = Double.parseDouble(rectangleCoordinatesArray[3]);

				return new Rectangle(new Limit(aX, aY), new Limit(bX, bY));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(
						Rectangle.INVALID_RECTANGLE_ERROR_MESSAGE);
			}
		} else {
			throw new IllegalArgumentException(Rectangle.INVALID_RECTANGLE_ERROR_MESSAGE);
		}
	}
	
}
