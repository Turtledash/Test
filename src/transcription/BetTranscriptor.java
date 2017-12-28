package transcription;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import extraction.ScreenCropper;
import net.sourceforge.tess4j.TessAPI;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.Word;
import net.sourceforge.tess4j.util.LoadLibs;

public class BetTranscriptor {

	private ScreenCropper cropper;
	Tesseract1 instance;
	PlayerActiveTranscriptor playerActive;

	public BetTranscriptor(ScreenCropper cropper) {
		this.cropper = cropper;
		instance = new Tesseract1();
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");
		instance.setDatapath(tessDataFolder.getParent());
		instance.setTessVariable("tessedit_char_whitelist", "0123456789.$");
		playerActive = new PlayerActiveTranscriptor(cropper);
	}

	public Double getBetEnemy1() {
		BufferedImage bet = cropper.getBetEnemy1Image();
		Double result = ocrBet(bet);
		bet.flush();
		return result;
	}

	private Double ocrBet(BufferedImage bet) {
		bet = turnBlackAndWhite(bet);
		String output = "";
		List<Word> words = instance.getWords(bet, TessAPI.TessPageIteratorLevel.RIL_SYMBOL);
		for (Word w : words) {
			if (w.getConfidence() > 70)
				output += w.getText();
		}
		if (!output.contains("$"))
			output = output.replaceFirst("5", "\\$");
		output = output.replace("$", "");
		output = output.replace(" ", "");
		if (output.equals(""))
			return null;
		return Double.parseDouble(output);
	}

	private BufferedImage turnBlackAndWhite(BufferedImage cardImage) {
		final int xmin = cardImage.getMinX();
		final int ymin = cardImage.getMinY();

		final int ymax = ymin + cardImage.getHeight();
		final int xmax = xmin + cardImage.getWidth();

		for (int i = xmin; i < xmax; i++) {
			for (int j = ymin; j < ymax; j++) {

				int pixel = cardImage.getRGB(i, j);
				if (pixel < -5000000) {
					cardImage.setRGB(i, j, -1);
				} else {
					cardImage.setRGB(i, j, -16777215);
				}
			}
		}
		return cardImage;
	}

	public Double getBetEnemy2() {
		BufferedImage bet = cropper.getBetEnemy2Image();
		return ocrBet(bet);
	}

	public Double getBetEnemy3() {
		BufferedImage bet = cropper.getBetEnemy3Image();
		return ocrBet(bet);
	}

	public Double getBetEnemy4() {
		BufferedImage bet = cropper.getBetEnemy4Image();
		return ocrBet(bet);
	}

	public Double getBetEnemy5() {
		BufferedImage bet = cropper.getBetEnemy5Image();
		return ocrBet(bet);
	}

	public Double getBetEnemy6() {
		BufferedImage bet = cropper.getBetEnemy6Image();
		return ocrBet(bet);
	}

	public Double getBetEnemy7() {
		BufferedImage bet = cropper.getBetEnemy7Image();
		return ocrBet(bet);
	}

	public Double getBetEnemy8() {
		BufferedImage bet = cropper.getBetEnemy8Image();
		return ocrBet(bet);
	}

	public Double getBetPlayer() {
		BufferedImage bet = cropper.getBetPlayerImage();
		return ocrBet(bet);
	}
}
