package parameters.concrete;

import parameters.common.ParameterOption;

public class Brush {

	public static ParameterOption parameterOptions;

	private boolean isColor;

	public boolean isColor() {
		return isColor;
	}

	private void setColor(boolean isColor) {
		this.isColor = isColor;
	}

	static {
		Brush.parameterOptions = new ParameterOption(new String[] { "c",
				"color" }, false, "generates colored image");
	}

	public Brush(boolean isColor) {
		this.setColor(isColor);
	}

}
