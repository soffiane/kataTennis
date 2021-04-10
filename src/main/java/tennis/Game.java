package tennis;

import java.util.Random;

public class Game {
    private final Integer[] rawScore;
    private final String playerOneName;
    private final String playerTwoName;
    private final TennisGamePrinter tennisGamePrinter;

    public Game(TennisGamePrinter tennisGamePrinter, String playerOneName, String playerTwoName) {
        this.tennisGamePrinter = tennisGamePrinter;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.rawScore = new Integer[2];
        this.rawScore[0] = 0;
        this.rawScore[1] = 0;
    }

    public void start() {
        do {
            tennisGamePrinter.print("Point " + (this.scoreRandomPoint() == 1 ? playerOneName : playerTwoName));
            tennisGamePrinter.print(this.getScore());
        } while (!getScore().startsWith("Win"));
    }

    public Integer scoreRandomPoint() {
        Integer randomUserId = randomPointWinner();
        scorePoint(randomUserId);
        return randomUserId;
    }

    private Integer randomPointWinner() {
        return new Random().nextInt(2) + 1;
    }

    public void scorePoint(Integer playerId) {
        rawScore[playerId - 1] = rawScore[playerId - 1] + 1;
    }

    public String getScore() {
        return Score.calculate(rawScore[0], rawScore[1], playerOneName, playerTwoName);
    }
}
