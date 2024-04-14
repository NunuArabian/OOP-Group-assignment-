import java.util.ArrayList;

public class Continent {
    private String name;
    private ArrayList<Territory> territories;
    private int bonusTroops;

    public Continent(String name, int bonusTroops) {
	      this.name = name;
	      this.bonusTroops = bonusTroops;
	      this.territories = new ArrayList<>();
    }

    public void addTerritory(Territory territory) {
	      territories.add(territory);
    }

    public void removeTerritory(Territory territory) {
	      territories.remove(territory);
    }

    public boolean controlsContinent(Player player) {
	      for(Territory territory : territories) {
	         if(territory.getOwner() != player) {
	           return false;
	         }
	      } 
	      return true;
    }
    
}
