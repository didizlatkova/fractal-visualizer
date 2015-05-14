package parameters.concrete;

import parameters.common.ParameterOption;

public class Tasks {

	private static final int DEFAULT_MAX = 1;
	private static final String INVALID_TASKS_ERROR_MESSAGE = "The tasks parameter is invalid.";

	public static ParameterOption parameterOptions;

	private int max;

	public int getMax() {
		return max;
	}

	private void setMax(int max) {
		this.max = max;
	}

	static {
		Tasks.parameterOptions = new ParameterOption(new String[] { "t",
				"tasks" }, true, "maximum number of threads");
	}

	private Tasks(int max) {
		this.setMax(max);
	}

	public static Tasks getTasks(String maxString) {
		// expected format is 3
		if (maxString == null) {
			return new Tasks(Tasks.DEFAULT_MAX);
		}

		try {
			int max = Integer.parseInt(maxString);

			return new Tasks(max);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(
					Tasks.INVALID_TASKS_ERROR_MESSAGE);
		}

	}
	
}
