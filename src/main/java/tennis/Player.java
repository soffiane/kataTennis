package tennis;

public class Player {

    private String playerName;
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

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public int getTennisSetScore() {
        return tennisSetScore;
    }

    public void winGame() {
        this.tennisSetScore++;
    }

    public void resetScore() {
        this.gameScore = 0;
    }

    public void scorePoint() {
        this.gameScore++;
    }
}
