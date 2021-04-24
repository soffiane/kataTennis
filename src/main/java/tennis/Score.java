package tennis;

import java.util.Objects;

public class Score {
    private static final String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private static final String WIN_GAME = "#playerName wins the game";
    private static final String WIN_SET = "#playerName wins the match";
    private static final String ADVANTAGE = "Advantage #playerName";
    private static final String DEUCE = "Deuce";
    private static final String ALL = "All";
    private static final String PLAYER_NAME = "#playerName";

    private Score(){

    }

    public static String calculate(Player playerOne, Player playerTwo) {
        if (Objects.equals(playerOne.getGameScore(), playerTwo.getGameScore())) {
            return deuce(playerOne.getGameScore());
        }
        if (playerOne.getGameScore() > 3 || playerTwo.getGameScore() > 3) {
            return winOrTie(playerOne, playerTwo);
        }
        return gameScore(playerOne, playerTwo);
    }

    private static String deuce(Integer playerOnePoint) {
        if (playerOnePoint < 3) {
            return scores[playerOnePoint] + " - " + ALL;
        }
        return DEUCE;
    }

    private static String winOrTie(Player playerOne, Player playerTwo) {
        return Math.abs(playerOne.getGameScore() - playerTwo.getGameScore()) >= 2 ?
                winGameOrMatch(playerOne, playerTwo) :
                tie(playerOne, playerTwo);
    }

    private static String winGameOrMatch(Player playerOne, Player playerTwo) {
        String score = "";
        if (playerOne.getGameScore() > playerTwo.getGameScore() && playerOne.getTennisSetScore() < 5) {
            playerOne.winGame();
            playerOne.resetScore();
            playerTwo.resetScore();
            score = WIN_GAME.replace(PLAYER_NAME, playerOne.getPlayerName());
        } else if (playerOne.getGameScore() > playerTwo.getGameScore() && playerOne.getTennisSetScore() == 5) {
            playerOne.winGame();
            playerOne.resetScore();
            playerTwo.resetScore();
            System.out.printf("Final Score %n%d - %d%n%n", playerOne.getTennisSetScore(), playerTwo.getTennisSetScore());
            score = WIN_SET.replace(PLAYER_NAME, playerOne.getPlayerName());
        } else if (playerOne.getGameScore() < playerTwo.getGameScore() && playerTwo.getTennisSetScore() < 5) {
            playerTwo.winGame();
            playerOne.resetScore();
            playerTwo.resetScore();
            score = WIN_GAME.replace(PLAYER_NAME, playerTwo.getPlayerName());
        } else if (playerOne.getGameScore() < playerTwo.getGameScore() && playerTwo.getTennisSetScore() == 5) {
            playerTwo.winGame();
            playerOne.resetScore();
            playerTwo.resetScore();
            System.out.printf("Final Score %n%d - %d%n%n", playerOne.getTennisSetScore(), playerTwo.getTennisSetScore());
            score = WIN_SET.replace(PLAYER_NAME, playerTwo.getPlayerName());
        }
        return score;
    }

    private static String tie(Player playerOne, Player playerTwo) {
        return playerOne.getGameScore() > playerTwo.getGameScore() ?
                ADVANTAGE.replace(PLAYER_NAME, playerOne.getPlayerName()) :
                ADVANTAGE.replace(PLAYER_NAME, playerTwo.getPlayerName());
    }

    private static String gameScore(Player playerOne, Player playerTwo) {
        return String.format("Game Score %n%d - %d%n%s %s - %s %s%n", playerOne.getTennisSetScore(), playerTwo.getTennisSetScore(), playerOne.getPlayerName(), scores[playerOne.getGameScore()], playerTwo.getPlayerName(), scores[playerTwo.getGameScore()]);
    }
}
