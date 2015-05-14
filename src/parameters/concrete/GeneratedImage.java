package parameters.concrete;

import parameters.common.ParameterOption;

public class GeneratedImage {

	private static final String DEFAULT_NAME = "zad16.png";

	public static ParameterOption parameterOptions;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	static {
		GeneratedImage.parameterOptions = new ParameterOption(new String[] { "o",
				"output" }, true, "name of the generated image");
	}

	private GeneratedImage(String name) {
		this.setName(name);
	}
	
	public static GeneratedImage getGeneratedImage(String name) {
		if (name == null) {
			return new GeneratedImage(GeneratedImage.DEFAULT_NAME);
		}

		return new GeneratedImage(name);
	}
	
}
