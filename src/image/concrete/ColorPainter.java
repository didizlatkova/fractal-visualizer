package image.concrete;

import parameters.concrete.Size;
import image.abstracts.Painter;

public class ColorPainter extends Painter {

	public ColorPainter(Size imageSize) {
		super(imageSize);
	}

	@Override
	public void paintPixel(int stepsToInfinity, int x, int y) {
		int color = 0;

		if (stepsToInfinity == 0) {
			color = 0x00ff00;
		} else if (stepsToInfinity <= 10) {
			color = 0xFFFFFF;
		} else if (stepsToInfinity == 11) {
			color = 0x0000ff;
		} else if (stepsToInfinity == 12) {
			color = 0x0000ee;
		} else if (stepsToInfinity == 13) {
			color = 0x0000dd;
		} else if (stepsToInfinity == 14) {
			color = 0x0000cc;
		} else if (stepsToInfinity == 15) {
			color = 0x0000bb;
		} else if (stepsToInfinity == 16) {
			color = 0x0000aa;
		} else if (stepsToInfinity == 17) {
			color = 0x000099;
		} else if (stepsToInfinity == 18) {
			color = 0x000088;
		} else if (stepsToInfinity == 19) {
			color = 0x000077;
		} else if (stepsToInfinity == 20) {
			color = 0x000066;
		} else if (20 < stepsToInfinity && stepsToInfinity <= 30) {
			color = 0x666600;
		} else if (30 < stepsToInfinity && stepsToInfinity <= 40) {
			color = 0x777700;
		} else if (40 < stepsToInfinity && stepsToInfinity <= 50) {
			color = 0x888800;
		} else if (50 < stepsToInfinity && stepsToInfinity <= 100) {
			color = 0x999900;
		} else if (100 < stepsToInfinity && stepsToInfinity <= 150) {
			color = 0xaaaa00;
		} else if (150 < stepsToInfinity && stepsToInfinity <= 150) {
			color = 0xbbbb00;
		} else if (200 < stepsToInfinity && stepsToInfinity <= 150) {
			color = 0xcccc00;
		} else if (350 < stepsToInfinity && stepsToInfinity <= 300) {
			color = 0xdddd00;
		} else {
			color = 0xeeee00;
		}

		this.getImage().setRGB(x, y, color);
	}

}
