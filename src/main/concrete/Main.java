package main.concrete;

import logging.abstracts.Logger;
import logging.concrete.MessageLogger;
import math.concrete.*;
import generator.abstracts.Generator;
import generator.concrete.ColumnsGenerator;
import generator.concrete.RowsGenerator;
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

		Painter painter = new BlackAndWhitePainter(params.getSize());
		//Painter painter = new ColorPainter(params.getSize());

		Logger logger = new MessageLogger(!params.getWorkingMode().isQuiet());
		//Generator fractalGenerator = new RowsGenerator(logger);
		Generator fractalGenerator = new ColumnsGenerator(logger);
		MandelbrotChecker checker = new MandelbrotChecker(new Formula16());
		long startTime = System.currentTimeMillis();
		fractalGenerator.generateFractal(painter, checker, params.getSize(),
				params.getComplexField(), params.getTasks().getMax());
		long estimatedTime = System.currentTimeMillis() - startTime;
		painter.paintBorder(params.getSize(), 2, 2);

		painter.paintImage(params.getGeneratedImage().getName(), "PNG");
		logger.logAlways("Image painted!");
		logger.logAlways("Estimated time: " + estimatedTime);
	}

}
