import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Class to represent a game of risk.
 */

public class Game {
    private final Player[] players;
    private Deck deck;
    private Continent[] map;
    private int currentTurn;
    //private int currentPlayerIndex;

    public static final int NUMBER_OF_PLAYERS = 4;
    private static final int NUMBER_OF_TURNS = 6;
    private static final int NUMBER_OF_CONTINENTS = 6;


    /**
     * Constructs an instance of a risk game based on provided players.
     * @param playerNames the <code>Array</code> of players.
     */

    public Game(Player[] playerNames) {
        players = playerNames;
        map = new Continent[NUMBER_OF_CONTINENTS];
        initializeMap();
        deck = new Deck(map);
        currentTurn = 0;
    }

    /**
     * Initialized the default map of the game.
     */


    private void initializeMap() {
        try {
            Scanner inputStream = new Scanner(new FileInputStream("Territories"));
            int counter = -1;
            String line = inputStream.nextLine();
            while (!line.equals("end")) {
                if (line.equals("new")) {
                    counter++;
                    String name = inputStream.nextLine();
                    int troops = inputStream.nextInt();
                    map[counter] = new Continent(name, troops);
                    inputStream.nextLine();
                }
                else {
                    map[counter].addTerritory(new Territory(line));
                }
                line = inputStream.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            System.exit(0);
        }
    }

    /**
     * Helper method to keep track of the game turn
     */


    public void turnCounter() {
            currentTurn++;
    }

    /**
     * Returns the current turn of the game.
     * @return <code>int</code> turn of the game.
     */

    public int getCurrentTurn() { return currentTurn; };


    /**
     * Method that draws a card form the deck and assigns to the player.
     * Call this method only if the player has concurred a territory.
     *
     * @param p  player who earns cards
     */

    public void earnCards(Player p) {
        p.addCard(deck.drawCard());

    }
    /**
     * Checks if the game is over and terminates the game.
     */

    public boolean isOver () {
        if (currentTurn > NUMBER_OF_TURNS) {
            System.out.println("Number of turns reached. The game is over");
            return true;
        }
        for (int i = 0; i < players.length; i++) {
            if (players[i].getTerritories().size() == 42) {
                    System.out.println(players[i].getName() + " has won. The game is over");
                    return true;
            }
        }
        return false;
    }
}
