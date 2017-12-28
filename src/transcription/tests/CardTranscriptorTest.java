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
import model.Card;
import transcription.CardTranscriptor;

@RunWith(Parameterized.class)
public class CardTranscriptorTest {
	
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 1, new Object[] {Card.FOURs, Card.Jd, Card.FIVEd, Card.TENd, Card.Ah, null, null} },
                 { 2, new Object[] {Card.FOURs, Card.Jd, Card.FIVEd, Card.TENd, Card.Ah, null, null} },
                 { 3, new Object[] {Card.Qd, Card.Qc, null, null, null, null, null} },
                 { 4, new Object[] {Card.Kh, Card.EIGHTc, null, null, null, null, null} },
                 { 5, new Object[] {Card.THREEd, Card.SEVENc, null, null, null, null, null} },
                 { 6, new Object[] {Card.THREEd, Card.SEVENc, Card.EIGHTs, Card.SEVENh, Card.FOURs, null, null} },
                 { 7, new Object[] {Card.TENd, Card.Kd, null, null, null, null, null} },
                 { 8, new Object[] {Card.NINEc, Card.Ks, null, null, null, null, null} },
                 { 9, new Object[] {Card.Ac, Card.TWOs, null, null, null, null, null} },
                 { 10, new Object[] {Card.Qs, Card.Ac, null, null, null, null, null} },
                 { 11, new Object[] {Card.Qs, Card.Ac, Card.Kh, Card.Kc, Card.SEVENh, null, null} },
                 { 12, new Object[] {Card.NINEc, Card.Ks, Card.TWOc, Card.TWOd, Card.TWOs, Card.NINEd, null} },
                 { 13, new Object[] {Card.Ks, Card.TWOs, null, null, null, null, null} },
                 { 14, new Object[] {Card.FOURc, Card.EIGHTh, null, null, null, null, null} },
                 { 15, new Object[] {Card.TWOd, Card.Jd, null, null, null, null, null} },
                 { 16, new Object[] {Card.SIXc, Card.Ah, null, null, null, null, null} },
                 { 17, new Object[] {Card.As, Card.EIGHTd, null, null, null, null, null} },
                 { 18, new Object[] {Card.THREEc, Card.TWOd, null, null, null, null, null} },
                 { 19, new Object[] {Card.TENh, Card.NINEc, null, null, null, null, null} },
                 { 20, new Object[] {Card.Qc, Card.FIVEh, null, null, null, null, null} }
           });
    }

    private int handNumber;

    private Object[] expected;
    
    public CardTranscriptorTest(int input, Object[] expected) {
        this.handNumber= input;
        this.expected= expected;
    }

	@Test
	public void test() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(CardTranscriptorTest.class.getClassLoader().getResource("Hand" + handNumber + ".png").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ScreenCropper cropper = new ScreenCropper(image);
		CardTranscriptor transcriptor = new CardTranscriptor(cropper);
		Assert.assertEquals(expected[2], transcriptor.getMiddle1Card());
		Assert.assertEquals(expected[3], transcriptor.getMiddle2Card());
		Assert.assertEquals(expected[4], transcriptor.getMiddle3Card());
		Assert.assertEquals(expected[5], transcriptor.getMiddle4Card());
		Assert.assertEquals(expected[6], transcriptor.getMiddle5Card());
		Assert.assertEquals(expected[0], transcriptor.getLeftPlayerCard());
		Assert.assertEquals(expected[1], transcriptor.getRightPlayerCard());
	}

}