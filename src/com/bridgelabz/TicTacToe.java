package com.bridgelabz;

import java.util.Scanner;

public class TicTacToe {
    public enum CurrentPlayer {
        PLAYER, COMPUTER
    }

    static char[] board = new char[10];
    static Scanner scanner = new Scanner(System.in);
    static char playerLetter;
    static char computerLetter;
    static int position;

    static void createBoard(char[] board) {
        for (int i = 0; i < 10; i++) {
            board[i] = ' ';
        }
    }

    public static void main(String[] args) {

    }
}
