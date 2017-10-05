package xando_game;

import java.util.Scanner;

public class Game {

    Scanner gameInput = new Scanner(System.in);
    private String PlayerX;
    private String PlayerO;
    private String winPlayer;
    private boolean Winner = false;
    private char[][] Board = new char[3][3];

    public Game() {

    }

    public String getPlayerX() {
        return PlayerX;
    }

    public void setPlayerX() {
        System.out.print("Enter player (X) name:");
        String temp = gameInput.next();
        this.PlayerX = temp;
    }

    public String getPlayerO() {
        return PlayerO;
    }

    public void setPlayerO() {
        System.out.print("Enter player (Y) name:");
        String temp = gameInput.next();
        this.PlayerO = temp;
    }

    public boolean isWinner() {
        return Winner;
    }

    public void Wincheck(int rounds) {
        if (Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2] && Board[1][1] != 0
                || // Diagonal           
                Board[2][0] == Board[1][1] && Board[1][1] == Board[0][2] && Board[1][1] != 0
                || // Diagonal
                Board[0][0] == Board[0][1] && Board[0][1] == Board[0][2] && Board[0][1] != 0
                || // Row 1
                Board[1][0] == Board[1][1] && Board[1][1] == Board[1][2] && Board[1][1] != 0
                || // Row 2
                Board[2][0] == Board[2][1] && Board[2][1] == Board[2][2] && Board[2][1] != 0
                || // Row 3
                Board[0][0] == Board[1][0] && Board[1][0] == Board[2][0] && Board[1][0] != 0
                || // Column 1
                Board[0][1] == Board[1][1] && Board[1][1] == Board[2][1] && Board[1][1] != 0
                || // Column 2
                Board[0][2] == Board[1][2] && Board[1][2] == Board[2][2] && Board[1][2] != 0) { // Column 3 
            if (rounds % 2 == 0) {
                System.out.println("");
                System.out.println(WinMessage(PlayerX));
                winPlayer = PlayerX;
            } else {
                System.out.println("");
                System.out.println(WinMessage(PlayerO));
                winPlayer = PlayerO;
            }
            Winner = true;
        }
    }
 //the message displayed when someone wins
    public String WinMessage(String winnerName) {
        return ("Congratualtions " + winnerName + " you are the winner!!!");
    }

    public void printBoard() {
        System.out.print(" |1|2|3 ");
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            System.out.print(i + 1 + "");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + Board[i][j]);
            }
        }
    }

    public String getWinPlayer() {
        return winPlayer;
    }

    public void playerTurn(int turnNumber) {
        if (turnNumber % 2 != 0) {
            System.out.print(PlayerX + " Please enter row number: ");
            int row = gameInput.nextInt();
            System.out.print(PlayerX + " Please enter column number: ");
            int col = gameInput.nextInt();
            Board[row - 1][col - 1] = 'X';
        } else {
            System.out.print(PlayerO + " Please enter row number: ");
            int row = gameInput.nextInt();
            System.out.print(PlayerO + " Please enter column number: ");
            int col = gameInput.nextInt();
            Board[row - 1][col - 1] = 'O';
        }
    }
}
