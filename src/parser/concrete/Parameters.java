package parser.concrete;

import org.apache.commons.cli.CommandLine;

import parameters.concrete.*;

public class Parameters {
	
	private CommandLine commandLine;

	private Size size;

	public Size getSize() {
		return size;
	}

	private void setSize() {
		String widthAndHeight = null;
		for (String optionName : Size.parameterOptions.optionNames) {
			if (this.commandLine.hasOption(optionName)) {
				widthAndHeight = this.commandLine.getOptionValue(optionName);
				break;
			}
		}
		
		this.size = Size.getSize(widthAndHeight);
	}

	public Parameters(CommandLine commandLine) {
		this.commandLine = commandLine;
	}

	public void create() {
		this.setSize();
	}
	
}
