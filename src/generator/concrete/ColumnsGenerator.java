package generator.concrete;

import math.concrete.MandelbrotChecker;
import parameters.concrete.*;
import generator.abstracts.FractalRunnable;
import generator.abstracts.Generator;
import image.abstracts.Painter;

public class ColumnsGenerator extends Generator {

	public void generateFractal(Painter painter, MandelbrotChecker checker,
			Size imageSize, Rectangle complexField, int maxThreads) {
		int workAmount = imageSize.getWidth() / maxThreads;
		int startColumn = 0;
		this.threadArray = new Thread[maxThreads];

		for (int i = 0; i < maxThreads; i++) {
			FractalRunnable runnable = new ColumnsFractalRunnable(painter,
					checker, imageSize, complexField, startColumn,
					(i != maxThreads - 1) ? startColumn + workAmount
							: imageSize.getWidth());
			Thread t = new Thread(runnable);
			threadArray[i] = t;
			t.start();

			startColumn += workAmount;
		}

		super.generateFractal(painter, checker, imageSize, complexField,
				maxThreads);
	}

}
