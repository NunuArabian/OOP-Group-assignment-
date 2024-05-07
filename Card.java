/**
 * An encompassing Card class that represents all cards in the game.
 */
public abstract class Card {

    public enum CardType {WILD, REGULAR, ACTION}
    public CardType cardType;

    //https://imgur.com/a/yY4XR and divided into trading cards and action cards

    /**
     * Constructs a Card object.
     *
     * @param cardType defines the card type to be used.
     */
    public Card(CardType cardType) {
        this.cardType = cardType;
    }

    /**
     * Returns the card type.
     *
     * @return CardType
     */
    public CardType getCardType() { return this.cardType; }

}
