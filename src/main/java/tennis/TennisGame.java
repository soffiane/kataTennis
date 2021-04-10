package tennis;

import java.util.Scanner;

public class TennisGame {
    public static void main (String[] args){
        TennisGamePrinter ui = new TennisGamePrinter();
        ui.prompt();

        ui.print("Please enter player one name: ");
        String playerOneName = new Scanner(System.in).nextLine();
        ui.print("Please enter player two name: ");
        String playerTwoName = new Scanner(System.in).nextLine();

        Game game = new Game(ui, playerOneName, playerTwoName);
        game.start();
        ui.exit();
    }
}
