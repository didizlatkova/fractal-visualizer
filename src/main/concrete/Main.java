package main.concrete;

import logging.concrete.MessageLogger;
import math.concrete.*;
import generator.abstracts.Generator;
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

		Painter painter = new BlackAndWhitePainter(params.getSize(), params
				.getDisplay().isVisual());
		if (params.getBrush().isColor()) {
			painter = new ColorPainter(params.getSize(), params.getDisplay()
					.isVisual());
		}

		MessageLogger.setShouldLog(!params.getWorkingMode().isQuiet());
		Generator fractalGenerator = params.getGenerator();
		MandelbrotChecker checker = new MandelbrotChecker(new Formula16());
		long startTime = System.currentTimeMillis();
		fractalGenerator.generateFractal(painter, checker, params.getSize(),
				params.getComplexField(), params.getTasks().getMax());
		long estimatedTime = System.currentTimeMillis() - startTime;
		painter.paintBorder(params.getSize(), 2, 2);

		painter.paintImage(params.getGeneratedImage().getName(), "PNG");
		MessageLogger.getInstance().logAlways("Image painted!");
		MessageLogger.getInstance().logAlways(
				"Estimated time: " + estimatedTime);
	}

}
