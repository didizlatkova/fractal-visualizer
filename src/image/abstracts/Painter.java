package image.abstracts;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import parameters.concrete.Size;

public abstract class Painter {

	private BufferedImage image;

	private Graphics2D graphics;

	public abstract void paintPixel(int stepsToInfinity, BufferedImage image,
			int x, int y);

	public Painter(Size size) {
		this.image = new BufferedImage(size.getWidth(), size.getHeight(),
				BufferedImage.TYPE_3BYTE_BGR);
		this.graphics = this.image.createGraphics();
		this.graphics.setColor(Color.WHITE);
		this.graphics.fillRect(0, 0, size.getWidth(), size.getHeight());
	}

	public void createBorder(int width, int height) {
		this.graphics.setColor(Color.GRAY);
		this.graphics.drawRect(0, 0, width, height);
	}

	public void paintImage(String fileName, String fileType) {
		try {
			ImageIO.write(this.image, "PNG", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
