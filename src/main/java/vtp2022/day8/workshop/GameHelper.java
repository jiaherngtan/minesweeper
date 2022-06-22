package vtp2022.day8.workshop;

import java.io.Console;

public class GameHelper {
    // generate game board
    public int[][] resultBoard() {
        int[][] board = new int[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
        // get 10 random num to insert as bombs
        int i = 0;
        while (i < 10) {
            int row = (int) (Math.random() * 10);
            int col = (int) (Math.random() * 10);
            if (8 != board[row][col]) {
                board[row][col] = 8;
                i++;
            }
        }
        // tabulate the rest of the board
        // handle corner cases
        for (int x = 0; x < board.length; x++) {
            // handle left edge
            if (board[x][0] >= 8 && x != 0 && x != 9) {
                board[x][1]++;
                board[x - 1][0]++;
                board[x - 1][1]++;
                board[x + 1][0]++;
                board[x + 1][1]++;
            }
            // handle right edge
            if (board[x][9] >= 8 && x != 0 && x != 9) {
                board[x][8]++;
                board[x - 1][9]++;
                board[x - 1][8]++;
                board[x + 1][9]++;
                board[x + 1][8]++;
            }
            // handle top edge
            if (board[0][x] >= 8 && x != 0 && x != 9) {
                board[1][x]++;
                board[0][x - 1]++;
                board[1][x - 1]++;
                board[0][x + 1]++;
                board[1][x - 1]++;
            }
            // handle bottom edge
            if (board[9][x] >= 8 && x != 0 && x != 9) {
                board[8][x]++;
                board[9][x - 1]++;
                board[8][x + 1]++;
                board[9][x - 1]++;
                board[8][x + 1]++;
            }
        }

        // handle non-corner cases
        for (int x = 1; x < board.length - 1; x++) {
            for (int y = 1; y < board[x].length - 1; y++) {
                if (board[x][y] >= 8) {
                    board[x - 1][y]++;
                    board[x - 1][y - 1]++;
                    board[x - 1][y + 1]++;
                    board[x + 1][y]++;
                    board[x + 1][y - 1]++;
                    board[x + 1][y + 1]++;
                    board[x][y - 1]++;
                    board[x][y + 1]++;
                }
            }
        }
        return board;
    }

    // getUserInput function
    public int[] getUserInput() {
        Console cons = System.console();
        String inputString = cons.readLine("Where would you like to dig? Input as row,col: ");
        String[] terms = inputString.split(",");
        int[] input = { Integer.parseInt(terms[0]), Integer.parseInt(terms[1]) };
        return input;
    }
}