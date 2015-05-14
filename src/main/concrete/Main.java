package main.concrete;

import logging.abstracts.Logger;
import logging.concrete.MessageLogger;
import math.concrete.*;
import image.abstracts.Painter;
import image.concrete.*;

import org.apache.commons.cli.*;

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
		System.out.println(params.getComplexField().getB().min);
		System.out.println(params.getComplexField().getB().max);
		
		Painter painter = new BlackAndWhitePainter(params.getSize());
		//Painter painter = new ColorPainter(params.getSize());
		Logger logger = new MessageLogger(true);
		Generator fractalGenerator = new Generator(logger);
		MandelbrotChecker checker = new MandelbrotChecker(new FormulaExample());
		
		fractalGenerator.generateFractal(painter, checker, params.getSize(), params.getComplexField());
		painter.paintBorder(params.getSize(), 2, 2);
		
		painter.paintImage("test.png", "PNG");
		logger.log("Image painted!");
	}

}
