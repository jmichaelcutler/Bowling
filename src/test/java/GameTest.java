import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class GameTest {
    private String game1;
    private String game2;
    private String game3;
    private String game4;
    private String game5;
    private String game6;
    private BowlingGameScorer scorer;

    @Before
    public void setup() {
        game1 = "X|X|X|X|X|X|X|X|X|X||XX";
        game2 = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||";
        game3 = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5";
        game4 = "X|7/|9-|X|-8|8/|-6|X|X|X||81";
        game5 = "--|--|--|--|--|--|--|--|--|--||";
        game6 = "X|7-||";
        scorer = new BowlingGameScorer();
    }

    @Test
    public void score() {
        Assert.assertEquals(scorer.score(game1), 300);
        Assert.assertEquals(scorer.score(game2), 90);
        Assert.assertEquals(scorer.score(game3), 150);
        Assert.assertEquals(scorer.score(game4), 167);
        Assert.assertEquals(scorer.score(game5), 0);
    }

    @Test(expected = Exception.class)
    public void badScore() {
        scorer.score(game6);
    }

}
