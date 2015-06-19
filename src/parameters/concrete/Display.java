package parameters.concrete;

import parameters.common.ParameterOption;

public class Display {

	public static ParameterOption parameterOptions;

	private boolean isVisual;

	public boolean isVisual() {
		return isVisual;
	}

	private void setVisual(boolean isVisual) {
		this.isVisual = isVisual;
	}

	static {
		Display.parameterOptions = new ParameterOption(new String[] { "v",
				"visual" }, false, "displays visualization of the points");
	}

	public Display(boolean isVisual) {
		this.setVisual(isVisual);
	}

}
