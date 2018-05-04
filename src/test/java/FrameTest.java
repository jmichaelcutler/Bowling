import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FrameTest {
    private Frame strikeFrame;
    private Frame spareFrame;
    private Frame frame;
    private Frame zeroSpare;
    private Frame zeroFrame1;
    private Frame zeroFrame2;
    private Frame lastFrame1;
    private Frame lastFrame2 ;
    private Frame lastFrame3 ;
    private Frame lastFrame4;
    private Frame lastFrame5;
    private Frame lastFrame7;
    private Frame lastFrame8;
    private Frame lastFrame9;
    private Frame lastFrame10;
    private Frame lastFrame11;
    private Frame lastFrame12;
    private Frame frameTemplate;

    //Strings for testing text parsing
    private String strike;
    private String nonzeroSpare;
    private String zeroSpareString;
    private String zeroIntString;
    private String intZeroString;
    private String badStrike1;
    private String badSpare;
    private String badStrike2;
    private String allNumbers;


    @Before
    public void setup() {
        strikeFrame = new Frame(10, 0);
        spareFrame = new Frame(5, 5);
        frame = new Frame(6,2);
        zeroSpare = new Frame(0, 10);
        zeroFrame1 = new Frame(5, 0);
        zeroFrame2 = new Frame(0, 4);
        lastFrame1 = new LastFrame(10, 10, 10);
        lastFrame2 = new LastFrame(10, 10, 7);
        lastFrame3 = new LastFrame(10, 7, 10);
        lastFrame4 = new LastFrame(10, 7, 4);
        lastFrame5 = new LastFrame(6, 4, 10);
        lastFrame7 = new LastFrame(6, 4, 8);
        lastFrame8 = new LastFrame(10, 0, 10);
        lastFrame9 = new LastFrame(10, 0, 4);
        lastFrame10 = new LastFrame(10, 0, 0);
        lastFrame11 = new LastFrame(0, 10, 4);
        lastFrame12 = new LastFrame(4, 2, 0);
        frameTemplate = new Frame();
        nonzeroSpare = "5/";
        strike = "X";
        zeroSpareString = "-/";
        zeroIntString = "-4";
        intZeroString = "5-";
        badStrike1 = "4X";
        badSpare = "/5";
        badStrike2 = "-X";
        allNumbers = "62";
    }

    @Test
    public void getScore() {
        Assert.assertEquals(strikeFrame.getScore(), 10);
        Assert.assertEquals(spareFrame.getScore(), 10);
        Assert.assertEquals(frame.getScore(), 8);
        Assert.assertEquals(zeroFrame1.getScore(), 5);
        Assert.assertEquals(zeroSpare.getScore(), 10);
    }

    @Test
    public void isStrike() {
        Assert.assertTrue(strikeFrame.isStrike());
        Assert.assertFalse(spareFrame.isStrike());
        Assert.assertFalse(frame.isStrike());
        Assert.assertFalse(zeroFrame1.isStrike());
        Assert.assertFalse(zeroFrame2.isStrike());
        Assert.assertFalse(zeroSpare.isStrike());
    }

    @Test
    public void isSpare() {
        Assert.assertFalse(strikeFrame.isSpare());
        Assert.assertTrue(spareFrame.isSpare());
        Assert.assertFalse(frame.isSpare());
        Assert.assertFalse(zeroFrame1.isSpare());
        Assert.assertFalse(zeroFrame2.isSpare());
        Assert.assertTrue(zeroSpare.isSpare());
    }

    @Test
    public void getScoreWithBonus() {
        Assert.assertEquals(strikeFrame.getScore(strikeFrame, strikeFrame), 30);
        Assert.assertEquals(strikeFrame.getScore(strikeFrame, spareFrame), 25);
        Assert.assertEquals(strikeFrame.getScore(strikeFrame, frame), 26);
        Assert.assertEquals(strikeFrame.getScore(spareFrame, strikeFrame), 20);
        Assert.assertEquals(strikeFrame.getScore(spareFrame, spareFrame), 20);
        Assert.assertEquals(strikeFrame.getScore(spareFrame, frame), 20);
        Assert.assertEquals(strikeFrame.getScore(frame, strikeFrame), 18);
        Assert.assertEquals(strikeFrame.getScore(frame, spareFrame), 18);
        Assert.assertEquals(strikeFrame.getScore(frame, frame), 18);
        Assert.assertEquals(spareFrame.getScore(strikeFrame, strikeFrame), 20);
        Assert.assertEquals(spareFrame.getScore(strikeFrame, spareFrame), 20);
        Assert.assertEquals(spareFrame.getScore(strikeFrame, frame), 20);
        Assert.assertEquals(spareFrame.getScore(spareFrame, strikeFrame), 15);
        Assert.assertEquals(spareFrame.getScore(spareFrame, spareFrame), 15);
        Assert.assertEquals(spareFrame.getScore(spareFrame, frame), 15);
        Assert.assertEquals(spareFrame.getScore(frame, strikeFrame), 16);
        Assert.assertEquals(spareFrame.getScore(frame, spareFrame), 16);
        Assert.assertEquals(spareFrame.getScore(frame, frame), 16);
    }

    @Test
    public void penultimateStrikeFrameTest() {
        Assert.assertEquals(strikeFrame.getScore(lastFrame1), 30);
        Assert.assertEquals(strikeFrame.getScore(lastFrame2), 30);
        Assert.assertEquals(strikeFrame.getScore(lastFrame3), 27);
        Assert.assertEquals(strikeFrame.getScore(lastFrame4), 27);
        Assert.assertEquals(strikeFrame.getScore(lastFrame5), 20);
        Assert.assertEquals(strikeFrame.getScore(lastFrame7), 20);
        Assert.assertEquals(strikeFrame.getScore(lastFrame8), 20);
        Assert.assertEquals(strikeFrame.getScore(lastFrame9), 20);
        Assert.assertEquals(strikeFrame.getScore(lastFrame10), 20);
        Assert.assertEquals(strikeFrame.getScore(lastFrame11), 20);
        Assert.assertEquals(strikeFrame.getScore(lastFrame12), 16);
    }

    @Test
    public void penultimateSpareFrameTest() {
        Assert.assertEquals(spareFrame.getScore(lastFrame1), 20);
        Assert.assertEquals(spareFrame.getScore(lastFrame2), 20);
        Assert.assertEquals(spareFrame.getScore(lastFrame3), 20);
        Assert.assertEquals(spareFrame.getScore(lastFrame4), 20);
        Assert.assertEquals(spareFrame.getScore(lastFrame5), 16);
        Assert.assertEquals(spareFrame.getScore(lastFrame7), 16);
        Assert.assertEquals(spareFrame.getScore(lastFrame8), 20);
        Assert.assertEquals(spareFrame.getScore(lastFrame9), 20);
        Assert.assertEquals(spareFrame.getScore(lastFrame10), 20);
        Assert.assertEquals(spareFrame.getScore(lastFrame11), 10);
        Assert.assertEquals(spareFrame.getScore(lastFrame12), 14);
    }

    @Test
    public void penultimateFrameTest() {
        Assert.assertEquals(frame.getScore(lastFrame1), 8);
        Assert.assertEquals(frame.getScore(lastFrame2), 8);
        Assert.assertEquals(frame.getScore(lastFrame3), 8);
        Assert.assertEquals(frame.getScore(lastFrame4), 8);
        Assert.assertEquals(frame.getScore(lastFrame5), 8);
        Assert.assertEquals(frame.getScore(lastFrame7), 8);
        Assert.assertEquals(frame.getScore(lastFrame8), 8);
        Assert.assertEquals(frame.getScore(lastFrame9), 8);
        Assert.assertEquals(frame.getScore(lastFrame10), 8);
        Assert.assertEquals(frame.getScore(lastFrame11), 8);
        Assert.assertEquals(frame.getScore(lastFrame12), 8);
    }

    @Test
    public void isLastFrame() {
        Assert.assertFalse(spareFrame.isLastFrame());
        Assert.assertFalse(strikeFrame.isLastFrame());
        Assert.assertFalse(frame.isLastFrame());
    }

    @Test
    public void parseFirstBallStrike() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(strike);
        Assert.assertTrue(testFrame.isStrike());
    }

    @Test
    public void parseZeroSpare() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(zeroSpareString);
        Assert.assertTrue(testFrame.isSpare());
        Assert.assertEquals(testFrame, zeroSpare);
    }

    @Test
    public void parseNonzeroSpare() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(nonzeroSpare);
        Assert.assertTrue(testFrame.isSpare());
        Assert.assertEquals(testFrame, spareFrame);
    }

    @Test
    public void parseNonzeroFrame() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(allNumbers);
        Assert.assertFalse(testFrame.isSpare());
        Assert.assertEquals(testFrame, frame);
    }

    @Test
    public void parseZeroIntFrame() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(zeroIntString);
        Assert.assertEquals(testFrame, zeroFrame2);
    }

    @Test
    public void parseIntZeroFrame() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(intZeroString);
        Assert.assertEquals(testFrame, zeroFrame1);
    }

    @Test(expected = Exception.class)
    public void testBadInput() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(badStrike1);
    }

    @Test(expected = Exception.class)
    public void testBadInput2() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(badStrike2);
    }

    @Test(expected = Exception.class)
    public void testBadInput3() {
        Frame testFrame = frameTemplate;
        testFrame.parseFrame(badSpare);
    }
}
