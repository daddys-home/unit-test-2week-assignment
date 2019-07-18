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
    public void roll_셋업한_값이_rolls배열에_제대로_들어있는지_테스트()
    {
        assertThat(bowlingGame.getRolls()[1],is(10));
        assertThat(bowlingGame.getRolls()[2],is(8));
        assertThat(bowlingGame.getRolls()[20],is(9));

    }


    @Test
    public void sumOfRolls_frame과_그_다음_값의_합을_잘_반환하는지_테스트()
    {
        assertThat(bowlingGame.sumOfRolls(1),is(18));
        assertThat(bowlingGame.sumOfRolls(2),is(10));
        assertThat(bowlingGame.sumOfRolls(19),is(19));

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