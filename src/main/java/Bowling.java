public class Bowling {
    int[] rolls;
    int currentRoll;

    public Bowling() {
        this.rolls = new int[21];
    }

    public void roll(int point) {
        rolls[currentRoll++] = point;
    }

    public int score() {
        int score = 0;
        int frame = 0;

        for (int ganeCount = 0; ganeCount < 10; ganeCount++) {
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

    private int strikeBonus(int frame) {
        return sumOfRolls(frame+1);
    }

    private int spareBonus(int frame) {
        return rolls[frame+2];
    }

    private int sumOfRolls(int frame) {
        return rolls[frame] + rolls[frame+1];
    }
}
