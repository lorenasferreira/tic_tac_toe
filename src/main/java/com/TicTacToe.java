package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToe {

    public void playerTurn(char[][] gameBoard, int position, String user) {

        if (playerPositions.contains(position) || cpuPositions.contains(position)) {
            System.out.println("This position is already taken! Please choose another one.");
            return;
        }

        char symbol;

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("CPU")) {
            symbol = 'O';
            cpuPositions.add(position);
        } else {
            System.out.println("Invalid user.");
            return;
        }

        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;

            default:
                System.out.println("Invalid position.");
        }
    }

    ArrayList<Integer> playerPositions = new ArrayList<>();
    ArrayList<Integer> cpuPositions = new ArrayList<>();

    Random random = new Random();

    public int generateCpuPosition() {
        int cpuPosition = random.nextInt(9) + 1;
        while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
            cpuPosition = random.nextInt(9) + 1;
        }
        return cpuPosition;
    }

    public String checkWinner() {

        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);

        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);

        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);

        List<List<Integer>> winning = new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);

        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);

        winning.add(cross1);
        winning.add(cross2);

        for (List<Integer> l : winning) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins!";
            }
        }
        if (playerPositions.size() + cpuPositions.size() == 9) {
            return "It's a tie";
        }
        return "";
    }
}