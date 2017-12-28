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
import transcription.BetTranscriptor;

@RunWith(Parameterized.class)
public class BetTranscriptorTest {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, new Double[] {null, null, null, null, null, null, null, null, null} },
                 { 2, new Double[] {null, null, null, null, null, null, 0.12, null, null} },
                 { 3, new Double[] {null, null, 0.01, 0.02, null, null, null, null, null} },
                 { 4, new Double[] {null, null, 0.01, 0.02, 0.08, null, null, null, null} },
                 { 5, new Double[] {0.02, 0.02, 0.02, 0.02, null, null, null, null, null} },
                 { 6, new Double[] {null, 0.06, null, null, null, null, null, null, null} },
                 { 7, new Double[] {0.01, 0.02, 0.06, null, null, null, null, null, null} },
                 { 8, new Double[] {null, 0.01, 0.02, null, 0.02, null, null, null, null} },
                 { 9, new Double[] {null, null, null, null, 0.01, null, 0.02, null, null} },
                 { 10, new Double[] {0.02, 0.02, null, null, 0.01, null, null, null, null} },
                 { 11, new Double[] {null, null, null, null, null, null, null, null, null} },
                 { 12, new Double[] {null, null, 0.02, null, null, null, null, null, null} },
                 { 13, new Double[] {0.02, null, null, null, null, 0.07, null, null, 0.01} },
                 { 14, new Double[] {0.02, null, null, null, null, null, null, 0.02, 0.10} },
                 { 15, new Double[] {0.01, 0.02, null, 0.06, null, null, null, null, null} },
                 { 16, new Double[] {null, 0.01, 0.02, 0.06, null, null, null, null, 0.06} },
                 { 17, new Double[] {null, 0.01, 0.02, null, 0.10, null, 0.10, null, null} },
                 { 18, new Double[] {null, 0.01, 0.02, null, null, null, null, null, null} },
                 { 19, new Double[] {null, null, 0.01, 0.02, null, null, null, null, null} },
                 { 20, new Double[] {null, null, 0.01, 0.02, null, 0.06, null, 0.06, null} },
                 { 21, new Double[] {null, null, null, null, null, null, null, 0.01, 0.02} },
                 { 22, new Double[] {0.02, null, null, 0.04, null, null, null, null, 0.01} },
                 { 23, new Double[] {0.02, null, null, null, 0.02, null, null, 0.14, 0.01} },
                 { 24, new Double[] {0.01, 0.02, null, 0.02, 0.02, null, null, 0.05, null} },
                 { 25, new Double[] {0.02, null, 0.04, null, null, null, null, null, 0.01} },
                 { 26, new Double[] {null, null, null, null, 0.01, 0.02, null, null, 0.02} },
                 { 27, new Double[] {0.01, 0.02, 0.30, null, null, null, null, null, null} },
                 { 28, new Double[] {null, null, 0.01, 0.02, null, 0.06, null, null, 0.06} },
                 { 29, new Double[] {null, 0.01, 0.02, null, null, 0.02, null, null, null} },
                 { 30, new Double[] {null, null, null, null, null, 0.01, 0.02, null, null} },
                 { 65, new Double[] {null, null, null, null, 0.01, 0.02, 0.04, null, 0.15} },
              });
    }

    private int handNumber;
    private Double[] expected;
    
    public BetTranscriptorTest(int input, Double[] expected) {
        this.handNumber= input;
        this.expected= expected;
    }

	@Test
	public void test() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(BetTranscriptorTest.class.getClassLoader().getResource("Hand" + handNumber + ".png").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ScreenCropper cropper = new ScreenCropper(image);
		BetTranscriptor transcriptor = new BetTranscriptor(cropper);
		Assert.assertEquals(expected[0], transcriptor.getBetPlayer());
		Assert.assertEquals(expected[1], transcriptor.getBetEnemy1());
		Assert.assertEquals(expected[2], transcriptor.getBetEnemy2());
		Assert.assertEquals(expected[3], transcriptor.getBetEnemy3());
		Assert.assertEquals(expected[4], transcriptor.getBetEnemy4());
		Assert.assertEquals(expected[5], transcriptor.getBetEnemy5());
		Assert.assertEquals(expected[6], transcriptor.getBetEnemy6());
		Assert.assertEquals(expected[7], transcriptor.getBetEnemy7());
		Assert.assertEquals(expected[8], transcriptor.getBetEnemy8());
	}

}