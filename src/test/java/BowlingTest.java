import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.Times;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
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
        bowlingGame.roll(1);

    }

    @Test
    public void roll_셋업한_값이_rolls배열에_제대로_들어있는지_테스트()
    {
        assertThat(bowlingGame.getRolls()[1],is(8));
        assertThat(bowlingGame.getRolls()[2],is(2));
        assertThat(bowlingGame.getRolls()[20],is(1));

    }


    @Test
    public void sumOfRolls_frame과_그_다음_값의_합을_잘_반환하는지_테스트()
    {
        assertThat(bowlingGame.sumOfRolls(1),is(10));
        assertThat(bowlingGame.sumOfRolls(2),is(5));
        assertThat(bowlingGame.sumOfRolls(19),is(10));

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void sumOfRolls_frame의_값이_20을_넘으면_BoundException()
    {
        bowlingGame.sumOfRolls(27);
        assertThat(bowlingGame.sumOfRolls(20),is(19));
        doThrow(new ArrayIndexOutOfBoundsException()).when(bowlingGame).sumOfRolls(30);


    }

    @Test
    public void testStrikeBonus() {

        int bonusScore = bowlingGame.strikeBonus(1);
        assertThat(bonusScore, is(5));
    }
    @Test
    public void testSpareBonus() {

        int bonusScore = bowlingGame.spareBonus(2);
        assertThat(bonusScore, is(5));
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


    @Test
    public void isStrike_스트라익일때_True를_반환하는지_확인하는_테스트(){

        assertThat(bowlingGame.isStrike(18),is(true));

    }

    @Test
    public void isStrike_스트라이크가_아닐때_False를_반환하는지_확인하는_테스트(){

        assertThat(bowlingGame.isStrike(2),is(false));
        assertThat(bowlingGame.isStrike(3),is(false));
        assertThat(bowlingGame.isStrike(4),is(false));

    }

    @Test
    public void isSpare_스페어일때_True를_반환하는지_확인하는_테스트(){


        assertThat(bowlingGame.isSpare(1),is(true));
        assertThat(bowlingGame.isSpare(12),is(true));

    }

    @Test
    public void isSpare_스페어가_아닐때_False를_반환하는지_확인하는_테스트(){

        assertThat(bowlingGame.isSpare(2),is(false));
        assertThat(bowlingGame.isSpare(3),is(false));
        assertThat(bowlingGame.isSpare(5),is(false));
        assertThat(bowlingGame.isSpare(7),is(false));


    }



}