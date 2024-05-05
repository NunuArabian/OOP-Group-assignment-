public abstract class Card {


    public enum CardType {WILD, REGULAR, ACTION}
    public CardType cardType;

    //https://imgur.com/a/yY4XR and divided into trading cards and action cards

    public Card(CardType cardType) {
        this.cardType = cardType;
    }
    public CardType getCardType() { return this.cardType; }

    public Card drawCard() { return null; }

    public Card[] availableCards() {
        return null;
    }

    public void removeFromDeck() {}
    public abstract void tradeCard(Player p, Card[] cards) throws InvalidCombinationException;
}
