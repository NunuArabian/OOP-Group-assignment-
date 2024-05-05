import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;

public class Territory {

    private String name;
    private Player owner;
    private int armies;

    private ArrayList<String> adjacentTerritories;
    private static Map<String, ArrayList<String>> allAdjacentTerritories = getAllAdjacentTerritories();


    public Territory(String name) {
        this.name = name;
        this.owner = null;
        this.armies = 0;
        this.adjacentTerritories = allAdjacentTerritories.get(name);
    }

    public void setOwner(Player owner) {
	      this.owner = owner;
    }

    public void setArmy(int numberOfPieces) {
        armies += numberOfPieces;
    }

    public Player getOwner() {
	      return owner;
    }

    public String getName() { return name;}

    public static Map<String, ArrayList<String>> getAllAdjacentTerritories() {

        Map<String, ArrayList<String>> allAdjacentTerritories = null;
        try {
            Scanner inputStream = new Scanner(new FileInputStream("adjacentTerritories"));
            while(inputStream.hasNext()) {
                String line = inputStream.nextLine();
                String[] territoryArray = line.split(",");
                if(territoryArray.length>0) {
                    String key = territoryArray[0];
                    ArrayList<String> values = new ArrayList<>();
                    for (int i = 1; i < territoryArray.length; i++) {
                        values.add(territoryArray[i]);
                    }
                    allAdjacentTerritories.put(key,values);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        return allAdjacentTerritories;
    }
}
