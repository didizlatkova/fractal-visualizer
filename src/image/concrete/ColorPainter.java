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
			color = new Color(0, 255, 0);
		} else if (stepsToInfinity <= 10) {
			color = new Color(255, 255, 255);
		} else if (stepsToInfinity == 11) {
			color = new Color(0, 0, 255);
		} else if (stepsToInfinity == 12) {
			color = new Color(0, 0, 238);
		} else if (stepsToInfinity == 13) {
			color = new Color(0, 0, 221);
		} else if (stepsToInfinity == 14) {
			color = new Color(0, 0, 204);
		} else if (stepsToInfinity == 15) {
			color = new Color(0, 0, 187);
		} else if (stepsToInfinity == 16) {
			color = new Color(0, 0, 170);
		} else if (stepsToInfinity == 17) {
			color = new Color(0, 0, 153);
		} else if (stepsToInfinity == 18) {
			color = new Color(0, 0, 136);
		} else if (stepsToInfinity == 19) {
			color = new Color(0, 0, 119);
		} else if (stepsToInfinity == 20) {
			color = new Color(0, 0, 102);
		} else if (20 < stepsToInfinity && stepsToInfinity <= 30) {
			color = new Color(102, 102, 0);
		} else if (30 < stepsToInfinity && stepsToInfinity <= 40) {
			color = new Color(119, 119, 0);
		} else if (40 < stepsToInfinity && stepsToInfinity <= 50) {
			color = new Color(136, 136, 0);
		} else if (50 < stepsToInfinity && stepsToInfinity <= 100) {
			color = new Color(153, 153, 0);
		} else if (100 < stepsToInfinity && stepsToInfinity <= 150) {
			color = new Color(170, 170, 0);
		} else if (150 < stepsToInfinity && stepsToInfinity <= 200) {
			color = new Color(187, 187, 0);
		} else if (200 < stepsToInfinity && stepsToInfinity <= 250) {
			color = new Color(204, 204, 0);
		} else if (250 < stepsToInfinity && stepsToInfinity <= 300) {
			color = new Color(221, 221, 0);
		}

		this.getImage().setRGB(x, y, color.getRGB());
		this.getFrameGraphics().setColor(color);
		this.getFrameGraphics().drawLine(x, y, x, y);
	}
}
