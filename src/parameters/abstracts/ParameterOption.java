package parameters.abstracts;

public class ParameterOption {

	public String optionNames[];
	
	public boolean requiresArgument;
	
	public String description; 
	
	public ParameterOption(String[] optionNames, boolean requiresArgument, String description){
		this.optionNames = optionNames;
		this.requiresArgument = requiresArgument;
		this.description = description;
	}
	
}
