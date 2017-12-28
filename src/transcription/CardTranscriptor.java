package transcription;

import java.awt.image.BufferedImage;
import java.io.File;

import extraction.ScreenCropper;
import model.Card;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

public class CardTranscriptor {

	private ScreenCropper cropper;
	ITesseract instance;

	public CardTranscriptor(ScreenCropper cropper) {
		this.cropper = cropper;
		instance = new Tesseract();
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");
		instance.setDatapath(tessDataFolder.getParent());
		instance.setTessVariable("tessedit_char_whitelist", "0123456789AKQJ");
	}

	public Card getLeftPlayerCard() {
		BufferedImage image = cropper.getPlayerCard1Image();
		return getCardImage(image);
	}

	public Card getRightPlayerCard() {
		BufferedImage image = cropper.getPlayerCard2Image();
		return getCardImage(image);
	}

	public Card getMiddle1Card() {
		int indicator = cropper.getCard1IndicatorPixel();
		if (indicator == -16692200)
			return null;
		return getCardImage(cropper.getMiddleCard1Image());
	}

	public Card getMiddle2Card() {
		int indicator = cropper.getCard2IndicatorPixel();
		if (indicator == -16691431)
			return null;
		return getCardImage(cropper.getMiddleCard2Image());
	}

	public Card getMiddle3Card() {
		int indicator = cropper.getCard3IndicatorPixel();
		if (indicator == -16691175)
			return null;
		return getCardImage(cropper.getMiddleCard3Image());
	}

	public Card getMiddle4Card() {
		int indicator = cropper.getCard4IndicatorPixel();
		if (indicator == -16691175)
			return null;
		return getCardImage(cropper.getMiddleCard4Image());
	}

	public Card getMiddle5Card() {
		int indicator = cropper.getCard5IndicatorPixel();
		if (indicator == -16692456)
			return null;
		return getCardImage(cropper.getMiddleCard5Image());
	}

	private Card getCardImage(BufferedImage cardImage) {
		String color = getColor(cardImage);
		cardImage = turnBlackAndWhite(cardImage);
		String letter = doOCR(cardImage);
		return Card.fromString(letter + color);
	}

	private String getColor(BufferedImage cardImage) {
		int rgb = cardImage.getRGB(60, 10);
		switch (rgb) {
		case -11571076:
			return "d";
		case -6208703:
			return "h";
		case -12434878:
			return "s";
		case -11437261:
			return "c";
		default:
			throw new IllegalStateException();
		}
	}

	private String doOCR(BufferedImage cardImage) {
		String letter = "";
		try {
			letter = instance.doOCR(cardImage).trim();
		} catch (TesseractException e) {
			e.printStackTrace();
		}
		if (letter.equals("0"))
			letter = "10";
		return letter;
	}

	private BufferedImage turnBlackAndWhite(BufferedImage cardImage) {
		final int xmin = cardImage.getMinX();
		final int ymin = cardImage.getMinY();

		final int ymax = ymin + cardImage.getHeight();
		final int xmax = xmin + cardImage.getWidth();

		for (int i = xmin; i < xmax; i++) {
			for (int j = ymin; j < ymax; j++) {

				int pixel = cardImage.getRGB(i, j);
				if (pixel != -1) {
					cardImage.setRGB(i, j, -1);
				} else {
					cardImage.setRGB(i, j, -16777215);
				}
			}
		}
		return cardImage;
	}
}
