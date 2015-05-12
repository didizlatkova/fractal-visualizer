package parser.concrete;

import java.util.ArrayList;
import java.util.List;

import parameters.abstracts.*;
import parameters.concrete.Size;

import org.apache.commons.cli.Options;

public class Parser {
	
	private List<ParameterOption> parameterOptions;

	public Parser() {
		this.parameterOptions = new ArrayList<ParameterOption>();
	}

	public void buildParameterOptions() {
		parameterOptions.add(Size.parameterOptions);
	}

	public Options parse() {
		Options options = new Options();

		for (ParameterOption parameterOption : parameterOptions) {
			for (String optionName : parameterOption.optionNames) {
				options.addOption(optionName, parameterOption.requiresArgument,
						parameterOption.description);
			}
		}

		return options;
	}
	
}
