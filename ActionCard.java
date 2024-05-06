public class ActionCard extends Card{

    /*Before First Invasion Play on your turn before your first invasion is declared.
    Opponent Invades Play after an opponent declares an invasion into a territory of the card type.
    End of Turn Play at the end of your turn.
    https://risk2210.net/resources/Command_Cards_Summary.pdf
    https://imgur.com/a/yY4XR
    */

    public enum PlayTime {OPPONENT_INVADES, END_OF_TURN, JOKER}

    /*
    CEASE_FIRE (x2)  -  OPPONENT_INVADES: Invades. Prevent the invasion.
    The attacking player cannot attack any of your territories for the rest of his/her turn
    REDEPLOYMENT (x4) - END_OF_TURN. Take an extra free move this turn.
    You may only take this free move after you have finished attacking.
    STEALTH_MODS (x4) - OPPONENT_INVADES. Place 3 additional defending armies in the defending land territory.
    FORTIFY (x4) - OPPONENT_INVADES.  add +1 to die roll when attacked.
    SPY (x1) - END_OF_TURN: steal any opponent's action card.
    JOKER (10)
    */

    public enum Action {CEASE_FIRE, REDEPLOYMENT, STEALTH_MODS, FORTIFY}
    private PlayTime playTime;
    private Action action;

    public ActionCard(CardType cardType, PlayTime playTime, Action action) {
        super(cardType);
        this.playTime = playTime;
        this.action = action;
    }

    public Action getAction() {
        return this.action;
    }

//    public void ActionExecution () {
//        switch (this.getAction()) {
//            case  Action.FREQUENCY_JAM:
//            case  Action.REDEPLOYMENT:
//            case: Action.STEALTH_MODS:
//            case: Action.FORTIFY:
//            case: Action.SPY:
//            case: Action.JOKER
//        }
//
//    }



}
