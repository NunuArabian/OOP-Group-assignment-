public class Card {
    public enum CardType {WILD, REGULAR,COMMANDER,DIMPLOAMT}

    private final CardType cardType;

    //https://imgur.com/a/yY4XR and divided into trading cards and action cards

    public Card() {
        this.cardType = CardType.REGULAR;
    }

    public Card(CardType cardtype) {
        this.cardType =cardtype;
    }

    public CardType getCardType() { return cardType; }

    public Card drawCard() { return null; }
    public Card[] playCard(){
        return  null;
    }


    public Card[] availableCards() {
        return null;
    }

    public void removeFromDeck() {}

}
