import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileInputStream;

/**
 * Class that describes the territories in the game.
 */


public class Territory {

    private String name;
    private Player owner;
    private int armies;

    private ArrayList<String> adjacentTerritories;
    private static HashMap<String, ArrayList<String>> allAdjacentTerritories = getAllAdjacentTerritories();


    /**
     * Given a name, constructs the territory.
     * @param name <code>String</code> name of the continent.
     */

    public Territory(String name) {
        this.name = name;
        this.owner = null;
        this.armies = 0;
        this.adjacentTerritories = allAdjacentTerritories.get(name);
    }

    /**
     * Sets the owner of the territory.
     *
     * @param owner <code>Player</code> who owns the territory.
     */

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * Sets the number of armies to the territory.
     *
     * @param numberOfPieces <code>int</code> number of armies.
     */

    public void setArmy(int numberOfPieces) {
        armies += numberOfPieces;
    }

    /**
     * Returns the owner of the <code>Territory</code>.
     * @return <code>Player</code> who owns the territory.
     */

    public Player getOwner() {
        return owner;
    }

    /**
     * Returns the name of the owner of the <code>Territory</code>.
     * @return <code>String</code> the name of the playe who owns the territory.
     */

    public String getName() {
        return name;
    }

    /**
     * Returns the number of armies in the territory.
     * @return <code>int</code> number of armies.
     */

    public int getArmies() {
        return armies;
    }

    /**
     * Removes armies from the territory.
     * @param n <code>int</code> number of armies to remove.
     */

    public void removeArmies(int n) {
        armies -= n;
    }

    /**
     * Returns all adjacent territories on the map as <code>HashMap</code>.
     * @return <code>HashMap</code> of adjacent territories.
     */

    public static HashMap<String, ArrayList<String>> getAllAdjacentTerritories() {

        HashMap<String, ArrayList<String>> allAdjacentTerritories = new HashMap<String, ArrayList<String>>();
        try {
            Scanner inputStream = new Scanner(new FileInputStream("adjacentTerritories"));
            while (inputStream.hasNext()) {
                String line = inputStream.nextLine();
                String[] territoryArray = line.split(",");
                if (territoryArray.length > 0) {
                    String key = territoryArray[0];
                    ArrayList<String> values = new ArrayList<>();
                    for (int i = 1; i < territoryArray.length; i++) {
                        values.add(territoryArray[i]);
                    }
                    allAdjacentTerritories.put(key, values);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        return allAdjacentTerritories;
    }

    /**
     * Returns true if the calling territory is adjacent.
     * @param name <code>String</code> name of the territory.
     * @return
     */

    public boolean isAdjacent(String name) {
        return this.adjacentTerritories.contains(name);
    }

}


