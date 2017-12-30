package extraction;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ScreenCropper {

	private BufferedImage screenshot;
	
	public ScreenCropper(BufferedImage screenshot) {
		this.screenshot = screenshot;
	}
	
	public BufferedImage getPotsizeImage() {
		return deepCopy(screenshot.getSubimage(652, 275, 206, 29));
	}
	
	public BufferedImage getMoneyPlayerImage() {
		return deepCopy(screenshot.getSubimage(581, 699, 100, 20));
	}
	
	public BufferedImage getMoneyEnemy8Image() {
		return deepCopy(screenshot.getSubimage(1021, 629, 100, 20));
	}
	
	public BufferedImage getMoneyEnemy7Image() {
		return deepCopy(screenshot.getSubimage(1171, 435, 100, 20));
	}
	
	public BufferedImage getMoneyEnemy6Image() {
		return deepCopy(screenshot.getSubimage(1101, 247, 100, 20));
	}
	
	public BufferedImage getMoneyEnemy5Image() {
		return deepCopy(screenshot.getSubimage(841, 155, 100, 20));
	}
	
	public BufferedImage getMoneyEnemy4Image() {
		return deepCopy(screenshot.getSubimage(378, 155, 100, 20));
	}
	
	public BufferedImage getMoneyEnemy3Image() {
		return deepCopy(screenshot.getSubimage(115, 247, 100, 20));
	}
	
	public BufferedImage getMoneyEnemy2Image() {
		return deepCopy(screenshot.getSubimage(53, 435, 100, 20));
	}
	
	public BufferedImage getMoneyEnemy1Image() {
		return deepCopy(screenshot.getSubimage(200, 629, 100, 20));
	}

	public BufferedImage getMiddleCard5Image() {
		return deepCopy(screenshot.getSubimage(800, 315, 79, 114));
	}
	public BufferedImage getMiddleCard4Image() {
		return deepCopy(screenshot.getSubimage(709, 315, 79, 70));
	}
	public BufferedImage getMiddleCard3Image() {
		return deepCopy(screenshot.getSubimage(618, 315, 79, 70));
	}
	public BufferedImage getMiddleCard2Image() {
		return deepCopy(screenshot.getSubimage(527, 315, 79, 70));
	}
	public BufferedImage getMiddleCard1Image() {
		return deepCopy(screenshot.getSubimage(436, 315, 79, 70));
	}
	
	public BufferedImage getPlayerCard1Image() {
		return deepCopy(screenshot.getSubimage(577, 582, 79, 70));
	}
	
	public BufferedImage getPlayerCard2Image() {
		return deepCopy(screenshot.getSubimage(658, 582, 79, 70));
	}
	
	public BufferedImage getBetPlayerImage() {
		return deepCopy(screenshot.getSubimage(643, 524, 155, 19));
	}
	
	public BufferedImage getBetEnemy1Image() {
		return deepCopy(screenshot.getSubimage(423, 504, 155, 19));
	}
	
	public BufferedImage getBetEnemy2Image() {
		return deepCopy(screenshot.getSubimage(308, 434, 155, 19));
	}
	
	public BufferedImage getBetEnemy3Image() {
		return deepCopy(screenshot.getSubimage(380, 262, 155, 19));
	}
	
	public BufferedImage getBetEnemy4Image() {
		return deepCopy(screenshot.getSubimage(550, 232, 155, 19));
	}
	
	public BufferedImage getBetEnemy5Image() {
		return deepCopy(screenshot.getSubimage(636, 214, 155, 19));
	}
	
	public BufferedImage getBetEnemy6Image() {
		return deepCopy(screenshot.getSubimage(786, 264, 155, 19));
	}
	
	public BufferedImage getBetEnemy7Image() {
		return deepCopy(screenshot.getSubimage(855, 439, 155, 19));
	}
	
	public BufferedImage getBetEnemy8Image() {
		return deepCopy(screenshot.getSubimage(751, 504, 155, 19));
	}

	public int getPlayer8ActiveIndicatorPixel() {
		return screenshot.getRGB(1121, 650);
	}
	
	public int getPlayer7ActiveIndicatorPixel() {
		return screenshot.getRGB(1265, 456);
	}
	
	public int getPlayer6ActiveIndicatorPixel() {
		return screenshot.getRGB(1209, 267);
	}
	
	public int getPlayer5ActiveIndicatorPixel() {
		return screenshot.getRGB(942, 176);
	}
	
	public int getPlayer4ActiveIndicatorPixel() {
		return screenshot.getRGB(501, 174);
	}
	
	public int getPlayer3ActiveIndicatorPixel() {
		return screenshot.getRGB(221, 266);
	}
	
	public int getPlayer2ActiveIndicatorPixel() {
		return screenshot.getRGB(153, 455);
	}
	
	public int getPlayer1ActiveIndicatorPixel() {
		return screenshot.getRGB(302, 650);
	}
	
	public int getDealerPlayerIndicatorPixel() {
		return screenshot.getRGB(783, 578);
	}
	
	public int getDealerEnemy8IndicatorPixel() {
		return screenshot.getRGB(918, 548);
	}
	
	public int getDealerEnemy7IndicatorPixel() {
		return screenshot.getRGB(1058, 365);
	}
	
	public int getDealerEnemy6IndicatorPixel() {
		return screenshot.getRGB(1028, 306);
	}
	
	public int getDealerEnemy5IndicatorPixel() {
		return screenshot.getRGB(871, 224);
	}
	
	public int getDealerEnemy4IndicatorPixel() {
		return screenshot.getRGB(489, 225);
	}
	
	public int getDealerEnemy3IndicatorPixel() {
		return screenshot.getRGB(313, 305);
	}
	
	public int getDealerEnemy2IndicatorPixel() {
		return screenshot.getRGB(263, 369);
	}
	
	public int getDealerEnemy1IndicatorPixel() {
		return screenshot.getRGB(441, 559);
	}
	
	public int getCard1IndicatorPixel() {
		return screenshot.getRGB(474, 318);
	}
	
	public int getCard2IndicatorPixel() {
		return screenshot.getRGB(566, 318);
	}
	
	public int getCard3IndicatorPixel() {
		return screenshot.getRGB(654, 318);
	}
	
	public int getCard4IndicatorPixel() {
		return screenshot.getRGB(746, 318);
	}
	
	public int getCard5IndicatorPixel() {
		return screenshot.getRGB(842, 318);
	}
	
	public int getTurnIndicatorPixel() {
		return screenshot.getRGB(1113, 839);
	}
	
	private  BufferedImage deepCopy(BufferedImage bi) {
	    ColorModel cm = bi.getColorModel();
	    boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
	    WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
	    return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
}
