package transcription;

import java.awt.image.BufferedImage;
import java.io.File;

import extraction.ScreenCropper;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

public class StackTranscriptor {

	private ScreenCropper cropper;
	ITesseract instance;
	PlayerActiveTranscriptor playerActive;
	
	public StackTranscriptor(ScreenCropper cropper) {
		this.cropper = cropper;
		instance = new Tesseract();
		File tessDataFolder = LoadLibs.extractTessResources("tessdata");
		instance.setDatapath(tessDataFolder.getParent());
		instance.setTessVariable("tessedit_char_whitelist", "0123456789.$AlIn");
		playerActive = new PlayerActiveTranscriptor(cropper);
	}
	
	public Double getStackSizeEnemy1() {
		if (!playerActive.isEnemy1Active())
			return null;
		BufferedImage image = cropper.getMoneyEnemy1Image();
		return ocrStack(image);
	}

	private Double ocrStack(BufferedImage image) {
		image = turnBlackAndWhite(image);
		String output = doOcr(image);
		if (!output.contains("$"))
			output = output.replaceFirst("5", "\\$");
		output = output.replace("$", "");
		output = output.replace(" ", "");
		if (output.contains("A"))
			return 0.0;
		return Double.parseDouble(output);
	}

	private String doOcr(BufferedImage image) {
		try {
			return instance.doOCR(image);
		} catch (TesseractException e) {
			throw new IllegalStateException();
		}
	}

	public Double getStackSizeEnemy2() {
		if (!playerActive.isEnemy2Active())
			return null;
		BufferedImage image = cropper.getMoneyEnemy2Image();
		return ocrStack(image);
	}
	
	public Double getStackSizeEnemy3() {
		if (!playerActive.isEnemy3Active())
			return null;
		BufferedImage image = cropper.getMoneyEnemy3Image();
		return ocrStack(image);
	}
	
	public Double getStackSizeEnemy4() {
		if (!playerActive.isEnemy4Active())
			return null;
		BufferedImage image = cropper.getMoneyEnemy4Image();
		return ocrStack(image);
	}
	
	public Double getStackSizeEnemy5() {
		if (!playerActive.isEnemy5Active())
			return null;
		BufferedImage image = cropper.getMoneyEnemy5Image();
		return ocrStack(image);
	}
	
	public Double getStackSizeEnemy6() {
		if (!playerActive.isEnemy6Active())
			return null;
		BufferedImage image = cropper.getMoneyEnemy6Image();
		return ocrStack(image);
	}
	
	public Double getStackSizeEnemy7() {
		if (!playerActive.isEnemy7Active())
			return null;
		BufferedImage image = cropper.getMoneyEnemy7Image();
		return ocrStack(image);
	}
	
	public Double getStackSizeEnemy8() {
		if (!playerActive.isEnemy8Active())
			return null;
		BufferedImage image = cropper.getMoneyEnemy8Image();
		return ocrStack(image);
	}
	
	public Double getStackSizePlayer() {
		BufferedImage image = cropper.getMoneyPlayerImage();
		return ocrStack(image);
	}

	private BufferedImage turnBlackAndWhite(BufferedImage cardImage) {
		final int xmin = cardImage.getMinX();
		final int ymin = cardImage.getMinY();

		final int ymax = ymin + cardImage.getHeight();
		final int xmax = xmin + cardImage.getWidth();

		for (int i = xmin; i < xmax; i++) {
			for (int j = ymin; j < ymax; j++) {

				int pixel = cardImage.getRGB(i, j);
				if (pixel > -15000000) {
					cardImage.setRGB(i, j, -16777215);
				} else {
					cardImage.setRGB(i, j, -1);
				}
			}
		}
		return cardImage;
	}
}
