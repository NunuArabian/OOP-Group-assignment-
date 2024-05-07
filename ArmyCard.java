/**
 * The ArmyCard class represents the army cards in the Risk game.
 *  */

public class ArmyCard extends Card implements Cloneable {
    private final Territory territory;
    private final ArmyPiece[] armyPiece;

    /**
     * Constructs a Wild <code>ArmyCard</code> type.
     */

    public ArmyCard(Card.CardType cardType) {
        super(Card.CardType.WILD);
        this.armyPiece = new ArmyPiece[3];
        armyPiece[0] = new ArmyPiece(ArmyPiece.PieceType.INFANTRY);
        armyPiece[1] = new ArmyPiece(ArmyPiece.PieceType.CAVALRY);
        armyPiece[2] = new ArmyPiece(ArmyPiece.PieceType.ARTILLERY);
        this.territory = null;
    }

    /**
     * Constructs a Regular <code>ArmyCard</code> with a given type.
     *
     * @param cardType defines which card type to create.
     * @param territory defines the territory to be used in the card
     * @param armyPiece defines which army piece the card should have.
     */

    public ArmyCard(Card.CardType cardType, Territory territory, ArmyPiece armyPiece) {
        super(Card.CardType.REGULAR);
        this.territory = territory;
        this.armyPiece = new ArmyPiece[1];
        this.armyPiece[0] = armyPiece;
    }

    /**
     * Returns the army piece of the card.
     *
     * @return <code>ArmyPiece</code>
     */

    public ArmyPiece getArmyPiece() {
        if(this.cardType == Card.CardType.WILD) {
            return null;
        }
        else {
            return this.armyPiece[0];
        }
    }

    /**
     * Method that checks if the cards form a valid combination to be traded.
     *
     * @param cards array of cards
     * @return true if the combination is valid, false otherwise.
     */

    public static boolean isValidCombination(ArmyCard[] cards) {

        if (cards.length != 3) {
            return false;
        }
        int infantry = 0;
        int cavalry = 0;
        int artillery = 0;

        for (int i = 0; i < cards.length; i++) {
            if (cards[i].getCardType() == Card.CardType.WILD)
                return true;
            else if (cards[i].getArmyPiece().getPieceType().equals("Infanrty"))
                infantry++;
            else if (cards[i].getArmyPiece().getPieceType().equals("Cavalry"))
                cavalry++;
            else if (cards[i].getArmyPiece().getPieceType().equals("Artillery"))
                artillery++;
        }
        if (infantry == 3 || cavalry == 3 || artillery == 3) {
            return true;
        } else if (infantry == 1 && cavalry == 1 && artillery == 1) {
            return true;
        }
        return false;
    }

}
