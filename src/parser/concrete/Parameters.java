package parser.concrete;

import org.apache.commons.cli.CommandLine;

import parameters.concrete.*;

public class Parameters {
	
	private CommandLine commandLine;

	private Size size;
	
	private Rectangle complexField;
	
	private Tasks tasks;
	
	private WorkingMode workingMode;
	
	private GeneratedImage generatedImage;

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

	private void setComplexField() {
		String rectangleCoordinates = null;
		for (String optionName : Rectangle.parameterOptions.optionNames) {
			if (this.commandLine.hasOption(optionName)) {
				rectangleCoordinates = this.commandLine.getOptionValue(optionName);
				break;
			}
		}
		
		this.complexField = Rectangle.getRectangle(rectangleCoordinates);
	}

	public Tasks getTasks() {
		return tasks;
	}

	private void setTasks() {
		String maxString = null;
		for (String optionName : Tasks.parameterOptions.optionNames) {
			if (this.commandLine.hasOption(optionName)) {
				maxString = this.commandLine.getOptionValue(optionName);
				break;
			}
		}
		
		this.tasks = Tasks.getTasks(maxString);
	}

	public GeneratedImage getGeneratedImage() {
		return generatedImage;
	}

	private void setGeneratedImage() {
		String name = null;
		for (String optionName : GeneratedImage.parameterOptions.optionNames) {
			if (this.commandLine.hasOption(optionName)) {
				name = this.commandLine.getOptionValue(optionName);
				break;
			}
		}		
		
		this.generatedImage = GeneratedImage.getGeneratedImage(name);
	}

	public WorkingMode getWorkingMode() {
		return workingMode;
	}

	private void setWorkingMode() {
		boolean isQuiet = false;
		for (String optionName : WorkingMode.parameterOptions.optionNames) {
			if (this.commandLine.hasOption(optionName)) {
				isQuiet = true;
				break;
			}
		}	
		
		this.workingMode = new WorkingMode(isQuiet);
	}

	public Parameters(CommandLine commandLine) {
		this.commandLine = commandLine;
	}

	public void create() {
		this.setSize();
		this.setComplexField();
		this.setTasks();
		this.setGeneratedImage();
		this.setWorkingMode();
	}
	
}
