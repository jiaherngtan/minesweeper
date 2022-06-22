package vtp2022.day8.workshop;

import java.util.Arrays;

public class Minesweeper {

    String[][] blankBoard = instantiateBlankBoard();

    public String[][] instantiateBlankBoard() {
        String[][] board = new String[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " ";
            }
        }
        return board;
    }

    public void play() {
        System.out.println("=================================");
        System.out.println("   0  1  2  3  4  5  6  7  8  9");
        for (int i = 0; i < blankBoard.length; i++) {
            System.out.println(i + " " + Arrays.toString(blankBoard[i]));
        }

        GameHelper gh = new GameHelper();
        int[][] board = gh.resultBoard();

        boolean isAlive = true;
        while (isAlive) {
            int[] input = gh.getUserInput();
            int inputRow = input[0];
            int inputCol = input[1];
            if (board[inputRow][inputCol] >= 8) {
                System.out.println("Game Over");
                blankBoard[inputRow][inputCol] = "*";
                isAlive = false;
            } else {
                blankBoard[inputRow][inputCol] = String.valueOf(board[inputRow][inputCol]);
            }
            // print out result
            System.out.println("=================================");
            System.out.println("   0  1  2  3  4  5  6  7  8  9");
            for (int i = 0; i < board.length; i++) {
                System.out.println(i + " " + Arrays.toString(blankBoard[i]));
            }
        }
    }
}
