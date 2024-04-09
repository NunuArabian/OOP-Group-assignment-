import java.util.ArrayList;

public class Territory {
    private Player owner;

    public Territory() {
	      this.owner = null;
    }

    public void setOwner(Player owner) {
	      this.owner = owner;
    }

    public Player getOwner() {
	      return owner;
    }

}
