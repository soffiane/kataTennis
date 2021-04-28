package tennis;

public class Player {

    private final String playerName;
    private int gameScore;
    private int tennisSetScore;


    public Player(String playerName, int gameScore, int tennisSetScore) {
        this.playerName = playerName;
        this.gameScore = gameScore;
        this.tennisSetScore = tennisSetScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getGameScore() {
        return gameScore;
    }

    public int getTennisSetScore() {
        return tennisSetScore;
    }

    public void winGame() {
        this.tennisSetScore++;
    }

    public void winBall() {
        this.gameScore++;
    }

    public void resetScore() {
        this.gameScore = 0;
    }

}
