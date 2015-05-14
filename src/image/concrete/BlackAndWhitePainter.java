package image.concrete;

import java.awt.image.BufferedImage;

import parameters.concrete.Size;
import image.abstracts.Painter;

public class BlackAndWhitePainter extends Painter {

	public BlackAndWhitePainter(Size size) {
		super(size);
	}

	@Override
	public void paintPixel(int stepsToInfinity, BufferedImage image, int x,
			int y) {
		int color = 0;
		
		if (stepsToInfinity == 0) {
			// black
			color = 0x000000;
		} else {
			// white
			color = 0xffffff;
		}

		image.setRGB(x, y, color);
	}

}
