package main.concrete;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import parser.concrete.Parameters;
import parser.concrete.Parser;

public class Main {

	public static void main(String[] args) throws ParseException {
		CommandLineParser commandLineParser = new DefaultParser();
		Parser parser = new Parser();
		parser.buildParameterOptions();
		CommandLine commandLine = commandLineParser.parse(parser.getOptions(), args);
		
		Parameters params = new Parameters(commandLine);
		try {
			params.create();			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println(params.getSize().getHeight());
		System.out.println(params.getSize().getWidth());
		
	}

}
