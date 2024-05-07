/**
 * The class that represents the army pieces in the Risk game.
 *  */

public class ArmyPiece {
    private PieceType pieceType;
    private int numberOfArmies;



    public enum PieceType {INFANTRY, CAVALRY, ARTILLERY}

    /**
     * Constructs an ArmyPiece object based on the provided PieceType
     * @param pieceType
     */

    public ArmyPiece(PieceType pieceType) {
	      this.pieceType = pieceType;
          if(pieceType == PieceType.INFANTRY)
          {
              numberOfArmies = 1;
          }
          else if(pieceType == PieceType.CAVALRY) {
              numberOfArmies = 5;
          }
          else if(pieceType == PieceType.ARTILLERY) {
              numberOfArmies = 10;
          }
    }

    /**
     * Returns the <code>PieceType</code> of the army piece
     * @return the <code>PieceType</code> of the army piece
     */

    public PieceType getPieceType() {
        return this.pieceType;
    }
}
