package image.concrete;

import java.awt.Color;

import parameters.concrete.Size;
import image.abstracts.Painter;

public class BlackAndWhitePainter extends Painter {

	public BlackAndWhitePainter(Size imageSize) {
		super(imageSize);
	}

	@Override
	public synchronized void paintPixel(int stepsToInfinity, int x, int y) {
		if (stepsToInfinity == 0) {
			// black
			this.getImage().setRGB(x, y, 0x000000);
			this.getFrameGraphics().setColor(Color.black);
			this.getFrameGraphics().drawLine(x, y, x, y);
		}
	}

}
