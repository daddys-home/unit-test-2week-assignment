import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.Times;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

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
        //bowlingGame.roll(1);
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
    public void 스코어리턴값에대한MOCKUP테스트(){
        Bowling bowling = mock(Bowling.class);
        when(bowling.score()).thenReturn(10);
        assertThat(bowling.score(), Matchers.is(10));
    }
    @Test
    public void 스코어를실행시IsStrike가실행도었는지확인하는_테스트(){
        Bowling bowling = mock(Bowling.class);
        when((bowling.isStrike(anyInt()))).thenReturn(true);
        bowling.score();
        verify(bowling,never()).isStrike(anyInt());
    }


}