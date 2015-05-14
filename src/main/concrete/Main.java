package main.concrete;

import image.abstracts.Painter;
import image.concrete.BlackAndWhitePainter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.Options;

import parser.concrete.Parameters;
import parser.concrete.Parser;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		CommandLineParser commandLineParser = new DefaultParser();
		Parser parser = new Parser();
		
		parser.buildParameterOptions();
		Options options = parser.getOptions();
		CommandLine commandLine = commandLineParser.parse(options, args);		
		Parameters params = new Parameters(commandLine);
		
		try {
			params.create();			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println(params.getSize().getHeight());
		System.out.println(params.getSize().getWidth());
		System.out.println(params.getComplexField().getA().min);
		System.out.println(params.getComplexField().getA().max);
		
		Painter painter = new BlackAndWhitePainter(params.getSize());		
		Generator fractalGenerator = new Generator();
		
		fractalGenerator.generateFractal(painter, params.getSize(), params.getComplexField());
	}

}
