import java.util.Scanner;

public class TicTacToe {
	
	public static void playerWins(String str) {
		System.out.println();
		System.out.println(str + " Wins!!!");
	}
	
	public static boolean checkWin(char[][] arr) {
		int xTally = 0;
		int oTally = 0;
		
//		Checks for 3 in a row horizontally
		outerloop:
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 'X') {
					xTally++;
				} else if (arr[i][j] == 'O') {
					oTally++;
				}
			} if (xTally == arr[0].length) {
				playerWins("X");
				break outerloop;
			} else if (oTally == arr[0].length) {
				playerWins("O");
				break outerloop;
			}
			xTally = 0;
			oTally = 0;
		}
		
		if (xTally == 3 || oTally == 3) {
			return true;
		}
		
//		Checks for 3 in a row vertically
		outerloop:
			for (int i = 0; i < arr[0].length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					if (arr[j][i] == 'X') {
						xTally++;
					} else if (arr[j][i] == 'O') {
						oTally++;
					}
				} if (xTally == arr[0].length) {
					playerWins("X");
					break outerloop;
				} else if (oTally == arr[0].length) {
					playerWins("");
					break outerloop;
				}
				xTally = 0;
				oTally = 0;
			}
		
		if (xTally == 3 || oTally == 3) {
			return true;
		} 
		
//		Checks for 3 in a row diagonally
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][i] == 'X') {
				xTally++;
			} else if (arr[i][i] == 'O') {
				oTally++;
			}
		}
		
		if (xTally == 3) {
			playerWins("X");
			return true;
		} else if (oTally == 3) {
			playerWins("O");
			return true;
		}
		
		xTally = 0;
		oTally = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][arr.length - i - 1] == 'X') {
				xTally++;
			} else if (arr[i][arr.length - i - 1] == 'O') {
				oTally++;
			}
		}
		
		if (xTally == 3) {
			playerWins("X");
			return true;
		} else if (oTally == 3) {
			playerWins("O");
			return true;
		} else {
			return false;
		}
	}
		
	public static void main(String[] args) {
		char[][] twoDArray = new char[3][3];
		
		for (int i = 0; i < twoDArray.length; i++) {
			for (int j = 0; j < twoDArray.length; j++) {
				twoDArray[i][j] = ' ';
			}
		}
		
		int turnNumber = 1;
		int completionTest = 0;
		
		
		while (completionTest < 9) {
			completionTest = 0;
			
			Scanner input = new Scanner(System.in);
			System.out.println();
			System.out.println("Where do you want to place your mark?");
			System.out.println("Use this format: (x, y).");
			String [] arr = input.nextLine().split(",");
			int x = Integer.parseInt(arr[0].trim());
			int y = Integer.parseInt(arr[1].trim());
			
			if ((turnNumber % 2 == 0)) {
				if (twoDArray[x][y] == ' ') {
					twoDArray[x][y] = 'X';
				}
				turnNumber++;
			} else {
				if (twoDArray[x][y] == ' ') {
					twoDArray[x][y] = 'O';
				}
				turnNumber++;
			}
			
			System.out.println("Current Board: ");
			System.out.println();
			for (int i = 0; i < twoDArray.length; i++) {
				for (int j = 0; j < twoDArray.length; j++) {
					System.out.print(twoDArray[i][j] + " ");
					if (twoDArray[i][j] != ' ') {
						completionTest++;
					}
				}
				System.out.println();
			}
			boolean gameOver = checkWin(twoDArray);
			if (gameOver) {
				System.out.println("The 2D array has been completely filled!");
				input.close();
				break;
			}
		}
		
	}
}