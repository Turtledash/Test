package transcription;

import extraction.ScreenCropper;

public class PlayerActiveTranscriptor {

	private ScreenCropper cropper;
	
	public PlayerActiveTranscriptor(ScreenCropper cropper) {
		this.cropper = cropper;
	}
	
	public boolean isEnemy8Active() {
		int indicator = cropper.getPlayer8ActiveIndicatorPixel();
		if (indicator == -16316665)
			return true;
		return false;
	}
	
	public boolean isEnemy7Active() {
		int indicator = cropper.getPlayer7ActiveIndicatorPixel();
		if (indicator == -16316665)
			return true;
		return false;
	}
	
	public boolean isEnemy6Active() {
		int indicator = cropper.getPlayer6ActiveIndicatorPixel();
		if (indicator == -16250872)
			return true;
		return false;
	}
	
	public boolean isEnemy5Active() {
		int indicator = cropper.getPlayer5ActiveIndicatorPixel();
		if (indicator == -16382458)
			return true;
		return false;
	}
	
	public boolean isEnemy4Active() {
		int indicator = cropper.getPlayer4ActiveIndicatorPixel();
		if (indicator == -16250872)
			return true;
		return false;
	}
	
	public boolean isEnemy3Active() {
		int indicator = cropper.getPlayer3ActiveIndicatorPixel();
		if (indicator == -16250872)
			return true;
		return false;
	}
	
	public boolean isEnemy2Active() {
		int indicator = cropper.getPlayer2ActiveIndicatorPixel();
		if (indicator == -16250872)
			return true;
		return false;
	}
	
	public boolean isEnemy1Active() {
		int indicator = cropper.getPlayer1ActiveIndicatorPixel();
		if (indicator == -16316665)
			return true;
		return false;
	}
}
