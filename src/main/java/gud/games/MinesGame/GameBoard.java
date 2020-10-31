package gud.games.MinesGame;

import java.util.Random;

public class GameBoard {
    int counter;
    private Random random;
    int arm = 1;
    int a;
    int b;
    String[][] board;

    public GameBoard(int rows, int columns, int mines) {
        board = new String[rows+1][columns+1];
        char legendUp = 'a';
        char legendLeft = 'a';

        // Empty board:
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    if (row == 0 & column >= 1) {
                        board[row][column] = Character.toString(legendUp);
                        legendUp++;
                    } else if (row >= 1 & column == 0) {
                        board[row][column] = Character.toString(legendLeft);
                        legendLeft++;
                    } else if (row == 0 & column == 0) {
                        board[row][column] = " ";
                    } else {
                        board [row][column] = "-";
                    }
                }
            }
         // Arming:
        random = new Random();
        do {
            a = random.nextInt(rows)+1;
            b = random.nextInt(columns)+1;
/*            if (board[a][b].equals("B")) {     // protection against overwriting
                arm--;
            }*/
            board[a][b] = "B";
            arm++;
        } while (arm <= mines);

    }

    public String getEl(int rows, int columns) {
        return board[rows][columns];
    }

    public void show() {
        System.out.println("Board With Mines: ");
            for (int row = 0; row < board.length; row++) {
                for (int column = 0; column < board[row].length; column++) {
                    System.out.print(board[row][column] + " ");
                }
                System.out.println();
            }
    }

    public void counter (int row, int column) {
        counter = 0;
        byte upEnd = 1;
        byte downEnd = 1;
        byte rightEnd = 1;
        byte leftEnd = 1;

        if (row == 0 & column == 0) {
            upEnd = 0;
            leftEnd = 0;
        } else if (row == 0 & column != 0 & column != board[0].length - 1) {
            upEnd = 0;
        } else if (row == 0 & column == board[0].length - 1) {
            upEnd = 0;
            rightEnd = 0;
        } else if (row != 0 & row!= board.length - 1 & column == 0) {
            leftEnd = 0;
        } else if (row != 0 & row!= board.length - 1 & column == board[0].length - 1) {
            rightEnd = 0;
        } else if (row == board.length - 1 & column == 0) {
            downEnd = 0;
            leftEnd = 0;
        } else if (row == board.length - 1 & column != 0 & column != board[0].length - 1) {
            downEnd = 0;
        } else if (row == board.length - 1 & column == board[0].length - 1){
            downEnd = 0;
            rightEnd = 0;
        }

        for (int i = row - upEnd; i <= row + downEnd ; i++) {
            for (int j = column - leftEnd; j <= column + rightEnd; j++) {
                if (board[i][j].equals("B"))
                    counter++;
            }
        }
        System.out.println("sum of points: " + counter);
    }


    public int getCounter(){
        return counter;
    }


    public boolean isThisBomb (int row, int column) {
        boolean bomb = false;

        if (board[row][column] == "B") {
            bomb = true;
        }

        return bomb;
    }
    }
