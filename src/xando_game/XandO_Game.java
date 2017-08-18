//Brinlee Oaker 17229468
package xando_game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class XandO_Game {
    //Things can be Optomized
    // -> press anykey to enter
    // -> win condition method
    // ->

    public static void main(String[] args) {
        /*
        -play or veiw history(1 or 2 boolean)
        -------play----------
        -enter names
        ***1st player is x second is O
        -promt user 1 row 
        -promt user 1 colmn
        -promt user 2 row 
        -promt user 2 col
        -print board
        -someone can win and draw can occur(define conditions)
        -gameEnd promt to save(save to text file)
        -promt to play again
        ---------view Hstory--------
        display winners and game date from txt file
         */
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
        if (WantsToPlay == 2) {
            viewFile();

        } else {
            System.out.println("Enter in 1 or 2");
        }
    }

//file handeling methods
    public static void writeToFile(String WinnerName) {
        //append
        //Player Name: winner
        //Game Date: d/a/te t:im:e
        //***************************
        String filename = "Winners.txt";
        String textToAdd = "Player Name: "+WinnerName+"\n"+"Game Date: "+"\n"
                +"*****************************************";//actuall date and time needs to be added
        //create/open txtFile
        //append
        //close
    }

    public static void viewFile() {
        BufferedReader reader = null;
        String textFile = "Winners.txt";
        try {
            reader = new BufferedReader(new FileReader(textFile));
            String line = "";
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    System.out.print(line + "\n");
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
