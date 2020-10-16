public class KnightHelper{

	public static void main(String[] args){
		println("Welcome to the Move calculator.\n");
	}

	public static void showMoves(String piecePlacement, String chessPiece){
		int[][] board = new int[8][8];

		String kSquare = piecePlacement;
		Pos kPos = convertSquareToPos(kSquare);

		board[kPos.x][kPos.y] = 1;
		println("\nThe " + chessPiece + " is at square " + convertPosToSquare(kPos));
		println("From here the " + chessPiece + " can move to any ? you see:");

		String tempPiece = chessPiece.toUpperCase();

		moveCalculator(board, kPos, chessPiece);
	}

	public static void moveCalculator(int[][] board, Pos kPos, String chessPiece){
		int[][] pieceMoves = { {0, 0} };
		String tempPiece = chessPiece.toUpperCase();
		int moveCount = 0;

		switch(tempPiece){
			case "PAWN":
				pieceMoves = PieceMovements.pawnMoves;
				break;
			case "BISHOP":
				pieceMoves = PieceMovements.bishopMoves;
				break;
			case "KNIGHT":
				pieceMoves = PieceMovements.knightMoves;
				break;
			case "ROOK":
				pieceMoves = PieceMovements.rookMoves;
				break;
			case "QUEEN":
				pieceMoves = PieceMovements.queenMoves;
				break;
			case "KING":
				pieceMoves = PieceMovements.kingMoves;
				break;
		};

		moveCount = pieceMoves.length;
		if(tempPiece.equals("PAWN") && kPos.y != 1)
			moveCount = 1;

		if(moveCount >= 1){
			for (int move = 0; move < moveCount; move++){
				boolean lastCheck = (move == moveCount - 1);
				int x, y;
				x = pieceMoves[move][0];
				y = pieceMoves[move][1];
				Pos p = calculateNewPos(kPos, x, y);

				if (p != null){
					if(!lastCheck){
						print(convertPosToSquare(p) + ", ");
					}
					else
						print(convertPosToSquare(p));
					board[p.x][p.y] = 2;
				}
			}
			println("");
			printBoard(board);
		}
		else
			println("Nowhere.  You have no moves when you place your " + chessPiece + " here!");
	}

	// Converts squareLocation to xy coordinates
	public static Pos convertSquareToPos(String square){
		int x = -1;
		int y = -1;
		char file, rank;

		file = square.charAt(0);
		if(file == 'a') x = 0;
		if(file == 'b') x = 1;
		if(file == 'c') x = 2;
		if(file == 'd') x = 3;
		if(file == 'e') x = 4;
		if(file == 'f') x = 5;
		if(file == 'g') x = 6;
		if(file == 'h') x = 7;

		rank = square.charAt(1);
		if(rank == '1') y = 0;
		if(rank == '2') y = 1;
		if(rank == '3') y = 2;
		if(rank == '4') y = 3;
		if(rank == '5') y = 4;
		if(rank == '6') y = 5;
		if(rank == '7') y = 6;
		if(rank == '8') y = 7;

		if(x == -1 || y == -1)
			return null;
		else
			return new Pos(x, y);
	}

	// Converts xy coordinates to square coordinate location
	public static String convertPosToSquare(Pos p){
		String file = "";
		if(p.x == 0) file = "a";
		if(p.x == 1) file = "b";
		if(p.x == 2) file = "c";
		if(p.x == 3) file = "d";
		if(p.x == 4) file = "e";
		if(p.x == 5) file = "f";
		if(p.x == 6) file = "g";
		if(p.x == 7) file = "h";

		return file + (p.y + 1);
	}

	public static Pos calculateNewPos(Pos p, int x, int y){
		if(p.x + x < 0 || p.x + x > 7)
			return null;
		if(p.y + y < 0 || p.y + y > 7)
			return null;

		return new Pos(p.x + x, p.y + y);
	}

	public static void printBoard(int[][] b){
		println("|----|----|----|----|----|----|----|----|");
		for(int y = 7; y >= 0; y--){
			for(int x = 0; x < 8; x++){
				if(b[x][y] == 1)
					print("| X  ");
				else if(b[x][y] == 2)
					print("| ?  ");
				else
					print("|    ");
			}
			println("|");
			println("|----|----|----|----|----|----|----|----|");
		}
		println("");
	}

	public static void println(Object line){
		System.out.println(line);
	}
	public static void print(Object line){
		System.out.print(line);
	}

}
