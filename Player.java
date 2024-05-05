import java.util.ArrayList;
import java.util.Arrays;

public class Player implements Comparable<Player>{
    private String name;
    private int diceRollNumber;
    private ArrayList<Territory> territories;
    private ArrayList<Card> cards;
    private int armies;

    private int score;

    public Player(String name) {
        this.diceRollNumber = 0;
        this.territories = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.armies = 30;
        this.score = 0;
        this.name = name;
    }

    public boolean addArmyToTerritory(Territory territory, int numberOfPieces) {
        if (this.territories.contains(territory)) {
                territory.setArmy(numberOfPieces);
                this.addArmy(this.armies-numberOfPieces);
                return true;

        } else {
            return false;
        }
    }

    public void addTerritory(Territory territory) {
        this.territories.add(territory);
    }

    public String getName() {
        return this.name;
    }

    public int getArmies() {
        return this.armies;
    }

    public void addArmy(int armies) {
       this.armies += armies;
    }
    public void removeArmy(int armies) {
        this.armies -= armies;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void removeCard(Card card) {
        this.cards.remove(card);
    }

    public void rollDice() {
        this.diceRollNumber = (int) (Math.random() * 6) + 1;
    }

    public int getDiceRollNumber() {
        return this.diceRollNumber;
    }

    public void exchangeCards() {
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int compareTo(Player other) {
        return other.diceRollNumber-this.diceRollNumber;
    }

}
