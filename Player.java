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
        //this.diceRollNumber = 0;
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

    public void removeArmyToTerritory(Territory territory, int numberOfPieces) throws InsufficientArmiesException {
        if (this.territories.contains(territory)) {
            int remainder = territory.getArmies() - numberOfPieces;
            if (remainder > 0) {
                territory.setArmy(remainder);
            } else {
                throw new InsufficientArmiesException();
            }
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

    public ArrayList<Territory> getTerritories() { return this.territories; }

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

    public void addScore(int score) {
        this.score += score;
    }

    /** Method that compares the dice roll.
     *
     * @param other the object to be compared.
     * @return positive number if the other dice roll is higher.
     */

    public int compareTo(Player other) {
        return other.diceRollNumber-this.diceRollNumber;
    }

    /** Method that simulates the attack of the Risk game.
     * You may only attack a territory that’s adjacent.
     * You must always have at least two armies in the territory you’re attacking from.
     * You will continue the attack until either you only have one army left in your original position
     * or you destroy all armies of the defender and become the new owner of the territory. You gain
     * as many armies in the new territory as you won rolling dice.
     *
     * @param origin is the territory you are attacking from.
     * @param target is the territory you want to attack.
     * @param defender is the player you're attacking.
     * @return true if attack is successful.
     *
     */

    public boolean attack(Territory origin, Territory target, Player defender) {
        int armiesWon = 0;
        if (origin.getArmies() > 2 && origin.isAdjacent(target.getName())) {
            while (origin.getArmies() > 1 && target.getArmies() != 0) {
                this.rollDice();
                defender.rollDice();
                if (this.getDiceRollNumber() > defender.getDiceRollNumber()) {
                    target.removeArmies(1);
                    armiesWon++;
                } else {
                    origin.removeArmies(1);
                }
            }
        }
        if (target.getArmies() == 0) {
            target.setOwner(this);
            target.setArmy(armiesWon);
            return true;
        }
        return false;
    }

    /**
     * Method that adds armies to player's stack based on the number of territories they occupy.
     */

    public void gainArmies () {
        if (this.getTerritories().size() / 3 < 3) {
            addArmy(3);
        } else {
            addArmy(this.getTerritories().size() / 3);
        }
    }
    /**
     * Method that adds armies to player's territory.
     *
     * @return false if the army can't be added.
     */

    public boolean placeArmies(int number, Territory trr) {
        return addArmyToTerritory(trr,number);
    }

    /**
     * Method that moves armies from one territory to another.
     *
     * @param origin
     * @param destination
     * @param number
     */

    public void fortify(Territory origin, Territory destination, int number) throws InsufficientArmiesException {
        try {
            removeArmyToTerritory(origin, number);
            addArmyToTerritory(destination,number);
        }
        catch (InsufficientArmiesException e){
            throw new InsufficientArmiesException();
        }
    }

    public void TradeArmyCards(ArmyCard[] cards) throws InvalidCombinationException {
        if (ArmyCard.isValidCombination(cards)) {
            addArmy(3);
        } else {
            throw new InvalidCombinationException();
        }
    }


    /*you can trade in 1 action card if it is the correct turn. This should be checked in the actionCard method*/

    public boolean TradeActionCard() {
        //TODO
        return false;
    }

}
