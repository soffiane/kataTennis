package tennis;

import java.util.Scanner;

public class TennisGame {
    public static void main (String[] args){
        System.out.println("  _______               _     ");
        System.out.println(" |__   __|             (_)    ");
        System.out.println("    | | ___ _ __  _ __  _ ___ ");
        System.out.println("    | |/ _ \\ '_ \\| '_ \\| / __|");
        System.out.println("    | |  __/ | | | | | | \\__ | ");
        System.out.println("    |_|\\___|_| |_|_| |_|_|___/");

        System.out.print("Please enter player one name: ");
        String playerOneName = new Scanner(System.in).nextLine();
        System.out.print("Please enter player two name: ");
        String playerTwoName = new Scanner(System.in).nextLine();

        Game game = new Game(playerOneName, playerTwoName);
        game.start();
        System.out.print("\nBye!\n\n");
    }
}
