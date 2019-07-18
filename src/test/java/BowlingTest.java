import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BowlingTest {
    Bowling bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new Bowling();
        bowlingGame.roll(10);
        bowlingGame.roll(8);
        bowlingGame.roll(2);
        bowlingGame.roll(3);
        bowlingGame.roll(5);
        bowlingGame.roll(10);
        bowlingGame.roll(8);
        bowlingGame.roll(1);
        bowlingGame.roll(1);
        bowlingGame.roll(4);
        bowlingGame.roll(4);
        bowlingGame.roll(10);
        bowlingGame.roll(9);
        bowlingGame.roll(1);
        bowlingGame.roll(7);
        bowlingGame.roll(2);
        bowlingGame.roll(6);
        bowlingGame.roll(3);
        bowlingGame.roll(10);
        bowlingGame.roll(9);

    }
    @Test
    public void testStrikeBonus() {

        int bonusScore = bowlingGame.strikeBonus(1);
        assertThat(bonusScore, is(10));
    }
    @Test
    public void testSpareBonus() {

        int bonusScore = bowlingGame.spareBonus(2);
        assertThat(bonusScore, is(3));
    }


}