import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tennis.Game;
import tennis.Player;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

	Player victor;
	Player sarah;
	Game game;

	@BeforeEach
	public void beforeGameTest() {
		game = new Game("Victor", "Sarah");
		victor = game.getPlayerOne();
		sarah = game.getPlayerTwo();
	}

	@Test
	public void loveShouldBeDescriptionForScore0() {
		assertThat(game.getScore()).isEqualTo("Love - All");
	}

	@Test
	public void fifteenShouldBeDescriptionForScore1() {
		sarah.winBall();
		assertThat(game.getScore()).contains("Victor Love - Sarah Fifteen");
	}

	@Test
	public void thirtyShouldBeDescriptionForScore2() {
		victor.winBall();
		victor.winBall();
		sarah.winBall();
		assertThat(game.getScore()).contains("Victor Thirty - Sarah Fifteen");
	}

	@Test
	public void fortyShouldBeDescriptionForScore3() {
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			victor.winBall();
		});
		assertThat(game.getScore()).contains("Victor Forty - Sarah Love");
	}

	@Test
	public void advantageShouldBeDescriptionWhenLeastThreePointsHaveNeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
		IntStream.rangeClosed(1, 3).forEach((Integer) -> {
			victor.winBall();
		});
		IntStream.rangeClosed(1, 4).forEach((Integer) -> {
			sarah.winBall();
		});
		assertThat(game.getScore()).isEqualTo("Advantage Sarah");
	}

	@Test
	public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
		for (int index = 1; index <= 3; index++) {
			victor.winBall();
		}
		for (int index = 1; index <= 3; index++) {
			sarah.winBall();
		}
		assertThat(game.getScore()).isEqualTo("Deuce");
		victor.winBall();
		assertThat(game.getScore()).isEqualTo("Advantage Victor");
		sarah.winBall();
		assertThat(game.getScore()).isEqualTo("Deuce");
	}

	@Test
	public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
		for (int index = 1; index <= 4; index++) {
			victor.winBall();
		}
		for (int index = 1; index <= 3; index++) {
			sarah.winBall();
		}
		assertThat(game.getScore()).isEqualTo("Advantage Victor");
		victor.winBall();
		assertThat(game.getScore()).isEqualTo("Victor wins the game");
	}
}
