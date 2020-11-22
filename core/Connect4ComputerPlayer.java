package core;
import java.util.Random;
public class Connect4ComputerPlayer {

    private Random rand;

    public Connect4ComputerPlayer(){
        rand = new Random();
    }

    public int compMove(){
        return rand.nextInt(7);
    }
}
