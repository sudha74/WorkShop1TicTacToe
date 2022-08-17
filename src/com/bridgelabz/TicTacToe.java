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
        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
    }

    static void getLetter() {
        System.out.println("Choose the Letter(X or O)");
        playerLetter = scanner.next().toUpperCase().charAt(0);
        computerLetter = (playerLetter == 'X') ? 'O' : 'X';
        System.out.println("Your Letter is " + playerLetter);
        System.out.println("Computer Letter " + computerLetter);
    }

    static void showBoard(char[] board) {
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
    }

    static void makeMove(int position, char currentPlayerLetter, char[] board) {
        switch (position) {
            case 1:
                if (board[1] == ' ')
                    board[1] = currentPlayerLetter;
                break;
            case 2:
                if (board[2] == ' ')
                    board[2] = currentPlayerLetter;
                break;
            case 3:
                if (board[3] == ' ')
                    board[3] = currentPlayerLetter;
                break;
            case 4:
                if (board[4] == ' ')
                    board[4] = currentPlayerLetter;
                break;
            case 5:
                if (board[5] == ' ')
                    board[5] = currentPlayerLetter;
                break;
            case 6:
                if (board[6] == ' ')
                    board[6] = currentPlayerLetter;
                break;
            case 7:
                if (board[7] == ' ')
                    board[7] = currentPlayerLetter;
                break;
            case 8:
                if (board[8] == ' ')
                    board[8] = currentPlayerLetter;
                break;
            case 9:
                if (board[9] == ' ')
                    board[19] = currentPlayerLetter;
                break;
            default:
                break;

        }
    }

    static void playerMove() {
        System.out.println("Enter the position(1-9)");
        position = scanner.nextInt();
        while (board[position] != ' ') {
            System.out.println("Invalid option!! please try again");
            position = scanner.nextInt();

        }
        makeMove(position, playerLetter, board);
        System.out.println("player move to position " + position);
    }

    static CurrentPlayer toss() {
        if ((int) (Math.random() * 10) % 2 == 1) {
            System.out.println("player will start the game");
            return CurrentPlayer.PLAYER;
        } else {
            System.out.println("computer will start the game");
            return CurrentPlayer.COMPUTER;
        }
    }

    static boolean isWinable(char[] board) {
        for (int i = 1; i < 10; i += 3) {
            if (board[i] == computerLetter && board[i + 1] == computerLetter && board[i + 2] == ' ') {
                board[i + 2] = computerLetter;
                System.out.println("Computer Own");
                return true;
            } else if (board[i] == computerLetter && board[i + 1] == ' ' && board[i + 2] == computerLetter) {
                board[i + 1] = computerLetter;
                System.out.println("Computer Own");
                return true;
            } else if (board[i] == ' ' && board[i + 1] == computerLetter && board[i + 2] == computerLetter) {
                board[i] = computerLetter;
                System.out.println("Computer Own");
                return true;
            }
        }
        for (int i = 1; i < 4; i++) {
            if (board[i] == computerLetter && board[i + 3] == computerLetter && board[i + 6] == ' ') {
                board[i + 6] = computerLetter;
                System.out.println("Computer Own");
                return true;
            } else if (board[i] == computerLetter && board[i + 3] == ' ' && board[i + 6] == computerLetter) {
                board[i + 3] = computerLetter;
                System.out.println("Computer Own");
                return true;
            } else if (board[i] == ' ' && board[i + 3] == computerLetter && board[i + 6] == computerLetter) {
                board[i] = computerLetter;
                System.out.println("Computer Own");
                return true;
            }
        }
        if (board[1] == computerLetter && board[5] == computerLetter && board[9] == ' ') {
            board[9] = computerLetter;
            System.out.println("Computer Own");
            return true;
        } else if (board[1] == computerLetter && board[5] == ' ' && board[9] == computerLetter) {
            board[5] = computerLetter;
            System.out.println("Computer Own");
            return true;
        } else if (board[1] == ' ' && board[5] == computerLetter && board[9] == computerLetter) {
            board[1] = computerLetter;
            System.out.println("Computer Own");
            return true;
        }
        if (board[3] == computerLetter && board[5] == computerLetter && board[7] == ' ') {
            board[7] = computerLetter;
            System.out.println("Computer Own");
            return true;
        } else if (board[3] == computerLetter && board[5] == ' ' && board[7] == computerLetter) {
            board[5] = computerLetter;
            System.out.println("Computer Own");
            return true;
        } else if (board[3] == ' ' && board[5] == computerLetter && board[7] == computerLetter) {
            board[3] = computerLetter;
            System.out.println("Computer Own");
            return true;
        }
        return false;
    }

    static void computerMove() {
        position = (int) (Math.random() * 10) % 9 + 1;
        while (board[position] != ' ') {
            position = (int) (Math.random() * 10) % 9 + 1;
        }
        makeMove(position, computerLetter, board);
        System.out.println("computer moved to position " + position);
    }

    public static boolean isGameOver(char[] board, char letter) {
        boolean option1 = (board[1] == letter && board[2] == letter && board[3] == letter);
        boolean option2 = (board[4] == letter && board[5] == letter && board[6] == letter);
        boolean option3 = (board[7] == letter && board[8] == letter && board[9] == letter);
        boolean option4 = (board[1] == letter && board[4] == letter && board[7] == letter);
        boolean option5 = (board[2] == letter && board[5] == letter && board[8] == letter);
        boolean option6 = (board[3] == letter && board[6] == letter && board[9] == letter);
        boolean option7 = (board[1] == letter && board[5] == letter && board[9] == letter);
        boolean option8 = (board[3] == letter && board[5] == letter && board[7] == letter);
        if (option1 || option2 || option3 || option4 || option5 || option6 || option7 || option8) {
            if (letter == playerLetter) {
                System.out.println("Player Wins");
            } else {
                System.out.println("Computer wins !!!");
            }

            return true;
        }
        if (board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' ' && board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
            System.out.println("Tie!!");
            return true;
        }
        return false;

    }


    static boolean isBlockAble(char[] board) {
        for (int i = 1; i < 10; i += 3) {
            if (board[i] == playerLetter && board[i + 1] == playerLetter && board[i + 2] == ' ') {
                board[i + 2] = computerLetter;
                System.out.println("Computer moved to position " + (i + 2));
                return true;
            } else if (board[i] == playerLetter && board[i + 1] == ' ' && board[i + 2] == playerLetter) {
                board[i + 1] = computerLetter;
                System.out.println("Computer moved to position " + (i + 1));
                return true;
            } else if (board[i] == ' ' && board[i + 1] == playerLetter && board[i + 2] == playerLetter) {
                board[i] = computerLetter;
                System.out.println("Computer moved to position " + (i));
                return true;
            }
        }
        for (int i = 1; i < 4; i++) {
            if (board[i] == playerLetter && board[i + 3] == playerLetter && board[i + 6] == ' ') {
                board[i + 6] = computerLetter;
                System.out.println("Computer moved to position " + (i + 6));
                return true;
            } else if (board[i] == playerLetter && board[i + 3] == ' ' && board[i + 6] == playerLetter) {
                board[i + 3] = computerLetter;
                System.out.println("Computer moved to position " + (i + 3));
                return true;
            } else if (board[i] == ' ' && board[i + 3] == playerLetter && board[i + 6] == playerLetter) {
                board[i] = computerLetter;
                System.out.println("Computer moved to position " + (i));
                return true;
            }
        }
        if (board[1] == playerLetter && board[5] == playerLetter && board[9] == ' ') {
            board[9] = computerLetter;
            System.out.println("Computer moved to position 9");
            return true;
        } else if (board[1] == playerLetter && board[5] == ' ' && board[9] == playerLetter) {
            board[5] = computerLetter;
            System.out.println("Computer moved to position 5");
            return true;
        } else if (board[1] == ' ' && board[5] == playerLetter && board[9] == playerLetter) {
            board[1] = computerLetter;
            System.out.println("Computer moved to position 1");
            return true;
        }
        if (board[3] == playerLetter && board[5] == playerLetter && board[7] == ' ') {
            board[7] = computerLetter;
            System.out.println("Computer moved to position 7");
            return true;
        } else if (board[3] == playerLetter && board[5] == ' ' && board[7] == playerLetter) {
            board[5] = computerLetter;
            System.out.println("Computer moved to position 5");
            return true;
        } else if (board[3] == ' ' && board[5] == playerLetter && board[7] == playerLetter) {
            board[3] = computerLetter;
            System.out.println("Computer moved to position 3");
            return true;
        }
        return false;
    }

    static boolean takeCornerOrCenter(char[] board, char letter) {
        if (board[1] == ' ') {
            board[1] = letter;
            return true;
        } else if (board[3] == ' ') {
            board[3] = letter;
            return true;
        } else if (board[7] == ' ') {
            board[7] = letter;
            return true;
        } else if (board[9] == ' ') {
            board[9] = letter;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CurrentPlayer currentPlayer = toss();
        createBoard(board);
        getLetter();
        boolean isBlockAble;
        boolean isGameOver = true;
        boolean isWinable;
        while (true) {
            if (currentPlayer == CurrentPlayer.PLAYER) {
                playerMove();
                isGameOver = isGameOver(board, playerLetter);
            } else {
                isWinable = isWinable(board);
                if (isWinable) {
                    showBoard(board);
                    break;
                }
                isBlockAble = isBlockAble(board);
                if (!isBlockAble) {
                    boolean takeCornerOrCenter = takeCornerOrCenter(board, computerLetter);
                    if (!takeCornerOrCenter) {
                        computerMove();
                    }
                    isGameOver = isGameOver(board, computerLetter);
                }
                showBoard(board);
                if (isGameOver) {
                    break;
                }
                currentPlayer = (currentPlayer == CurrentPlayer.COMPUTER) ? CurrentPlayer.PLAYER : CurrentPlayer.COMPUTER;
            }
        }
    }
}









