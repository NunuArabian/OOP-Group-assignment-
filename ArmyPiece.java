

public class ArmyPiece {
    private PieceType pieceType;
    private int numberOfArmies;



    public enum PieceType {INFANTRY, CAVALRY, ARTILLERY}

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

    public PieceType getPieceType() {
        return this.pieceType;
    }
}
