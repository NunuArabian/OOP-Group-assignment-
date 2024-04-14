public class ActionCard extends Card{

    /*Before First Invasion Play on your turn before your first invasion is declared.
    Opponent Invades Play after an opponent declares an invasion into a territory of the card type.
    End of Turn Play at the end of your turn.
    https://risk2210.net/resources/Command_Cards_Summary.pdf
    https://imgur.com/a/yY4XR
    */

    public enum PlayTime {BEFORE_INVASION, OPPONENT_INVADES, END_OF_TURN, JOKER}

    /*
    FREQUENCY_JAM (x4) - BEFORE_INVASION: Choose a player. The chosen player cannot play command cards during your turn
    CEASE_FIRE (x2)  -  OPPONENT_INVADES: Invades. Prevent the invasion.
    The attacking player cannot attack any of your territories for the rest of his/her turn
    REDEPLOYMENT (x4) - END_OF_TURN. Take an extra free move this turn.
    You may only take this free move after you have finished attacking.
    STEALTH_MODS (x4) - OPPONENT_INVADES. Place 3 additional defending armies in the defending land territory.
    FORTIFY (x4) - OPPONENT_INVADES.  add +1 to die roll when attacked.
    SPY (x1) - END_OF_TURN: steal any opponent's action card.
    JOKER (10)
    */

    public enum Actions {CEASE_FIRE, REDEPLOYMENT, FREQUENCY_JAM, STEALTH_MODS, FORTIFY, SPY, JOKER}
    private PlayTime playTime;
    private int cost;
    private String action;

    public ActionCard(CardType cardType, PlayTime playTime, int cost, String action) {
        super(cardType);
        this.playTime = playTime;
        this.cost = cost;
        this.action = action;
    }

    //playTime and card type needs to be checked before calling this method.
    @Override
    public void tradeCard(Player p, Card[] cards) throws InvalidCombinationException {
        if(cards.length>1) {
            throw new InvalidCombinationException();
        }
        else {
            //TODO
        }

    }
}
