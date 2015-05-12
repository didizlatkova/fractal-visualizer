package parser.concrete;

import org.apache.commons.cli.CommandLine;

import parameters.concrete.*;

public class Creator {
	
	private CommandLine commandLine;

	private Size size;

	public Size getSize() {
		return size;
	}

	private void setSize() {
		for (String optionName : Size.parameterOptions.optionNames) {
			if (this.commandLine.hasOption(optionName)) {
				String widthAndHeight = this.commandLine.getOptionValue(optionName);
				this.size = Size.getSize(widthAndHeight);
				break;
			}
		}
	}

	public Creator(CommandLine commandLine) {
		this.commandLine = commandLine;
	}

	public void createParameters() {
		this.setSize();
	}
	
}
