//Brinlee Oaker 17229468
package xando_game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class XandO_Game {


    public static void main(String[] args) {

        int WantsToPlay;
        int rounds = 1;
        Game XOGame = new Game();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a (1) to start the game or (2) to view the game history: ");
        WantsToPlay = sc.nextInt();
        System.out.println("");
        while (WantsToPlay == 1) { // edit to loop
            XOGame.setPlayerX();
            XOGame.setPlayerO();
            do {
                System.out.println("");
                System.out.println("****************************************");
                System.out.println("ROUND " + rounds + ":");
                System.out.println("****************************************");
                XOGame.playerTurn(rounds);
                rounds += 1;
                XOGame.printBoard();
                XOGame.Wincheck(rounds);
            } while (XOGame.isWinner() == false && rounds < 9);
            if (XOGame.isWinner()) {
                System.out.println("Would you like to save the game? Enter a (1) to save the game or any other key to continue");
                int saveOption = sc.nextInt();
                if (saveOption == 1) {
                    writeToFile(XOGame.getWinPlayer());
                }
            } else {
                System.out.println("Game is a draw");
            }
            System.out.println("Would you like to play again? Press (x) to exit or any other key to play again.");
            String playChoice = sc.next();
            if (playChoice.equalsIgnoreCase("x")) {
                WantsToPlay = 3;
            }
        }
        if (WantsToPlay == 2 || WantsToPlay == 1) {
            viewFile();
} 
        else {
            System.out.println("Enter in 1 or 2");
        }
    }

//file handeling methods
    public static void writeToFile(String WinnerName) {
        String origionalData = "";
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date winDate = new Date();
        String textToAdd = "Player Name: " + WinnerName + "\n"
                + "Game Date: " + df.format(winDate) + "\n"
                + "*****************************************";
        Scanner sc;
        try {
            try {
                sc = new Scanner(new File("Winners.txt"));
                while (sc.hasNext()) {
                    origionalData += sc.nextLine() + "\n";
                }
            } catch (Exception e) {
                origionalData = "";
            }

            Formatter file = new Formatter("Winners.txt");
            file.format("%s", origionalData + textToAdd);
            file.close();
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
}
    
    public static void viewFile() {
        String output = "";
        Scanner read;
        try {
            read = new Scanner(new File("Winners.txt"));
            while (read.hasNext()) {
                output += read.nextLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println("no file to display from");
        }
        System.out.println(output);
    }
}
