public class ActionCard extends Card{

    /*Before First Invasion Play on your turn before your first invasion is declared.
    Opponent Invades Play after an opponent declares an invasion into a territory of the card type.
    End of Turn Play at the end of your turn.
    https://risk2210.net/resources/Command_Cards_Summary.pdf
    https://imgur.com/a/yY4XR
    */

    public enum PlayTime {BEFORE_INVESION, AFTER_OPPONENT_INVASION, END_OF_TURN}

    //fortify - add +1 to die roll when attacked
    //spy - end of turn, steal opponent's action card

    public enum Actions {CEASE_FIRE, REDEPLOYMENT, FREQUENCY_JAM, STEALTH_MODS, FORTIFY, SPY}
    private PlayTime playTime;
    private int cost;
    private String action;

    public ActionCard(CardType cardType, PlayTime playTime, int cost, String action) {
        super(cardType);
        this.playTime = playTime;
        this.cost = cost;
        this.action = action;
    }

    @Override
    public void tradeCard(Player p, ArmyCard[] cards) {

    }
}
