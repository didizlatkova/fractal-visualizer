package parameters.concrete;

import parameters.common.*;

public class Size {
	
	private static final int DEFAULT_WIDTH = 640;
	private static final int DEFAULT_HEIGHT = 480;
	private static final String INVALID_SIZE_ERROR_MESSAGE = "The size parameter is invalid.";

	public static ParameterOption parameterOptions;

	private int width;

	private int height;

	public int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	static {
		Size.parameterOptions = new ParameterOption(
				new String[] { "s", "size" }, true,
				"size of the generated image");
	}

	private Size(int width, int height) {
		this.setWidth(width);
		this.setHeight(height);
	}

	public static Size getSize(String widthAndHeight) {
		// expected format is 640x480
		if (widthAndHeight == null) {
			return new Size(Size.DEFAULT_HEIGHT, Size.DEFAULT_WIDTH);
		}

		String[] widthAndHeightArray = widthAndHeight.split("x");
		if (widthAndHeightArray.length == 2) {
			try {
				int width = Integer.parseInt(widthAndHeightArray[0]);
				int height = Integer.parseInt(widthAndHeightArray[1]);

				return new Size(width, height);
			} catch (NumberFormatException e) {
				// size is invalid
				throw new IllegalArgumentException(
						Size.INVALID_SIZE_ERROR_MESSAGE);
			}
		} else {
			throw new IllegalArgumentException(Size.INVALID_SIZE_ERROR_MESSAGE);
		}
	}
	
}
