import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that represents the UI fo the game.
 */


public class GameConsole {

    private Game risk;

    /**
     * Methods that executes the full game of the risk.
     */

    public void play() {
        Player[] players = new Player[Game.NUMBER_OF_PLAYERS];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < players.length; i++) {
            System.out.println("Hello player " + i + " please enter your name");
            players[i] = new Player(sc.nextLine());
            System.out.println("Rolling the dice to determine the order of the game");
            players[i].rollDice();
        }
        Arrays.sort(players);
        for (int i = 0; i < players.length; i++) {
            System.out.println("Players order:");
            System.out.println(players[i].getName());
        }

        risk = new Game(players);

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getName() + " place your armies by typing the Territory and number of armies." +
                    "Input end when done");
            while (!sc.next().equals("done")) {
                String input = sc.next();
                try {
                    if (sc.hasNextInt()) {
                        int armyCount = sc.nextInt();
                        Territory tr = new Territory(input);
                        players[i].addTerritory(tr);
                        if (!players[i].addArmyToTerritory(tr, armyCount)) {
                            System.out.println(tr.getName() + " is already claimed");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
            System.out.println(players[i].getName() + " has finished placing armies.");
        }
        risk.turnCounter();
        System.out.println(risk.getCurrentTurn());

        while (!risk.isOver()) {
            for (int i = 0; i < players.length; i++) {
                players[i].gainArmies();
                System.out.println(players[i].getName() + " Do you want to trade in cards. Yes/No");
                if (sc.next().equals("Yes")) {
                    System.out.println("Which cards do you want to trade, input 3 indexes. Input end when done");
                    int[] cardIndexes = new int[3];
                    while (!sc.next().equals("done")) {
                        cardIndexes[i] = sc.nextInt();
                    }
                    try {
                        players[i].TradeArmyCards(cardIndexes);
                    } catch (InvalidCombinationException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println(players[i].getName() + "You have " + players[i].getArmies() + " armies." +
                        "Place them by indicating the names of the territory then the number." +
                        " Input end when done");

                while (!sc.next().equals("done")) {
                    Territory trr = players[i].returnTerritory(sc.next());
                    int number = sc.nextInt();
                    players[i].addArmyToTerritory(trr, number);
                }
                System.out.println(players[i].getName() + " Do you want to attack. Yes/No");
                if (sc.next().equals("Yes")) {
                    System.out.println(players[i].getName() + "specify the origin, player name and destination you wish to attack");
                    Territory origin = players[i].returnTerritory(sc.next());
                    Player p = returnPlayer(players, sc.next());
                    Territory destination = p.returnTerritory(sc.next());
                    if (players[i].attack(origin, destination, p)) {
                        risk.earnCards(players[i]);
                        System.out.println("The attack was successful.");
                    } else {
                        System.out.println("The attack was unsuccessful.");
                    }
                }
                System.out.println(players[i].getName() + " Do you want to fortify. Yes/No");
                if (sc.next().equals("Yes")) {
                    System.out.println("Specify the origin, destination and the number of armeis you want to move. Input done when finisehd.");

                    while (!sc.next().equals("done")) {
                        Territory origin = players[i].returnTerritory(sc.next());
                        Territory destination = players[i].returnTerritory(sc.next());
                        int number = sc.nextInt();
                        try {
                            players[i].fortify(origin, destination, number);
                        } catch (InsufficientArmiesException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            risk.turnCounter();
            //TODO action card usage.
        }
    }

    /**
     * Helper method that returns <code>Player</code> object based on name.
     *
     * @param players <code>Array</code> of <code>Players</code>
     * @param name <code>String</code> name of the player
     * @return <code>Player</code> that matches the name.
     */

    private static Player returnPlayer(Player[] players, String name) {
        for(int i = 0; i< players.length; i++) {
            if(players[i].getName().equals(name)) {
                return players[i];
            }
        }
        return null;
    }

}
