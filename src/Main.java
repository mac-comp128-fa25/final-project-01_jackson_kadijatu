import java.util.ArrayList;

/**
 * This is the main class for the game
 */

public class Main {
    private int numCustomers = 6;

    private boolean[][] adjMatrix = new boolean[numCustomers][numCustomers];

    // for(int i = 0; i< adjMatrix.length; i++ ){
    //     for(int j =0; j< adjMatrix[i].length; j++){

    //     }
    // }


    //Should be in its own class
    public void makeInitGraph(){
        adjMatrix[0][1] = true;
    }





}
