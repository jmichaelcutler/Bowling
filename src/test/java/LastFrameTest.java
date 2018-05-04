import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LastFrameTest {
    private LastFrame frame1;
    private LastFrame frame2;
    private LastFrame frame3;
    private LastFrame frame4;
    private LastFrame frame5;
    private LastFrame frame6;
    private LastFrame frame7;
    private LastFrame frame8;
    private LastFrame frame9;
    private LastFrame frame10;
    private LastFrame frame11;
    private LastFrame strikeBonus;
    private LastFrame spareBonus;
    private LastFrame frameBonus;
    private LastFrame frameTemplate;

    @Before
    public void setup() {
        frame1 = new LastFrame(10, 10, 10);
        frame2 = new LastFrame(10, 10, 7);
        frame3 = new LastFrame(10, 7, 3);
        frame4 = new LastFrame(10, 7, 2);
        frame5 = new LastFrame(7, 3, 10);
        frame6 = new LastFrame(7, 3, 6);
        frame7 = new LastFrame(10, 10, 0);
        frame8 = new LastFrame(10, 0, 10);
        frame9 = new LastFrame(10, 0, 7);
        frame10 = new LastFrame(10, 0, 0);
        frame11 = new LastFrame(5, 5, 0);
        strikeBonus = new LastFrame(10, 0);
        spareBonus = new LastFrame(4, 6);
        frameBonus = new LastFrame(3, 2);
        frameTemplate = new LastFrame();
    }

    @Test
    public void isLastFrame() {
        Assert.assertTrue(frame1.isLastFrame());
    }

    @Test
    public void getScore() {
        Assert.assertEquals(frame1.getScore(), 30);
        Assert.assertEquals(frame2.getScore(), 27);
        Assert.assertEquals(frame3.getScore(), 20);
        Assert.assertEquals(frame4.getScore(), 19);
        Assert.assertEquals(frame5.getScore(), 20);
        Assert.assertEquals(frame6.getScore(), 16);
        Assert.assertEquals(frame7.getScore(), 20);
        Assert.assertEquals(frame8.getScore(), 20);
        Assert.assertEquals(frame9.getScore(), 17);
        Assert.assertEquals(frame10.getScore(), 10);
        Assert.assertEquals(frame11.getScore(), 10);
        Assert.assertEquals(frameTemplate.getScore(), 0);
    }

    @Test
    public void parseStrikeFrame() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        Assert.assertEquals(testFrame, new LastFrame(10, 0));
    }

    @Test
    public void parseSpareFrame() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("4/");
        Assert.assertEquals(testFrame, new LastFrame(4, 6));
    }

    @Test
    public void parseZeroSpareFrame() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("-/");
        Assert.assertEquals(testFrame, new LastFrame(0, 10));
    }

    @Test
    public void parseBonusBallStrikeStrikeStrike() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("XX");
        Assert.assertEquals(testFrame, frame1);
    }

    @Test(expected = Exception.class)
    public void parseBonusBallStrikeSingleBonus() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("X");
    }

    @Test
    public void parseBonusBallStrikeStrikeInt() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("X7");
        Assert.assertEquals(testFrame, frame2);
    }

    @Test
    public void parseBonusBallStrikeIntSpare() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("7/");
        Assert.assertEquals(testFrame, frame3);
    }

    @Test
    public void parseBonusBallStrikeIntInt() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("72");
        Assert.assertEquals(testFrame, frame4);
    }

    @Test
    public void parseBonusBallIntSpareStrike() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("7/");
        testFrame.parseBonusBall("X");
        Assert.assertEquals(testFrame, frame5);
    }

    @Test
    public void parseBonusBallIntSpareInt() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("7/");
        testFrame.parseBonusBall("6");
        Assert.assertEquals(testFrame, frame6);
    }

    @Test
    public void parseBonusBallStrikeStrikeZero() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("X-");
        Assert.assertEquals(testFrame, frame7);
    }

    @Test
    public void parseBonusBallStrikeZeroSpare() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("-/");
        Assert.assertEquals(testFrame, frame8);
    }

    @Test
    public void parseBonusBallStrikeZeroInt() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("-7");
        Assert.assertEquals(testFrame, frame9);
    }

    @Test
    public void parseBonusBallStrikeZeroZero() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("X");
        testFrame.parseBonusBall("--");
        Assert.assertEquals(testFrame, frame10);
    }

    @Test
    public void parseBonusBallIntSpareZero() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("5/");
        testFrame.parseBonusBall("-");
        Assert.assertEquals(testFrame, frame11);
    }

    @Test
    public void parseBonusBallIntIntNoBonus() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("32");
        Assert.assertEquals(testFrame, frameBonus);
        Assert.assertEquals(testFrame, new LastFrame(3,2,-1));
    }

    @Test(expected = Exception.class)
    public void badParseBonusSpare() {
        LastFrame testFrame = frameTemplate;
        testFrame.parseFrame("5/");
        testFrame.parseBonusBall("XX");
    }
}
