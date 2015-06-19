package parameters.concrete;

import generator.abstracts.Generator;
import generator.concrete.ColumnsGenerator;
import generator.concrete.RowsGenerator;
import parameters.common.ParameterOption;

public class Generation {

	public static ParameterOption parameterOptions;

	private static final Generator DEFAULT_GENERATOR = new RowsGenerator();
	private static final String INVALID_DIRECTION_ERROR_MESSAGE = "The direction parameter is invalid.";

	static {
		Generation.parameterOptions = new ParameterOption(new String[] { "d",
				"direction" }, true, "direction of the generation");
	}

	public static Generator getGeneration(String direction) {
		if (direction == null) {
			return DEFAULT_GENERATOR;
		}

		switch (direction) {
		case "row":
			return new RowsGenerator();
		case "column":
			return new ColumnsGenerator();
		default:
			throw new IllegalArgumentException(INVALID_DIRECTION_ERROR_MESSAGE);
		}
	}

}
