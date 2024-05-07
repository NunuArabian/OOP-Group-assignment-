import java.util.ArrayList;

/**
 * Class that represent the players of the game.
 */

public class Player implements Comparable<Player>{
    private String name;
    private int diceRollNumber;
    private ArrayList<Territory> territories;
    private ArrayList<Card> cards;
    private int armies;

    private int score;

    /**
     * Constructs the player object of the game.
     * @param name <code>String</code> name of the player.
     */


    public Player(String name) {
        //this.diceRollNumber = 0;
        this.territories = new ArrayList<>();
        this.cards = new ArrayList<>();
        this.armies = 30;
        this.score = 0;
        this.name = name;
    }


    /**
     * Method that adds territory to the player.
     * @param territory
     */

    public void addTerritory(Territory territory) {
        this.territories.add(territory);
    }

    /**
     * Returns the name of the player.
     * @return <code>String</code> name of the player.
     */

    public String getName() {
        return this.name;
    }

    /**
     * Returns the cards of the player.
     * @return <code>ArrayList</code> of cards.
     */

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * Returns the number of armies of the player.
     * @return <code>int</code> number of armies.
     */
    public int getArmies() {
        return this.armies;
    }

    /**
     * Returns the territories the player owns.
     * @return <code>ArrayList</code> of territories.
     */

    public ArrayList<Territory> getTerritories() { return this.territories; }

    /**
     * Adds armies to player.
     * @param armies <code>int</code> number of armies to add.
     */

    public void addArmy(int armies) {
       this.armies += armies;
    }

    /**
     * Adds armies to player.
     * @param armies <code>int</code> number of armies to add.
     */

    public void removeArmy(int armies) {
        this.armies -= armies;
    }

    /**
     * Adds cards to player.
     * @param card <code>Card</code> to add.
     */

    public void addCard(Card card) {
        this.cards.add(card);
    }

    /**
     * Method used to imitate the rolling of the dice.
     */

    public void rollDice() {
        this.diceRollNumber = (int) (Math.random() * 6) + 1;
    }

    /**
     * Returns the mos recent dice roll number.
     * @return the dice toll number.
     */

    public int getDiceRollNumber() {
        return this.diceRollNumber;
    }

//    public void addScore(int score) {
//        this.score += score;
//    }


    /**
     * Adds armies to player's territory.
     * @param territory <code>Territory</code> to add armies to.
     * @param numberOfPieces <code>int</code> number of armies to add.
     *
     * @return Returns true if the addition is successful.
     */

    public boolean addArmyToTerritory(Territory territory, int numberOfPieces) {
        if (this.territories.contains(territory)) {
            territory.setArmy(numberOfPieces);
            this.addArmy(this.armies-numberOfPieces);
            removeArmy(numberOfPieces);
            return true;

        } else {
            return false;
        }
    }

    /**
     * Removes armies from player's territory.
     * @param territory <code>Territory</code> to remove armies from.
     * @param numberOfPieces <code>int</code> number of armies to rmeove.
     *
     */


    public void removeArmyFromTerritory(Territory territory, int numberOfPieces) throws InsufficientArmiesException {
        if (this.territories.contains(territory)) {
            int remainder = territory.getArmies() - numberOfPieces;
            if (remainder > 0) {
                territory.setArmy(remainder);
            } else {
                throw new InsufficientArmiesException();
            }
        }
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
     * Returns <code>Territory</code> based on the provided name.
     * @param name <code>String</code> name of the territory.
     * @return
     */


    public Territory returnTerritory(String name) {
        for (int i = 0; i< territories.size(); i++) {
            if (territories.get(i).getName().equals(name)) {
                return territories.get(i);
            }
        }
        return null;
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
     * @param origin Original territory
     * @param destination Destination  territory
     * @param number the number of armies to move.
     */

    public void fortify(Territory origin, Territory destination, int number) throws InsufficientArmiesException {
        try {
            removeArmyFromTerritory(origin, number);
            addArmyToTerritory(destination,number);
        }
        catch (InsufficientArmiesException e){
            throw new InsufficientArmiesException();
        }
    }
    /**
     * Method to trade ArmyCards.
     *
     * @param indexes the indexes of the cards
     */


    public void TradeArmyCards(int[] indexes) throws InvalidCombinationException {
        ArrayList<ArmyCard> cards = new ArrayList<>();
        for (int i = 0; i<indexes.length; i++) {
            ArmyCard card = (ArmyCard) this.getCards().get(indexes[i]);
            cards.add(card);
        }

        ArmyCard[] tradingCards = new ArmyCard[cards.size()];
        tradingCards = cards.toArray(tradingCards);

        if (ArmyCard.isValidCombination(tradingCards)) {
            addArmy(3);
            for (int i = 0; i<indexes.length; i++) {
                this.getCards().remove(indexes[i]);
            }
        } else {
            throw new InvalidCombinationException();
        }
    }

}
