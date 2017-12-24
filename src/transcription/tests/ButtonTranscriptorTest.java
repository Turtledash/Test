package transcription.tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import extraction.ScreenCropper;
import transcription.ButtonTranscriptor;

@RunWith(Parameterized.class)
public class ButtonTranscriptorTest {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, new boolean[] {false, false, false, false, false, false, true, false, false} },
                 { 2, new boolean[] {false, false, false, false, false, false, true, false, false} },
                 { 3, new boolean[] {true, false, false, false, false, false, false, false, false} },
                 { 4, new boolean[] {true, false, false, false, false, false, false, false, false} },
                 { 5, new boolean[] {false, true, false, false, false, false, false, false, false} },
                 { 6, new boolean[] {false, true, false, false, false, false, false, false, false} },
                 { 7, new boolean[] {false, false, true, false, false, false, false, false, false} },
                 { 8, new boolean[] {false, false, false, false, false, false, false, false, true} },
                 { 9, new boolean[] {false, false, true, false, false, false, false, false, false} },
                 { 10, new boolean[] {false, false, true, false, false, false, false, false, false} },
                 { 11, new boolean[] {false, false, true, false, false, false, false, false, false} },
                 { 12, new boolean[] {false, false, false, false, false, false, false, false, true} },
                 { 13, new boolean[] {false, false, false, false, false, false, true, false, false} },
                 { 14, new boolean[] {false, false, false, false, false, false, true, false, false} },
                 { 15, new boolean[] {false, false, false, true, false, false, false, false, false} },
                 { 16, new boolean[] {false, false, false, false, false, false, false, false, true} },
                 { 17, new boolean[] {false, false, false, false, false, false, false, false, true} },
                 { 18, new boolean[] {false, false, false, false, false, false, false, false, true} },
                 { 19, new boolean[] {true, false, false, false, false, false, false, false, false} },
                 { 20, new boolean[] {true, false, false, false, false, false, false, false, false} },
           });
    }

    private int handNumber;

    private boolean[] expected;
    
    public ButtonTranscriptorTest(int input, boolean[] expected) {
        this.handNumber= input;
        this.expected= expected;
    }

	@Test
	public void test() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(ButtonTranscriptorTest.class.getClassLoader().getResource("Hand" + handNumber + ".png").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ScreenCropper cropper = new ScreenCropper(image);
		ButtonTranscriptor transcriptor = new ButtonTranscriptor(cropper);
		Assert.assertEquals(expected[0], transcriptor.isEnemy1Button());
		Assert.assertEquals(expected[1], transcriptor.isEnemy2Button());
		Assert.assertEquals(expected[2], transcriptor.isEnemy3Button());
		Assert.assertEquals(expected[3], transcriptor.isEnemy4Button());
		Assert.assertEquals(expected[4], transcriptor.isEnemy5Button());
		Assert.assertEquals(expected[5], transcriptor.isEnemy6Button());
		Assert.assertEquals(expected[6], transcriptor.isEnemy7Button());
		Assert.assertEquals(expected[7], transcriptor.isEnemy8Button());
		Assert.assertEquals(expected[8], transcriptor.isPlayerButton());
	}

}