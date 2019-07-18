import lombok.Data;

@Data
public class Bowling {
    private int[] rolls;
    private int currentRoll;

    public Bowling() {
        this.rolls = new int[21];
        this.currentRoll = 1;
    }

    public void roll(int point) {
        rolls[currentRoll++] = point;
    }

    public int score() {
        int score = 0;
        int frame = 0;

        for (int gameCount = 0; gameCount < 10; gameCount++) {
            if (isStrike(frame)) {
                score += 10 + strikeBonus(frame);
                frame++;
            } else if (isSpare(frame)) {
                score += 10 + spareBonus(frame);
                frame += 2;
            } else {
                score += sumOfRolls(frame);
                frame += 2;
            }
        }

        return score;
    }

    private boolean isStrike(int frame) {
        return rolls[frame] == 10;
    }

    private boolean isSpare(int frame) {
        return sumOfRolls(frame) == 10;
    }

    public int strikeBonus(int frame) {
        return sumOfRolls(frame+1);
    }

    public int spareBonus(int frame) { return rolls[frame+2]; }

    public int sumOfRolls(int frame) {
        if(frame>=20)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        return rolls[frame] + rolls[frame+1];
    }
}
