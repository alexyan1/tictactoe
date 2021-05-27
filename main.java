import java.util.Scanner;

class Main {
  	public static void main(String[] args) {
		System.out.println("WELCOME TO TICTACTOE \n by Alex Yan");

		Scanner scan = new Scanner(System.in);

		String[][] board = {
			{"_ ", "_ ", "_ "},
			{"_ ", "_ ", "_ "},
			{"_ ", "_ ", "_ "},
		};

		int row = 0;
		int col = 0;

		boolean gameOver = false;
		boolean error = false;
		boolean turn = true; //true represents player 1's turn, false represents player 2's turn

		String symbol = "X ";

		//game flow
		while(gameOver == false) {
			error = false;
			if(turn) {
				System.out.println("PLAYER 1'S TURN");
				System.out.println("-------------------");
			} else {
				System.out.println("PLAYER 2'S TURN");
				System.out.println("-------------------");
			}
			
			System.out.println("Row: ");
			row = scan.nextInt();
			System.out.println("Column: ");
			col = scan.nextInt();


			if(!turn) {
				symbol = "X ";
			} else {
				symbol = "O ";
			}

			if (!board[row][col].equals("_ ") || row > 2 || col > 2) {
				error = true;
				System.out.println("ERROR DETECTED. TRY AGAIN");
			} else {
				board[row][col] = symbol;
			}
			
			System.out.println();
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			//determine if win or not
			String line = "";
			
			for(int i = 0; i < 8; i++) {
				switch(i) {
					case 0:
						line = board[0][0] + board[0][1] + board[0][2];
						break;
					case 1: 
						line = board[1][0] + board[1][1] + board[1][2];
						break;
					case 2:
						line = board[2][0] + board[2][1] + board[2][2];
						break;
					case 3:
						line = board[0][0] + board[1][0] + board[2][0];
						break;
					case 4:
						line = board[0][1] + board[1][1] + board[2][1];
						break;
					case 5:
						line = board[0][2] + board[1][2] + board[2][2];
						break;
					case 6:
						line = board[0][0] + board[1][1] + board[2][2];
						break;
					case 7:
						line = board[2][0] + board[1][1] + board[0][2];
						break;
				}
				if (line.equals("X X X ")) {
					System.out.println();
					System.out.println("X WINS");
					gameOver = true;
				} else if (line.equals("O O O ")) {
					System.out.println();
					System.out.println("O WINS");
					gameOver = true;
				}
			}
			System.out.println("-------------------");
			if(!error) {turn = !turn;}
		}	
  }
}
