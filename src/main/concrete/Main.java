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
		long startTime = System.currentTimeMillis();
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

		Painter painter = null;
		if (params.getBrush().isColor()) {
			painter = new ColorPainter(params.getSize(), params.getDisplay()
					.isVisual());
		} else {
			painter = new BlackAndWhitePainter(params.getSize(), params
					.getDisplay().isVisual());
		}

		MessageLogger.setShouldLog(!params.getWorkingMode().isQuiet());
		Generator fractalGenerator = params.getGenerator();
		MandelbrotChecker checker = new MandelbrotChecker(new Formula16());

		fractalGenerator.generateFractal(painter, checker, params.getSize(),
				params.getComplexField(), params.getTasks().getMax());
		painter.paintBorder(params.getSize(), 2, 2);

		painter.paintImage(params.getGeneratedImage().getName(), "PNG");
		MessageLogger.getInstance().logAlways("Image painted!");
		long estimatedTime = System.currentTimeMillis() - startTime;
		MessageLogger.getInstance().logAlways(
				"Estimated time: " + estimatedTime);

	}

}
