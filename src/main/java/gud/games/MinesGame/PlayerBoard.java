package gud.games.MinesGame;

public class PlayerBoard {
    String[][] board;

    public PlayerBoard(int rows, int columns) {
        board = new String[rows+1][columns+1];

/*        for (String[] x : board) {
            for (String y : x) {
                y = "#";
                System.out.print(y + " ");
            }
            System.out.println();
        }*/

        char legendUp = 'a';
        char legendLeft = 'a';

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (row == 0 & column >=1) {
                    board[row][column] = Character.toString(legendUp);
                    legendUp++;
                } else if (row >= 1 & column == 0) {
                    board[row][column] = Character.toString(legendLeft);
                    legendLeft++;
                } else if (row == 0 & column == 0) {
                    board[row][column] = " ";
                } else
                    board[row][column] = "#";

            }
        }


/*        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = "#";
                //System.out.print(board[row][column] + " ");
            }
            //System.out.println();
        }*/
    }

    public void overwrite(int row, int column, int points) {
        String numberOfBombs = Integer.toString(points);
        board[row][column] = numberOfBombs;
        show();
    }

    public void show() {
        System.out.println("Current state of player board: ");
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }



}
