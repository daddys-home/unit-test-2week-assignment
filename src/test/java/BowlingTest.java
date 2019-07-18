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


    @Test
    public void isStrike_스트라익일때_True를_반환하는지_확인하는_테스트(){

        assertThat(bowlingGame.isStrike(1),is(true));

    }

    @Test
    public void isStrike_스트라이크가_아닐때_False를_반환하는지_확인하는_테스트(){

        assertThat(bowlingGame.isStrike(2),is(false));
        assertThat(bowlingGame.isStrike(3),is(false));
        assertThat(bowlingGame.isStrike(4),is(false));

    }

    @Test
    public void isSpare_스페어일때_True를_반환하는지_확인하는_테스트(){


        assertThat(bowlingGame.isSpare(2),is(true));
        assertThat(bowlingGame.isSpare(13),is(true));

    }



}