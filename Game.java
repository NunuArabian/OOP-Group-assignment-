import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Game {
    private final Player[] players;
    private ArrayList<Card> deck;
    private Continent[] map;
    private int currentTurn;
    //private int currentPlayerIndex;

    public static final int NUMBER_OF_PLAYERS = 4;
    private static final int NUMBER_OF_TURNS = 6;
    private static final int NUMBER_OF_CARDS = 54;
    private static final int NUMBER_OF_CONTINENTS = 6;


    public Game(Player[] playerNames) {
        players = playerNames;
        deck = new ArrayList<>(NUMBER_OF_CARDS);
        map = new Continent[NUMBER_OF_CONTINENTS];
        currentTurn = 0;
        initializeDeck();
        initializeMap();
    }


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

    private void initializeDeck() {
        deck.add(new ArmyCard(Card.CardType.WILD));
        deck.add(new ArmyCard(Card.CardType.WILD));

        for(int i = 0; i<map.length; i++) {
            ArrayList<Territory> terr = map[i].getTerritories();
            for (int j = 0; j< terr.size(); j++) {
                for (ArmyPiece.PieceType type : ArmyPiece.PieceType.values())
                    deck.add(new ArmyCard(Card.CardType.REGULAR, terr.get(j), new ArmyPiece(type)));
                }
            }
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.CEASE_FIRE));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.CEASE_FIRE));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.END_OF_TURN, ActionCard.Action.REDEPLOYMENT));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.END_OF_TURN, ActionCard.Action.REDEPLOYMENT));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.END_OF_TURN, ActionCard.Action.REDEPLOYMENT));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.END_OF_TURN, ActionCard.Action.REDEPLOYMENT));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.STEALTH_MODS));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.STEALTH_MODS));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.FORTIFY));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.FORTIFY));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.FORTIFY));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.FORTIFY));

        Collections.shuffle(deck);
    }

    public void turnCounter() {
            currentTurn++;
    }

    public void playTurn(Player p) {

    }

    public void getArmies() {
        /*At the beginning of every turn (including your first), count the
        number of territories you currently occupy, then divide the total by three
        (ignore any fraction). The answer is the number of armies you receive. Place
        the new armies on any territory you already occupy. You will always receive at least 3
        armies on a turn, even if you occupy fewer than 9 territories.
        In addition, at the beginning of your turn you will receive
        armies for each continent you control. (To control a continent, you must
        occupy all its territories at the start of your turn.) To find the exact number
        of armies you’ll receive for each continent, look at the chart in the lower
        left-hand corner of the game board.
        */

    }

    public boolean TradeArmyCards() {
        /*you can trade in 3 risk cards to earn armies.
        If any of the 3 cards you trade in shows the picture of
        a territory you occupy, you receive 2 extra armies. You must place both
        those armies onto that particular territory
        On a single turn, you may receive no more than 2 extra armies above
        and beyond those you receive for the matched sets of cards you trade in. */

    }

    public boolean TradeActionCard() {
        /*you can trade in 1 action card if it is the correct turn. This should be checked in the actionCard method*/
    }

    public void placeArmies() {
    }

    public void attack() {

        /*You may only attack a territory that’s adjacent (touching) to one of your
        own, or connected to it by a dashed line.
        You must always have at least two armies in the territory you’re
        attacking from.
        You may continue attacking one territory until you have eliminated all
        armies on it, or you may shift your attack from one territory to another,
        attacking each as often as you like and attacking as many territories as
        you like during one turn.
        Compare the highest die each of you rolled. If yours
        (the attacker’s) is higher, the defender loses one army from the territory under attack
        In case of a tie, the defender always wins.
         */
    }

    public void occupy() {
        /*As soon as you defeat the last opposing army on a territory, you capture that territory
        and must occupy it immediately. You must leave at least one army in your occuppied territory.
         */
    }

    public boolean earnCards() {
        /*At the end of any turn in which you have captured at
        least one territory, you will earn one RISK card.
         */
    }

    public void fortify() {
        /* same function as occupy method, can be potentially combined.
        To fortify your position, move as many armies as you’d like from one (and
        only one) of your territories into one (and only one) of your adjacent territories
         */
    }

    public boolean isOver () {
        /*The winner is the first player to eliminate every opponent by capturing all
        42 territories on the board in 5 turns */
    }

}
