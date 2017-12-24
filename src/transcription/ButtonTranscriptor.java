package transcription;

import extraction.ScreenCropper;

public class ButtonTranscriptor {

	private ScreenCropper cropper;
	
	public ButtonTranscriptor(ScreenCropper cropper) {
		this.cropper = cropper;
	}
	
	public boolean isEnemy1Button() {
		int indicator = cropper.getDealerEnemy1IndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
	
	public boolean isEnemy2Button() {
		int indicator = cropper.getDealerEnemy2IndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
	
	public boolean isEnemy3Button() {
		int indicator = cropper.getDealerEnemy3IndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
	
	public boolean isEnemy4Button() {
		int indicator = cropper.getDealerEnemy4IndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
	
	public boolean isEnemy5Button() {
		int indicator = cropper.getDealerEnemy5IndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
	
	public boolean isEnemy6Button() {
		int indicator = cropper.getDealerEnemy6IndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
	
	public boolean isEnemy7Button() {
		int indicator = cropper.getDealerEnemy7IndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
	
	public boolean isEnemy8Button() {
		int indicator = cropper.getDealerEnemy8IndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
	
	public boolean isPlayerButton() {
		int indicator = cropper.getDealerPlayerIndicatorPixel();
		if (indicator == -720886)
			return true;
		return false;
	}
}
