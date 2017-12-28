package util;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Util {
	
	public static void saveImage(BufferedImage image, String name) {
		try {
			ImageIO.write(image, "png", new File("C:\\Users\\Simon\\git\\Test\\"+ name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void displayImage(BufferedImage image) {
        ImageIcon icon=new ImageIcon(image);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(200,300);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new IllegalStateException();
		}
	}
}
