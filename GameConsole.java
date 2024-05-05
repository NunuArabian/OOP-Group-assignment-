import java.util.Arrays;
import java.util.Scanner;

public class GameConsole {

    private Game risk;

    public void play() {
        Player[] players = new Player[Game.NUMBER_OF_PLAYERS];
        int[] diceNumbers = new int[Game.NUMBER_OF_PLAYERS];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<players.length; i++) {
            System.out.println("Hello player " + i + " please enter your name");
            players[i] = new Player(sc.nextLine());
            System.out.println("Roll the dice to determine the order of the game");
            sc.nextLine();
            players[i].rollDice();
        }
        Arrays.sort(players);
        for(int i = 0; i<players.length; i++) {
            System.out.println("Players order:");
            System.out.println(players[i].getName());
        }

        risk = new Game(players);

        for(int i = 0; i<players.length; i++) {
            System.out.println(players[i] + " place your armies.");
            while(sc.hasNext()) {
                String input = sc.next();
                try {
                    if (sc.hasNextInt()) {
                        int armyCount = sc.nextInt();
                        Territory tr = new Territory(input);
                        players[i].addTerritory(tr);
                        if (!players[i].addArmyToTerritory(tr, armyCount))
                        {
                            System.out.println(tr.getName() + " is already claimed");
                            continue;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
            System.out.println(players[i] + " has finished placing armies.");
        }

        risk.turnCounter();

        for(int i = 0; i<players.length; i++) {
            risk.playTurn(players[i]);
        }

    }

}
