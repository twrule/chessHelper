public class KnightHelper{
	// static Scanner sc = new Scanner(System.in);

	static int[][] knightMoves = {	{-2, +1},
									{-1, +2},
									{+1, +2},
									{+2, +1},
									{+2, -1},
									{+1, -2},
									{-1, -2},
									{-2, -1}  };

	public static void main(String[] args){
		println("Welcome to the Knight Move calculator.\n");
	}

	public static void showKnightMoves(String piecePlacement){
		int[][] board = new int[8][8];

		String kSquare = piecePlacement;
		Pos kPos = convertSquareToPos(kSquare);

		// do{
		// 	print("Enter the knight's position ");
		// 	kSquare = sc.nextLine();
		// 	kPos = convertSquareToPos(kSquare);
		// } while (kPos == null);

		board[kPos.x][kPos.y] = 1;
		println("\nThe knight is at square " + convertPosToSquare(kPos));
		println("From here the knight can move to:");
		if(knightMoves.length >= 1){
			for (int move = 0; move < knightMoves.length; move++){
				boolean lastCheck = (move == knightMoves.length - 1);
				int x, y;
				x = knightMoves[move][0];
				y = knightMoves[move][1];
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
			println("Nowhere.  You have no moves when you place your knight here!");
	}

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

	// public static boolean getYorN(String prompt){
	// 	while(true){
	// 		String answer;
	// 		print("\n" + prompt + " (Y or N) ");
	// 		answer = sc.nextLine();

	// 		if(answer.equalsIgnoreCase("Y"))
	// 			return true;
	// 		else if(answer.equalsIgnoreCase("N"))
	// 			return false;
	// 	}
	// }

	public static void println(Object line){
		System.out.println(line);
	}
	public static void print(Object line){
		System.out.print(line);
	}

}


class Pos{
	public int x;
	public int y;

	public Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}