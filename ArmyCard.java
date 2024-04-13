public class ArmyCard extends Card implements Cloneable {
    private final Territory territory;
    private final ArmyPiece[] armyPiece;

    public ArmyCard(Card.CardType cardType) {
        super(Card.CardType.WILD);
        this.armyPiece = new ArmyPiece[3];
        armyPiece[0] = new ArmyPiece(ArmyPiece.PieceType.INFANTRY);
        armyPiece[1] = new ArmyPiece(ArmyPiece.PieceType.CAVALRY);
        armyPiece[2] = new ArmyPiece(ArmyPiece.PieceType.ARTILLERY);
        this.territory = null;
    }

    public ArmyCard(Card.CardType cardType, Territory territory, ArmyPiece armyPiece) {
        super(Card.CardType.REGULAR);
        this.territory = territory;
        this.armyPiece = new ArmyPiece[1];
        this.armyPiece[0] = armyPiece;
    }

    public ArmyPiece getArmyPiece() {
        if(this.cardType == Card.CardType.WILD) {
            return null;
        }
        else {
            return this.armyPiece[0];
        }
    }

    @Override
    public void tradeCard(Player p, ArmyCard[] cards) {
        try {
            isValidCombination(cards);
            p.setArmy(3);
        }
        catch(InvalidCombinationException e){
           System.out.println(e.getMessage());
        }

    }

    public static boolean isValidCombination(ArmyCard[] cards) throws InvalidCombinationException {
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
        else {
            throw new InvalidCombinationException;
        }
    }

}
