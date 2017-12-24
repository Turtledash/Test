package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import extract.ScreenCropper;
import extract.ScreenGrabber;

public class Main {

	private static int handCounter;
	
	public static void main(String[] args) {
		saveHandsLoop();
	}
	
	private static void saveHandsLoop() {
		while (true) {
			BufferedImage screenshot = new ScreenGrabber().getScreen();
			ScreenCropper cropper = new ScreenCropper(screenshot);
			if (cropper.getTurnIndicatorPixel() == -10216162) {
				handCounter++;
				System.out.println("Saving Hand #" + handCounter);
				saveImage(screenshot, "hands/Hand" + handCounter);
				try {Thread.sleep(10000);} catch (InterruptedException e) {}
			}
		}
	}

	public static void saveScreenshot() {
		BufferedImage screenshot = new ScreenGrabber().getScreen();
		saveImage(screenshot, "Screenshot");
	}

	public static void loop() {
		while (true) {
			BufferedImage screenshot = new ScreenGrabber().getScreen();
			ScreenCropper cropper = new ScreenCropper(screenshot);
			System.out.println("Turnindicator: " + cropper.getTurnIndicatorPixel());
			if (cropper.getTurnIndicatorPixel() == -10216162) {
				System.out.println("Card1indicator: " + cropper.getCard1IndicatorPixel());
				System.out.println("Card2indicator: " + cropper.getCard2IndicatorPixel());
				System.out.println("Card3indicator: " + cropper.getCard3IndicatorPixel());
				System.out.println("Card4indicator: " + cropper.getCard4IndicatorPixel());
				System.out.println("Card5indicator: " + cropper.getCard5IndicatorPixel());
				System.out.println("Player1ActiveIndicator: " + cropper.getPlayer1ActiveIndicatorPixel());
				System.out.println("Player2ActiveIndicator: " + cropper.getPlayer2ActiveIndicatorPixel());
				System.out.println("Player3ActiveIndicator: " + cropper.getPlayer3ActiveIndicatorPixel());
				System.out.println("Player4ActiveIndicator: " + cropper.getPlayer4ActiveIndicatorPixel());
				System.out.println("Player5ActiveIndicator: " + cropper.getPlayer5ActiveIndicatorPixel());
				System.out.println("Player6ActiveIndicator: " + cropper.getPlayer6ActiveIndicatorPixel());
				System.out.println("Player7ActiveIndicator: " + cropper.getPlayer7ActiveIndicatorPixel());
				System.out.println("Player8ActiveIndicator: " + cropper.getPlayer8ActiveIndicatorPixel());
				System.out.println("DealerEnemy1Indicator: " + cropper.getDealerEnemy1IndicatorPixel());
				System.out.println("DealerEnemy2Indicator: " + cropper.getDealerEnemy2IndicatorPixel());
				System.out.println("DealerEnemy3Indicator: " + cropper.getDealerEnemy3IndicatorPixel());
				System.out.println("DealerEnemy4Indicator: " + cropper.getDealerEnemy4IndicatorPixel());
				System.out.println("DealerEnemy5Indicator: " + cropper.getDealerEnemy5IndicatorPixel());
				System.out.println("DealerEnemy6Indicator: " + cropper.getDealerEnemy6IndicatorPixel());
				System.out.println("DealerEnemy7Indicator: " + cropper.getDealerEnemy7IndicatorPixel());
				System.out.println("DealerEnemy8Indicator: " + cropper.getDealerEnemy8IndicatorPixel());
				System.out.println("DealerPlayerIndicator: " + cropper.getDealerPlayerIndicatorPixel());
				saveImage(screenshot, "Screenshot");
				saveImage(cropper.getPlayerCard1Image(), "PlayerCard1");
				saveImage(cropper.getPlayerCard1Image(), "PlayerCard2");
				saveImage(cropper.getMiddleCard1Image(), "MiddleCard1");
				saveImage(cropper.getMiddleCard2Image(), "MiddleCard2");
				saveImage(cropper.getMiddleCard3Image(), "MiddleCard3");
				saveImage(cropper.getMiddleCard4Image(), "MiddleCard4");
				saveImage(cropper.getMiddleCard5Image(), "MiddleCard5");
				saveImage(cropper.getMoneyEnemy1Image(), "MoneyEnemy1");
				saveImage(cropper.getMoneyEnemy2Image(), "MoneyEnemy2");
				saveImage(cropper.getMoneyEnemy3Image(), "MoneyEnemy3");
				saveImage(cropper.getMoneyEnemy4Image(), "MoneyEnemy4");
				saveImage(cropper.getMoneyEnemy5Image(), "MoneyEnemy5");
				saveImage(cropper.getMoneyEnemy6Image(), "MoneyEnemy6");
				saveImage(cropper.getMoneyEnemy7Image(), "MoneyEnemy7");
				saveImage(cropper.getMoneyEnemy8Image(), "MoneyEnemy8");
				saveImage(cropper.getMoneyPlayerImage(), "MoneyPlayer");
			}
			try {Thread.sleep(500);} catch (InterruptedException e) {}
		}
	}
	
	public static void saveImage(BufferedImage image, String name) {
		try {
			ImageIO.write(image, "png", new File("C:\\Users\\Simon\\git\\Test\\"+ name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
