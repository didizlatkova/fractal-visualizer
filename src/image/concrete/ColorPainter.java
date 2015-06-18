package image.concrete;

import java.awt.Color;

import parameters.concrete.Size;
import image.abstracts.Painter;

public class ColorPainter extends Painter {

	public ColorPainter(Size imageSize) {
		super(imageSize);
	}

	@Override
	public synchronized void paintPixel(int stepsToInfinity, int x, int y) {
		Color color = null;

		if (stepsToInfinity > 300) {
			return;
		}

		if (stepsToInfinity == 0) {
			color = new Color(255, 204, 0);
		} else if (stepsToInfinity <= 10) {
			color = new Color(255, 255, 255);
		} else if (stepsToInfinity == 11) {
			color = new Color(63, 6, 116);
		} else if (stepsToInfinity == 12) {
			color = new Color(86, 24, 143);
		} else if (stepsToInfinity == 13) {
			color = new Color(103, 55, 148);
		} else if (stepsToInfinity == 14) {
			color = new Color(113, 67, 157);
		} else if (stepsToInfinity == 15) {
			color = new Color(136, 94, 175);
		} else if (stepsToInfinity == 16) {
			color = new Color(107, 81, 132);
		} else if (stepsToInfinity == 17) {
			color = new Color(158, 135, 180);
		} else if (stepsToInfinity == 18) {
			color = new Color(180, 135, 179);
		} else if (stepsToInfinity == 19) {
			color = new Color(136, 135, 180);
		} else if (stepsToInfinity == 20) {
			color = new Color(72, 71, 116);
		} else if (20 < stepsToInfinity && stepsToInfinity <= 30) {
			color = new Color(206, 140, 53);
		} else if (30 < stepsToInfinity && stepsToInfinity <= 40) {
			color = new Color(224, 175, 91);
		} else if (40 < stepsToInfinity && stepsToInfinity <= 50) {
			color = new Color(236, 189, 69);
		} else if (50 < stepsToInfinity && stepsToInfinity <= 100) {
			color = new Color(246, 208, 110);
		} else if (100 < stepsToInfinity && stepsToInfinity <= 150) {
			color = new Color(228, 214, 122);
		} else if (150 < stepsToInfinity && stepsToInfinity <= 200) {
			color = new Color(233, 212, 72);
		} else if (200 < stepsToInfinity && stepsToInfinity <= 250) {
			color = new Color(240, 213, 34);
		} else if (250 < stepsToInfinity && stepsToInfinity <= 300) {
			color = new Color(224, 181, 10);
		}

		this.getImage().setRGB(x, y, color.getRGB());
		this.getFrameGraphics().setColor(color);
		this.getFrameGraphics().drawLine(x, y, x, y);
	}
}
