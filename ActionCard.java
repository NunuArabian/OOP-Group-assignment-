/**
 * The ActionCard class represents the action cards in the Risk game.
 */


public class ActionCard extends Card{

    public enum PlayTime {OPPONENT_INVADES, END_OF_TURN}

    public enum Action {CEASE_FIRE, REDEPLOYMENT, STEALTH_MODS, FORTIFY}
    private PlayTime playTime;
    private Action action;


    /**
     * Constructs an ActionCard with a given type, playTime and action.
     */

    public ActionCard(CardType cardType, PlayTime playTime, Action action) {
        super(cardType);
        this.playTime = playTime;
        this.action = action;
    }

    /**
     * Returns the action of the card.
     *
     * @return <code>Action</code> of the card.
     */

    public Action getAction() {
        return this.action;
    }

    /**
     * Returns the play time of the card.
     *
     * @return <code>PlayTime</code> of the card.
     */

    public PlayTime getPlayTime() { return this.playTime; }


    /**
     * Method that allows player to take an extra turn.
     * @param i <code>int</code>  turn number
     * @return reset turn
     */

    public int playRedeployment(int i) {
        return i--;
    }

    /**
     * Method that place 3 additional defending armies in the defending land territory.
     *
     * @param terr the defending territory
     */
    public void playStealthMod(Territory terr) {
        terr.setArmy(3);
    }

    /**
     * Method that add +1 to the dice roll of the player.
     * @param p The player to add +1
     * @return the new dice roll number
     */

    public int playFortify(Player p) {
        return p.getDiceRollNumber() +1;
    }

}
