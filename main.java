import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Continent[] map = new Continent[6];
        try {
            Scanner inputStream = new Scanner(new FileInputStream("Territories"));
            int counter = -1;
            String line = inputStream.nextLine();
            while (!line.equals("end")) {
                if (line.equals("new")) {
                    counter++;
                    String name = inputStream.nextLine();
                    int troops = inputStream.nextInt();
                    map[counter] = new Continent(name, troops);
                    inputStream.nextLine();
                }
                else {
                    map[counter].addTerritory(new Territory(line));
                }
                line = inputStream.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
            System.exit(0);
        }

        for (int i = 0; i < 6; i++) {
            System.out.println("Terriory: " + map[i].getName());
            System.out.println("Troops: " + map[i].getBonusTroops());
            ArrayList<Territory> ter = map[i].getTerritories();
            for (int j = 0; j < ter.size(); j++) {
                System.out.println(ter.get(j).getName());
            }
        }
    }
}
