import java.util.Scanner;

public class ChessHelper{

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		println("\nWelcome to your Chess Helper.\n");
		boolean continuePlaying = true;
		String chessPiece;
		String piecePlacement;
		int playSamePiece = 1;

		while(continuePlaying){
			if(playSamePiece == 0){
				playSamePiece = 1;
			}
			
			chessPiece = getPiece();
			piecePlacement = getPlacement(chessPiece);

			if(chessPiece.equalsIgnoreCase("Pawn")){
				while(playSamePiece == 1){
					KnightHelper pawnHelper = new KnightHelper();
					pawnHelper.showMoves(piecePlacement, chessPiece);
					playSamePiece = askPlaySamePiece();
					println("\n\n---------------------------------------\n\n");
					if(playSamePiece == 1)
						piecePlacement = repeatPlacement(chessPiece);
				}
			}
			else if(chessPiece.equalsIgnoreCase("Knight")){
				while(playSamePiece == 1){
					KnightHelper knightHelper = new KnightHelper();
					knightHelper.showMoves(piecePlacement, chessPiece);
					playSamePiece = askPlaySamePiece();
					println("\n\n---------------------------------------\n\n");	
					if(playSamePiece == 1)
						piecePlacement = repeatPlacement(chessPiece);
				}	
			}

			if(playSamePiece == 3)
				continuePlaying = false;
			else
				continuePlaying = true;
		}
	}

	// Gets user inputted chess piece
	static String getPiece(){
		Boolean wrongPiece = true;

		println("Would you like to study Pawn, Bishop, Knight, Rook, Queen, King?");
		print("Please enter your choice: ");
		String nextPiece = sc.nextLine();
		println("");

		// Checks to see if requested piece is permitted
		if(nextPiece.equalsIgnoreCase("Pawn") || nextPiece.equalsIgnoreCase("Bishop") || 
				nextPiece.equalsIgnoreCase("Knight") || nextPiece.equalsIgnoreCase("Rook") ||
				nextPiece.equalsIgnoreCase("Queen") || nextPiece.equalsIgnoreCase("King")){
			wrongPiece = false;
		}

		// Continuous loop until permitted piece is input
		while(wrongPiece){
			println("Not a recognized piece, please try again.");

			println("Would you like to study Pawn, Bishop, Knight, Rook, Queen, King?");
			print("Please enter your choice: ");
			nextPiece = sc.nextLine();
			println("");

			if(nextPiece.equalsIgnoreCase("Pawn") || nextPiece.equalsIgnoreCase("Bishop") || 
					nextPiece.equalsIgnoreCase("Knight") || nextPiece.equalsIgnoreCase("Rook") ||
					nextPiece.equalsIgnoreCase("Queen") || nextPiece.equalsIgnoreCase("King")){
				wrongPiece = false;
			}
		}


		return nextPiece;
		
	}

	static String repeatPlacement(String piece){
		Boolean wrongPlace = true;

		print("Enter a new place to put your " + piece + ": ");
		
		String piecePosition = sc.nextLine();
		println(" ");

		// Checks to see if inputted placement is permitted
		if(piecePosition.length() == 2 && piecePosition.charAt(0) >= 97 
				&& piecePosition.charAt(0) <= 104 && piecePosition.charAt(1) >= 49
				&& piecePosition.charAt(1) <= 56){
			wrongPlace = false;
		}

		// Loop until placement is permitted
		while(wrongPlace){
			println("You cannot place your " + piece + " here. Please try again.");
			print("Enter the " + piece + "\'s position: ");
		
			piecePosition = sc.nextLine();
			println(" ");

			if(piecePosition.length() == 2 && piecePosition.charAt(0) >= 97 
					&& piecePosition.charAt(0) <= 104 && piecePosition.charAt(1) >= 49
					&& piecePosition.charAt(1) <= 56){
				wrongPlace = false;
			}
		}

		return piecePosition;
	}

	// Gets user inputted piece placement
	static String getPlacement(String piece){
		Boolean wrongPlace = true;

		println("Look at the below chess board and choose a place" +
				" to put your " + piece + ".\n");

		String[][] chessBoardGraphic = initializeBoardGraphic();
		printBoard(chessBoardGraphic);

		print("Enter the " + piece + "\'s position: ");
		
		String piecePosition = sc.nextLine();
		println(" ");

		// Checks to see if inputted placement is permitted
		if(piecePosition.length() == 2 && piecePosition.charAt(0) >= 97 
				&& piecePosition.charAt(0) <= 104 && piecePosition.charAt(1) >= 49
				&& piecePosition.charAt(1) <= 56){
			wrongPlace = false;
		}

		// Loop until placement is permitted
		while(wrongPlace){
			println("You cannot place your " + piece + " here. Please try again.");
			print("Enter the " + piece + "\'s position: ");
		
			piecePosition = sc.nextLine();
			println(" ");

			if(piecePosition.length() == 2 && piecePosition.charAt(0) >= 97 
					&& piecePosition.charAt(0) <= 104 && piecePosition.charAt(1) >= 49
					&& piecePosition.charAt(1) <= 56){
				wrongPlace = false;
			}
		}

		return piecePosition;
	}

	// This probably is not neccessary, could save some memory just printing this
	// out instead of creating a 2d array that isn't used elsewhere
	public static String[][] initializeBoardGraphic(){
		String[][] board = {	{"| a8", "| b8", "| c8", "| d8", "| e8", "| f8", "| g8", "| h8 |"},
			{"| a7", "| b7", "| c7", "| d7", "| e7", "| f7", "| g7", "| h7 |"},
			{"| a6", "| b6", "| c6", "| d6", "| e6", "| f6", "| g6", "| h6 |"},
			{"| a5", "| b5", "| c5", "| d5", "| e5", "| f5", "| g5", "| h5 |"},
			{"| a4", "| b4", "| c4", "| d4", "| e4", "| f4", "| g4", "| h4 |"},
			{"| a3", "| b3", "| c3", "| d3", "| e3", "| f3", "| g3", "| h3 |"},	
			{"| a2", "| b2", "| c2", "| d2", "| e2", "| f2", "| g2", "| h2 |"},
			{"| a1", "| b1", "| c1", "| d1", "| e1", "| f1", "| g1", "| h1 |"},	};

		return board;
	}

	// Used to print the above 2d Array/ChessBoard out
	public static void printBoard(String[][] board){
		println("|----|----|----|----|----|----|----|----|");
		for(String[] row : board){
			for(String column: row){
				print(column + " ");
			}
			println("");
			println("|----|----|----|----|----|----|----|----|");
		}
		println("");
	}

	public static int askPlaySamePiece(){
		String userAnswer;
		print("Would you like to switch pieces (Y or N) or quit (Q): ");
		userAnswer = sc.nextLine();
		while(!(userAnswer.equalsIgnoreCase("Y") || userAnswer.equalsIgnoreCase("N") || userAnswer.equalsIgnoreCase("Q"))){
			println("\nInvalid input please try again.");
			print("Play same piece or quit (Y or N of Q): ");
			userAnswer = sc.nextLine();
		}

		println("");

		if(userAnswer.equalsIgnoreCase("Y"))
			return 0;
		else if(userAnswer.equalsIgnoreCase("N"))
			return 1;
		else
			return 3;
	}



	public static void println(Object line){
		System.out.println(line);
	}
	public static void print(Object line){
		System.out.print(line);
	}
}