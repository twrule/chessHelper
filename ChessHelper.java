import java.util.Scanner;

public class ChessHelper{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		println("Hello World!");
		print("Please Enter Something: ");
		String check = sc.nextLine();
		println(check);
	}



	static void println(Object line){
		System.out.println(line);
	}
	static void print(Object line){
		System.out.print(line);
	}
}
