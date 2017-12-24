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
import transcription.PlayerActiveTranscriptor;

@RunWith(Parameterized.class)
public class PlayerActiveTranscriptorTest {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, new boolean[] {true, true, false, false, true, true, false, true} },
                 { 2, new boolean[] {true, true, false, false, true, true, false, false} },
                 { 3, new boolean[] {true, true, true, false, false, false, false, false} },
                 { 4, new boolean[] {true, true, true, true, false, false, false, false} },
                 { 5, new boolean[] {true, true, true, false, false, false, false, false} },
                 { 6, new boolean[] {true, false, false, false, false, false, false, false} },
                 { 7, new boolean[] {true, true, false, false, false, false, false, false} },
                 { 8, new boolean[] {true, true, false, true, false, false, false, false} },
                 { 9, new boolean[] {true, true, true, true, false, true, true, false} },
                 { 10, new boolean[] {true, false, false, false, false, false, false, false} },
                 { 11, new boolean[] {true, false, false, false, false, false, false, false} },
                 { 12, new boolean[] {false, true, false, false, false, false, false, false} },
                 { 13, new boolean[] {false, false, false, false, true, false, false, false} },
                 { 14, new boolean[] {false, false, false, false, false, false, true, true} },
                 { 15, new boolean[] {true, false, true, false, false, false, false, false} },
                 { 16, new boolean[] {true, true, true, false, false, false, false, true} },
                 { 17, new boolean[] {true, true, false, true, false, true, false, false} },
                 { 18, new boolean[] {true, true, false, false, false, false, false, false} },
                 { 19, new boolean[] {true, true, true, false, false, false, false, false} },
                 { 20, new boolean[] {true, true, true, false, true, false, true, false} },
                 { 21, new boolean[] {false, true, false, true, true, false, true, true} },
                 { 22, new boolean[] {false, false, true, false, false, false, false, true} },
                 { 23, new boolean[] {false, false, false, true, false, false, true, false} },
                 { 24, new boolean[] {true, false, true, true, false, false, true, false} },
                 { 25, new boolean[] {false, true, false, false, false, false, false, false} },
                 { 26, new boolean[] {false, true, true, true, true, false, false, true} },
                 { 27, new boolean[] {true, true, false, false, false, false, false, true} },
                 { 28, new boolean[] {true, true, true, false, true, false, false, true} },
                 { 29, new boolean[] {true, true, false, false, true, false, false, false} },
                 { 30, new boolean[] {false, true, true, true, true, true, false, false} }
           });
    }

    private int handNumber;

    private boolean[] expected;
    
    //TODO Redo this with new images, doesnt really work right now
    public PlayerActiveTranscriptorTest(int input, boolean[] expected) {
        this.handNumber= input;
        this.expected= expected;
    }

	@Test
	public void test() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(PlayerActiveTranscriptorTest.class.getClassLoader().getResource("Hand" + handNumber + ".png").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ScreenCropper cropper = new ScreenCropper(image);
		PlayerActiveTranscriptor transcriptor = new PlayerActiveTranscriptor(cropper);
		Assert.assertEquals(expected[0], transcriptor.isEnemy1Active());
		Assert.assertEquals(expected[1], transcriptor.isEnemy2Active());
		Assert.assertEquals(expected[2], transcriptor.isEnemy3Active());
		Assert.assertEquals(expected[3], transcriptor.isEnemy4Active());
		Assert.assertEquals(expected[4], transcriptor.isEnemy5Active());
		Assert.assertEquals(expected[5], transcriptor.isEnemy6Active());
		Assert.assertEquals(expected[6], transcriptor.isEnemy7Active());
		Assert.assertEquals(expected[7], transcriptor.isEnemy8Active());
	}

}