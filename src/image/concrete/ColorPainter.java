package image.concrete;

import java.awt.image.BufferedImage;

import parameters.concrete.Size;
import image.abstracts.Painter;

public class ColorPainter extends Painter {

	public ColorPainter(Size size) {
		super(size);
	}

	@Override
	public void paintPixel(int stepsToInfinity, BufferedImage image, int x,
			int y) {
		// TODO Auto-generated method stub
		
	}

}
