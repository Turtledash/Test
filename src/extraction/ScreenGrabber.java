package extraction;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ScreenGrabber {
	
	public BufferedImage getScreen() {
		BufferedImage screenshot = getUncroppedScreen();
		return screenshot.getSubimage(300, 74, 1320, 910);
	}
	
	private BufferedImage getUncroppedScreen() {
		try {
			return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}
}
