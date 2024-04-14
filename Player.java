import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private int diceRollNumber;
    private ArrayList<Territory> territories;
    private ArrayList<Card> cards;
    private int armies;

    public Player() {
        this.diceRollNumber = 0;
        this.territories = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.armies = 0;
    }

    public void addArmyToTerritory(Territory territory, int numberOfPieces) {
        if (this.territories.contains(territory)) {
                territory.setArmy(numberOfPieces);
                this.setArmy(this.armies-numberOfPieces);

        } else {
            System.out.println("You don't own this territory!");
        }
    }

    public void addTerritory(Territory territory) {
        this.territories.add(territory);
    }

    public int getArmies() {
        return this.armies;
    }

    public void setArmy(int armies) {
       this.armies += armies;
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
}
