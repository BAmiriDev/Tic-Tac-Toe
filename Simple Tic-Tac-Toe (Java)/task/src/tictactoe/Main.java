package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] board = "_________".toCharArray(); // Start with empty board

        printBoard(board);

        char currentPlayer = 'X';

        while (true) {
            int index;
            while (true) {
                String xStr = scanner.next();
                String yStr = scanner.next();

                if (xStr.length() != 1 || yStr.length() != 1 || !Character.isDigit(xStr.charAt(0)) || !Character.isDigit(yStr.charAt(0))) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                int row = Integer.parseInt(xStr);
                int col = Integer.parseInt(yStr);

                if (row < 1 || row > 3 || col < 1 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                index = (row - 1) * 3 + (col - 1);
                if (board[index] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                break;
            }

            board[index] = currentPlayer;
            printBoard(board);

            String[] win = {
                    board[0] + "" + board[1] + board[2],
                    board[3] + "" + board[4] + board[5],
                    board[6] + "" + board[7] + board[8],
                    board[0] + "" + board[3] + board[6],
                    board[1] + "" + board[4] + board[7],
                    board[2] + "" + board[5] + board[8],
                    board[0] + "" + board[4] + board[8],
                    board[2] + "" + board[4] + board[6]
            };

            boolean xWin = false, oWin = false;
            for (int i = 0; i < win.length; i++) {
                if (win[i].equals("XXX")) xWin = true;
                if (win[i].equals("OOO")) oWin = true;
            }

            if (xWin) {
                System.out.println("X wins");
                break;
            } else if (oWin) {
                System.out.println("O wins");
                break;
            } else if (new String(board).indexOf('_') == -1) {
                System.out.println("Draw");
                break;
            }

            currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        }

        scanner.close();
    }

    public static void printBoard(char[] board) {
        System.out.println("---------");
        for (int i = 0; i < 9; i += 3) {
            System.out.print("| ");
            System.out.print(board[i] + " ");
            System.out.print(board[i + 1] + " ");
            System.out.print(board[i + 2] + " ");
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
