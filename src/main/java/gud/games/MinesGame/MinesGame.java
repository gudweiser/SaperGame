package gud.games.MinesGame;

import java.util.Scanner;

public class MinesGame {
    private GameBoard gameBoard;
    private PlayerBoard playerBoard;
    //private Scanner scanner;
    boolean isEnded = false;
    int counterForAction = 0;



    public MinesGame() {
        Scanner scanner = new Scanner(System.in);           // local scanner initiation
        System.out.println("Welcome to Mines Game by Andrew!");
        System.out.print("Enter the number of lines (max value 26): ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns (max value 26): ");
        int columns = scanner.nextInt();
        System.out.print("Enter the number of mines: ");
        int mines = scanner.nextInt();
        // Checking user input:
        if (rows > 26 | columns > 26 | mines > rows * columns - 1) {
            System.out.println("You Entered The Wrong Parameters");
            gameOver();
        }
        gameBoard = new GameBoard(rows, columns, mines);    // creating the game board
        //gameBoard.show();                                   // displaying the game board
        playerBoard = new PlayerBoard(rows, columns);       // creating the player board
    }

    public void start(){
        playerBoard.show();

        do {
            System.out.println("Enter coordinates for check ( row / column ): ");
            int[] userCo = readUserCo();
            disarm(userCo);
        } while (!isEnded);
    }



    private int[] readUserCo() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        int row = (int)userInput.charAt(0)-96;          // not 97 because we need to start from 1
        int column =  (int)userInput.charAt(1)-96;      // not 97 because we need to start from 1
        int[] coordinates = {row, column};
        System.out.println("You choose row nr " + userInput.charAt(0) + " and column nr " + userInput.charAt(1) + ".");
        return coordinates;
    }

    private void disarm(int[] coordinates) {

        if (gameBoard.isThisBomb(coordinates[0],coordinates[1])) {
            isEnded = true;
            gameOver();
        } else {
            gameBoard.counter(coordinates[0], coordinates[1]);
            int sum = gameBoard.getCounter();
            numberToPlayerBoard(coordinates[0],coordinates[1], sum);


/*            playerBoard.board[coordinates[0]][coordinates[1]] = Integer.toString(sum);
            System.out.println("sum sum" + sum);
            playerBoard.overwrite(coordinates[0], coordinates[1], sum);*/
        }
    }

    private void numberToPlayerBoard(int row, int column, int value){

        playerBoard.overwrite(row, column, value);
    }

    private void gameOver() {
        System.out.println("You lost!");
        gameBoard.show();
    }


}
