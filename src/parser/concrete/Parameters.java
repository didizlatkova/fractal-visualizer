package parser.concrete;

import org.apache.commons.cli.CommandLine;

import parameters.concrete.*;

public class Parameters {
	
	private CommandLine commandLine;

	private Size size;
	
	private Rectangle complexField;

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

	public Rectangle getComplexField() {
		return complexField;
	}

	public void setComplexField() {
		String rectangleCoordinates = null;
		for (String optionName : Rectangle.parameterOptions.optionNames) {
			if (this.commandLine.hasOption(optionName)) {
				rectangleCoordinates = this.commandLine.getOptionValue(optionName);
				break;
			}
		}
		
		this.complexField = Rectangle.getRectangle(rectangleCoordinates);
	}

	public Parameters(CommandLine commandLine) {
		this.commandLine = commandLine;
	}

	public void create() {
		this.setSize();
		this.setComplexField();
	}
	
}
