package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n🎮 WELCOME TO TIC TAC TOE 🎮");
        System.out.println();
        System.out.println("RULES:");
        System.out.println("1. Tic Tac Toe is played on a 3x3 grid.");
        System.out.println("2. Two players take turns placing their symbol.");
        System.out.println("3. The first player to get 3 symbols in a row wins.");
        System.out.println("4. Rows, columns, and diagonals count.");
        System.out.println();
        System.out.println("This round, you are playing as: X");
        System.out.println();
        System.out.println("Below is an example board.");
        System.out.println("Use numbers from 1 to 9 to choose your position:");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        while (true) {

            Board board = new Board();

            TicTacToe tictactoe = new TicTacToe();

            while (true) {
                System.out.println("Enter your placement (1 - 9): ");
                int playerPosition = scanner.nextInt();
                System.out.println("You chose position " + playerPosition);

                tictactoe.playerTurn(board.gameBoard, playerPosition, "player");
                board.printGameBoard();
                String result = tictactoe.checkWinner();
                if (!result.equals("")) {
                    System.out.println(result);
                    break;
                }

                int cpuPosition = tictactoe.generateCpuPosition();
                System.out.println("CPU chose position " + cpuPosition);

                tictactoe.playerTurn(board.gameBoard, cpuPosition, "CPU");
                board.printGameBoard();

                result = tictactoe.checkWinner();
                if (!result.equals("")) {
                    System.out.println(result);
                    break;
                }
            }
            System.out.println("Do you want to play again? (y/n)");
            System.out.println("Type 'n' to exit. Type anything else to play again.");
            scanner.nextLine();
            String restart = scanner.nextLine();
            if (restart.equalsIgnoreCase("n")) {
                break;
            }
        }
        scanner.close();
        System.out.println("Thanks for playing!");
    }
}