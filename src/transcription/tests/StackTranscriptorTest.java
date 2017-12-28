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
import transcription.StackTranscriptor;

@RunWith(Parameterized.class)
public class StackTranscriptorTest {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, new Double[] {1.98, 2.07, 0.96, null, null, 0.96, 0.80, null, 1.96} },
                 { 2, new Double[] {1.98, 2.07, 0.96, null, null, 0.96, 0.68, null, null} },
                 { 3, new Double[] {2.03, 2.0, 1.95, 1.98, null, null, null, null, null} },
                 { 4, new Double[] {2.0, 2.06, 2.21, 1.47, 2.61, null, null, null, null} },
                 { 5, new Double[] {2.04, 1.98, 1.93, 1.98, null, null, null, null, null} },
                 { 7, new Double[] {2.03, 2.04, 1.87, null, null, null, null, null, null} },
                 { 8, new Double[] {2.0, 2.07, 0.94, null, 1.98, null, null, null, null} },
                 { 9, new Double[] {2.0, 2.06, 2.24, 1.46, 2.69, null, 0.98, 2.0, null} },
                 { 10, new Double[] {2.04, 2.01, null, null, null, null, null, null, null} },
                 { 11, new Double[] {1.96, 1.93, null, null, null, null, null, null, null} },
                 { 12, new Double[] {1.90, null, 0.84, null, null, null, null, null, null} },
                 { 13, new Double[] {1.98, null, null, null, null, 4.67, null, null, null} },
                 { 14, new Double[] {1.98, null, null, null, null, null, null, 0.46, 1.82} },
                 { 15, new Double[] {1.99, 2.45, null, 2.0, null, null, null, null, null} },
                 { 16, new Double[] {2.0, 2.44, 1.98, 2.03, null, null, null, null, 1.94} },
                 { 17, new Double[] {2.0, 1.52, 1.58, null, 1.90, null, 1.47, null, null} },
                 { 18, new Double[] {2.0, 2.74, 1.55, null, null, null, null, null, null} },
                 { 19, new Double[] {2.0, 2.44, 2.42, 1.98, null, null, null, null, null} },
                 { 20, new Double[] {2.0, 2.74, 1.57, 2.59, null, 1.44, null, 0.32, null} },
                 { 21, new Double[] {2.21, null, 0.44, null, 3.02, 1.25, null, 0.76, 1.94} },
                 { 22, new Double[] {1.98, null, null, 2.65, null, null, null, null, 1.99} },
                 { 23, new Double[] {1.98, null, null, null, 1.66, null, null, 2.81, null} },
                 { 24, new Double[] {1.99, 2.04, null, 1.47, 2.67, null, null, 1.95, null} },
                 { 25, new Double[] {2.19, null, 0.23, null, null, null, null, null, null} },
                 { 26, new Double[] {2.0, null, 3.16, 2.0, 1.99, 1.98, null, null, 1.92} },
                 { 27, new Double[] {2.18, 1.98, 0.0, null, null, null, null, null, 2.16} },
                 { 28, new Double[] {2.03, 2.0, 1.99, 2.70, null, 1.97, null, null, 1.97} },
                 { 29, new Double[] {2.18, 1.99, 0.31, null, null, 1.19, null, null, null} },
                 { 30, new Double[] {2.0, null, 2.95, 2.0, 2.0, 1.99, 1.98, null, null} },
                 { 31, new Double[] {2.0, 2.28, null, 2.56, 1.66, 2.42, null, null, null} },
                 { 32, new Double[] {2.0, 2.68, 1.57, 2.57, 2.54, 1.90, 0.76, null, null} },
                 { 33, new Double[] {2.0, 2.28, null, 2.56, 1.65, 2.45, null, 2.98, null} },
                 { 34, new Double[] {2.0, null, 3.17, 2.0, 2.0, 2.0, 2.0, 2.0, 2.14} },
                 { 35, new Double[] {2.08, 2.0, 1.27, 1.99, 3.0, 0.99, null, null, null} }, 
                 { 36, new Double[] {1.98, null, null, null, null, 0.44, 0.43, null, null} },
                 { 37, new Double[] {1.98, null, null, null, null, 0.44, 0.43, null, null} },
                 { 38, new Double[] {1.98, null, null, null, null, 0.42, 0.41, null, null} },
                 { 39, new Double[] {2.0, 1.44, 1.50, null, 2.0, 4.19, 2.44, 1.98, null} },
                 { 40, new Double[] {2.0, 2.26, 0.55, 1.02, 2.08, null, 1.99, null, null} },
                 { 41, new Double[] {1.99, 1.98, null, null, null, null, null, null, 1.95} },
                 { 42, new Double[] {2.0, 2.60, 1.65, 2.57, 2.54, 2.01, 0.73, 0.60, 2.07} },
                 { 43, new Double[] {2.03, 2.0, 2.03, 2.68, 2.61, 2.10, 1.56, 2.08, null} },
                 { 44, new Double[] {2.0, 2.26, 0.55, 1.02, 2.23, null, 1.98, null, null} },
                 { 45, new Double[] {2.0, 1.97, 3.15, null, null, null, null, null, null} },
                 { 46, new Double[] {2.0, 2.26, 0.55, 1.02, 2.23, null, 2.0, 2.07, null} },
                 { 47, new Double[] {2.11, 2.0, null, 2.0, 2.99, null, 1.99, 0.70, null} },
                 { 48, new Double[] {2.0, 2.0, 1.97, 2.07, null, 0.38, null, null, 4.38} },
                 { 49, new Double[] {2.0, 1.97, 3.17, 1.99, 1.98, null, null, null, null} },
                 { 50, new Double[] {2.01, null, null, null, 2.56, null, 1.51, null, null} },
           });
    }

    private int handNumber;
    private Double[] expected;
    
    public StackTranscriptorTest(int input, Double[] expected) {
        this.handNumber= input;
        this.expected= expected;
    }

	@Test
	public void test() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(StackTranscriptorTest.class.getClassLoader().getResource("Hand" + handNumber + ".png").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ScreenCropper cropper = new ScreenCropper(image);
		StackTranscriptor transcriptor = new StackTranscriptor(cropper);
		Assert.assertEquals(expected[0], transcriptor.getStackSizePlayer());
		Assert.assertEquals(expected[1], transcriptor.getStackSizeEnemy1());
		Assert.assertEquals(expected[2], transcriptor.getStackSizeEnemy2());
		Assert.assertEquals(expected[3], transcriptor.getStackSizeEnemy3());
		Assert.assertEquals(expected[4], transcriptor.getStackSizeEnemy4());
		Assert.assertEquals(expected[5], transcriptor.getStackSizeEnemy5());
		Assert.assertEquals(expected[6], transcriptor.getStackSizeEnemy6());
		Assert.assertEquals(expected[7], transcriptor.getStackSizeEnemy7());
		Assert.assertEquals(expected[8], transcriptor.getStackSizeEnemy8());
	}

}