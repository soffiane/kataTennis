package tennis;

import java.util.Random;

import static tennis.Score.calculate;

public class Game {
    private final Player playerOne;
    private final Player playerTwo;
    private final TennisGamePrinter tennisGamePrinter;

    public Game(TennisGamePrinter tennisGamePrinter, String playerOneName, String playerTwoName) {
        this.tennisGamePrinter = tennisGamePrinter;
        this.playerOne = new Player(playerOneName,0,0);
        this.playerTwo = new Player(playerTwoName,0,0);
    }

    public void start() {
        String result = "";
        do {
            tennisGamePrinter.print("Point " + (this.scoreRandomPoint() == 1 ? playerOne.getPlayerName() : playerTwo.getPlayerName()));
            result = getScore();
            tennisGamePrinter.print(result);
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
        if(playerId == 1){
            playerOne.setGameScore(playerOne.getGameScore()+1);
        } else {
            playerTwo.setGameScore(playerTwo.getGameScore()+1);
        }
    }

    public String getScore() {
        return calculate(playerOne, playerTwo);
    }
}
