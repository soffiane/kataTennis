package tennis;

import java.util.Random;

import static tennis.Score.calculate;

public class Game {
    private final Player playerOne;
    private final Player playerTwo;

    public Game(String playerOneName, String playerTwoName) {
        this.playerOne = new Player(playerOneName,0,0);
        this.playerTwo = new Player(playerTwoName,0,0);
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void start() {
        String result;
        do {
            System.out.println("Point " + (this.scoreRandomPoint() == 1 ? playerOne.getPlayerName() : playerTwo.getPlayerName()));
            result = getScore();
            System.out.println(result);
        } while (!result.contains("match"));
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
        if (playerId == 1) {
            playerOne.winBall();
        } else {
            playerTwo.winBall();
        }
    }

    public String getScore() {
        return calculate(playerOne, playerTwo);
    }
}
