package parameters.concrete;

import parameters.common.ParameterOption;

public class WorkingMode {

	public static ParameterOption parameterOptions;
	
	private boolean isQuiet;

	public boolean isQuiet() {
		return isQuiet;
	}

	private void setQuiet(boolean isQuiet) {
		this.isQuiet = isQuiet;
	}
			
	static {
		WorkingMode.parameterOptions = new ParameterOption(new String[] { "q",
				"quiet" }, false, "turns off log messages");
	}
	
	public WorkingMode(boolean isQuiet){
		this.setQuiet(isQuiet);
	}
	
}
