package image.abstracts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import parameters.concrete.Size;

public abstract class Painter {

	private BufferedImage image;

	private Graphics2D graphics;

	private Graphics frameGraphics;

	protected boolean isVisual;

	public Graphics getFrameGraphics() {
		return frameGraphics;
	}

	public void setFrameGraphics(Graphics frameGraphics) {
		this.frameGraphics = frameGraphics;
	}

	public BufferedImage getImage() {
		return image;
	}

	private void setImage(BufferedImage image) {
		this.image = image;
	}

	public abstract void paintPixel(int stepsToInfinity, int x, int y);

	public Painter(Size imageSize, boolean isVisual) {
		this.setImage(new BufferedImage(imageSize.getWidth(), imageSize
				.getHeight(), BufferedImage.TYPE_3BYTE_BGR));
		this.graphics = this.getImage().createGraphics();
		this.graphics.setColor(Color.WHITE);
		this.graphics.fillRect(0, 0, imageSize.getWidth(),
				imageSize.getHeight());

		this.isVisual = isVisual;
		if (isVisual) {
			this.setupPanel(imageSize);
		}
	}

	private void setupPanel(Size imageSize) {
		JFrame application = new JFrame();
		final JPanel panel = new JPanel();
		panel.setSize(imageSize.getWidth(), imageSize.getHeight());
		panel.setBackground(Color.white);
		application.setSize(panel.getSize());
		application.setResizable(false);
		application.add(panel);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setVisible(true);
		this.setFrameGraphics(panel.getGraphics());
	}

	public void paintBorder(Size imageSize, int borderWidth, int borderHeight) {
		this.graphics.setColor(Color.GRAY);
		this.graphics.drawRect(0, 0, imageSize.getWidth() - borderWidth,
				imageSize.getHeight() - borderHeight);
	}

	public void paintImage(String fileName, String fileType) {
		try {
			ImageIO.write(this.getImage(), "PNG", new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
