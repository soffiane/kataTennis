import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tennis.Game;
import tennis.Player;

import java.util.stream.IntStream;

public class GameTest {

    Player victor;
    Player sarah;
    Game game;

    @BeforeAll
    public void beforeGameTest() {
        game = new Game("Victor", "Sarah");
        victor = game.getPlayerOne();
        sarah = game.getPlayerTwo();
    }

    @Test
    public void loveShouldBeDescriptionForScore0() {
        Assertions.assertEquals(game.getScore(), "love, love");
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        sarah.winBall();
        Assertions.assertEquals(game.getScore(), "love, fifteen");
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        victor.winBall();
        victor.winBall();
        sarah.winBall();
        Assertions.assertEquals(game.getScore(), "thirty, fifteen");
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winBall();
        });
        Assertions.assertEquals(game.getScore(), "forty, love");
    }

    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winBall();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            sarah.winBall();
        });
        Assertions.assertEquals(game.getScore(), "advantage Sarah");
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        for(int index = 1; index <= 3; index++) {
            victor.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            sarah.winBall();
        }
        Assertions.assertEquals(game.getScore(), "deuce");
        victor.winBall();
        Assertions.assertNotEquals(game.getScore(), "deuce");
        sarah.winBall();
        Assertions.assertEquals(game.getScore(), "deuce");
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        for(int index = 1; index <= 4; index++) {
            victor.winBall();
        }
        for(int index = 1; index <= 3; index++) {
            sarah.winBall();
        }
        Assertions.assertNotEquals(game.getScore(), "Victor won");
        victor.winBall();
        Assertions.assertEquals(game.getScore(), "Victor won");
        Assertions.assertNotEquals(game.getScore(), "Sarah won");
    }
}
