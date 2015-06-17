package image.concrete;

import java.awt.Color;

import parameters.concrete.Size;
import image.abstracts.Painter;

public class BlackAndWhitePainter extends Painter {

	public BlackAndWhitePainter(Size imageSize) {
		super(imageSize);
	}

	@Override
	public synchronized void paintPixel(int stepsToInfinity, int x,
			int y) {
		int color = 0;
		
		if (stepsToInfinity == 0) {
			// black
			color = 0x000000;
		} else {
			// white
			color = 0xffffff;
		}

		this.getImage().setRGB(x, y, color);
		
		this.frameGraphics.setColor(new Color(color));
		this.frameGraphics.drawLine(x, y, x, y);
	}

}
