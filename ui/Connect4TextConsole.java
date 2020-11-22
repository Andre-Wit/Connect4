package ui;
import java.util.Scanner;
import core.Connect4;
import core.Connect4ComputerPlayer;

public class Connect4TextConsole {
    private static Scanner input;
    private static Connect4 Game;
    private static int mode;
    private static Connect4ComputerPlayer comp;
    private static int colN;

    public static void main(String[] args) {
        Game = new Connect4();
        input = new Scanner(System.in);
        mode = gameMode();
        colN = 0;
        newGame(Game);
    }

    public static void newGame(Connect4 G){
        if(mode == 2){
            comp = new Connect4ComputerPlayer();
        }
        while(G.getStatus() == 0){
            if(G.getCurP() == 1){
                if(mode == 1){
                    System.out.println("Red, choose a column from 1-7:");
                }else if(mode == 2){
                    System.out.println("Red, choose a column from 1-7:");
                }else{ System.out.println("Error with Mode:1"); }
            }else if(G.getCurP() == 2){
                if(mode == 1){
                    System.out.println("Yellow, choose a column from 1-7:");
                }else if(mode == 2){
                    System.out.println("Computer is now choosing a column.");
                }else{ System.out.println("Error with Mode:1"); }
            }else{ System.out.println("Error with CurP:1"); }
            if(G.getCurP() == 1){
                colN = input.nextInt() -1;
            }else if(G.getCurP() == 2){
                if(mode == 1){
                    colN = input.nextInt() -1;
                }else if(mode == 2){
                    colN = comp.compMove();
                }else{
                    System.out.println("Error with Mode:2");
                }
            }else{ System.out.println("Error with CurP:2"); }
            if(colN >= 0 && colN <= 6){
                if(G.validMove(colN)) {
                    // System.out.println("Valid Move");
                    G.setDrop(colN, G.getCurP());
                    // System.out.println("Move Dropped"); Used to test
                    G.printBoard();
                }else {
                    System.out.println("Error, this value is not in the range.");
                }
            }else{
                System.out.println("Error, this value is not in the range.");
            }
        }
        System.out.println("Would you like to play again? Enter 'Y' for yes, Enter 'N' for no.");
        char in = input.next().charAt(0);
        if(in == 'Y' || in == 'y'){
            Game = new Connect4();
            mode = gameMode();
            colN = 0;
            newGame(Game);
        }
    }

    public static int gameMode(){
        System.out.println("Enter 'P' for player Co-op or 'C' for computer");
        char in = input.next().charAt(0);
        if(in == 'P' || in == 'p'){
            System.out.println("You have chosen to play Co-OP.");
            return 1;
        }else if(in == 'C' || in == 'c'){
            System.out.println("You have chosen to play against the Computer.");
            return 2;
        }else{
            System.out.println("There was an error with your entry.");
            return gameMode();
        }


    }
}