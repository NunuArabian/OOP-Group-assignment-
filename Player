import java.util.ArrayList;

public class Player {
    private int diceRollNumber;
    private ArrayList<Territory> territories;
    private ArrayList<Card> cards;

    public Player() {
        this.diceRollNumber = 0;
        this.territories = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    public void addArmy(Territory territory, ArmyPiece piece, int numberOfPieces) {
        if (this.territories.contains(territory)) {
            territory.addArmy(piece, numberOfPieces);
        } else {
            System.out.println("You don't own this territory!");
        }
    }

    public void addTerritory(Territory territory) {
        this.territories.add(territory);
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
