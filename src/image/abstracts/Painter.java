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

	public Painter(Size imageSize) {
		this.image = new BufferedImage(imageSize.getWidth(), imageSize.getHeight(),
				BufferedImage.TYPE_3BYTE_BGR);
		this.graphics = this.image.createGraphics();
		this.graphics.setColor(Color.WHITE);
		this.graphics.fillRect(0, 0, imageSize.getWidth(), imageSize.getHeight());
	}

	public void paintBorder(Size imageSize, int borderWidth, int borderHeight) {
		this.graphics.setColor(Color.GRAY);
		this.graphics.drawRect(0, 0, imageSize.getWidth() - borderWidth, imageSize.getHeight() - borderHeight);
	}

	public void paintImage(String fileName, String fileType) {
		try {
			ImageIO.write(this.image, "PNG", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
