/**
 * Class that represents the Deck of the game.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    /**
     * Constructs the default deck.
     * @param map <code>Continent Array</code> used to initialize <code>ArmyCards</code>.
     */

    public Deck(Continent[] map) {
        deck = new ArrayList<>();
        deck.add(new ArmyCard(Card.CardType.WILD));
        deck.add(new ArmyCard(Card.CardType.WILD));

        for(int i = 0; i<map.length; i++) {
            ArrayList<Territory> terr = map[i].getTerritories();
            for (int j = 0; j< terr.size(); j++) {
                for (ArmyPiece.PieceType type : ArmyPiece.PieceType.values())
                    deck.add(new ArmyCard(Card.CardType.REGULAR, terr.get(j), new ArmyPiece(type)));
            }
        }
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.CEASE_FIRE));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.CEASE_FIRE));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.END_OF_TURN, ActionCard.Action.REDEPLOYMENT));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.END_OF_TURN, ActionCard.Action.REDEPLOYMENT));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.END_OF_TURN, ActionCard.Action.REDEPLOYMENT));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.END_OF_TURN, ActionCard.Action.REDEPLOYMENT));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.STEALTH_MODS));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.STEALTH_MODS));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.FORTIFY));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.FORTIFY));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.FORTIFY));
        deck.add(new ActionCard(Card.CardType.WILD,
                ActionCard.PlayTime.OPPONENT_INVADES, ActionCard.Action.FORTIFY));

        Collections.shuffle(deck);
    }

    /**
     * Method that lets players draw a card from the deck.
     * @return the drawn <code>Card</code>
     */

    public Card drawCard() {
        int index = (int)(Math.random() * deck.size());
        Card drawedCard =  deck.get(index);
        deck.remove(index);
        return drawedCard;
    }


}
