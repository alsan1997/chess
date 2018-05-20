package gamelogic;

public class Prince extends Piece {
	Type type;
	
	/**
     * Constructor for Prince.
     * @param board   the board object of the current Board
     * @param location   the location object of the Board
     * @param owner the Owner object associated with the Piece
     */
	public Prince(Location location, Player player) {
		super(location, player);
		type = Type.PRINCE;
	}

	/**
	 * A function that gets the Piece type.
	 * @return  an integer indicating the Piece type
	 */
	public Type getType()
	{
		return Type.PRINCE;
	}
	
	/**
     * check Validmove for Prince.
     * @param x, designated row's location
     * @param y, designated col's location
     * @return boolean = true if it's valid otherwise false
     */
	@Override
	public boolean legalMovement(int toI, int toJ, Start start, Player player) {
		// call (x,y)
		int fromI = this.getLocation().getRow();
		int fromJ = this.getLocation().getCol();
		
		if(isOutOfBound(toI, toJ)) {
			return false;
		}
		
		if(fromI == toI || fromJ == toJ) {
			if(Math.abs(fromJ - toJ) == 2 || Math.abs(fromI - toI) == 2) {
				if(start.board.getPiece(toI, toJ) == null) {
					return true;
				}
				
				if(player.getPlayerType() == start.board.getPiece(toI, toJ).getPlayer().getPlayerType()) {
					return false;
				}
				else {
					return true;
				}
			}
		}
		
		return false;
		
		
	}
}
