
import java.util.ArrayList;

/**
 * Class that represents the continents in the game.
 */

public class Continent {
    private String name;
    private ArrayList<Territory> territories;
    private int bonusTroops; //currently not used.

    /**
     * Constructs a continent object.
     *
     * @param name The name of the continent.
     * @param bonusTroops how many bonus troops it has.
     */

    public Continent(String name, int bonusTroops) {
	      this.name = name;
	      this.bonusTroops = bonusTroops;
	      this.territories = new ArrayList<>();
    }

    /**
     * Method that adds territories to continents.
     * @param territory <code>Territory</code> to be added.
     */

    public void addTerritory(Territory territory) {
	      territories.add(territory);
    }

    /**
     * Returns the name of the continent.
     *
     * @return <code>String</code> name of the territory.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the number of troops player wins by conquering the continent.
     *
     * @return <code>int</code> number of troops.
     */

    public int getBonusTroops() {
        return this.bonusTroops;
    }

    /**
     * Returns the <code>ArrayList</code> of territories in the continent.
     * @return <code>ArrayList</code> of territories
     */

    public ArrayList<Territory> getTerritories() {
        return territories;
    }

    /**
     * Method that checks if the player controls the continent.
     * @param player <code>Player</code>
     * @return true if the player controls the continent and false otherwise.
     */

    public boolean controlsContinent(Player player) {
	      for(Territory territory : territories) {
	         if(territory.getOwner() != player) {
	           return false;
	         }
	      } 
	      return true;
    }
    
}
