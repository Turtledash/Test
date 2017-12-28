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
import transcription.PotTranscriptor;

@RunWith(Parameterized.class)
public class PotsizeTranscriptorTest {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, new Double[] {0.12} },     
                 { 2, new Double[] {0.24} },     
                 { 3, new Double[] {0.03} },     
                 { 4, new Double[] {0.11} },     
                 { 5, new Double[] {0.08} },     
                 { 6, new Double[] {0.14} },     
                 { 7, new Double[] {0.09} },     
                 { 8, new Double[] {0.05} },     
                 { 9, new Double[] {0.03} },     
                 { 10, new Double[] {0.05} },     
                 { 11, new Double[] {0.20} },     
                 { 12, new Double[] {0.24} },     
                 { 13, new Double[] {0.10} },     
                 { 14, new Double[] {0.14} },     
                 { 15, new Double[] {0.09} },     
                 { 16, new Double[] {0.15} },     
                 { 17, new Double[] {0.23} },     
                 { 18, new Double[] {0.03} },     
                 { 19, new Double[] {0.03} },     
                 { 20, new Double[] {0.15} },     
                 { 21, new Double[] {0.03} },     
                 { 22, new Double[] {0.07} },     
                 { 23, new Double[] {0.19} },     
                 { 24, new Double[] {0.12} },     
                 { 25, new Double[] {0.07} },     
                 { 26, new Double[] {0.05} },     
                 { 27, new Double[] {0.33} },     
                 { 28, new Double[] {0.15} },     
                 { 29, new Double[] {0.05} },     
                 { 30, new Double[] {0.03} },     
              });
    }

    private int handNumber;
    private Double[] expected;
    
    public PotsizeTranscriptorTest(int input, Double[] expected) {
        this.handNumber= input;
        this.expected= expected;
    }

	@Test
	public void test() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(PotsizeTranscriptorTest.class.getClassLoader().getResource("Hand" + handNumber + ".png").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ScreenCropper cropper = new ScreenCropper(image);
		PotTranscriptor transcriptor = new PotTranscriptor(cropper);
		Assert.assertEquals(expected[0], transcriptor.getPotSize());
	}

}