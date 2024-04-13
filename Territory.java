import java.util.ArrayList;

public class Territory {
    private Player owner;
    private int armies;

    public Territory() {

        this.owner = null;
        this.armies = 0;
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

}
