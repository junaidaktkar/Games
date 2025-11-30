package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        
        while (playAgain) {
            playGame(sc);
            
            System.out.println("\nDo you want to play again? (y/n): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("y");
        }
        
        System.out.println("Thanks for playing!");
        sc.close();
    }
    
    public static void playGame(Scanner sc) {
        System.out.println("\n=== TIC-TAC-TOE GAME ===");
        System.out.println("Rules: X goes first, then O");
        System.out.println("Enter row (0-2) and column (0-2) to place your mark\n");
        
        char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
        print(board);
        
        int moves = 0;
        boolean gameOver = false;
        
        while (moves < 9 && !gameOver) {
            // Determine current player
            char currentPlayer = (moves % 2 == 0) ? 'X' : 'O';
            
            System.out.println("\n" + currentPlayer + "'s turn");
            
            // Get valid input
            int row = -1, col = -1;
            boolean validMove = false;
            
            while (!validMove) {
                try {
                    System.out.print("Enter Row (0-2): ");
                    row = sc.nextInt();
                    
                    System.out.print("Enter Column (0-2): ");
                    col = sc.nextInt();
                    
                    // Validate input
                    if (row < 0 || row > 2 || col < 0 || col > 2) {
                        System.out.println("Invalid input! Row and column must be between 0 and 2.");
                    } else if (board[row][col] != ' ') {
                        System.out.println("Cell already occupied! Choose another cell.");
                    } else {
                        validMove = true;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter numbers only.");
                    sc.nextLine(); // Clear the buffer
                }
            }
            
            // Place the mark
            board[row][col] = currentPlayer;
            moves++;
            
            // Display the board
            print(board);
            
            // Check for winner
            if (check(board, currentPlayer)) {
                System.out.println("\n🎉 " + currentPlayer + " Player Wins! 🎉");
                gameOver = true;
            } else if (moves == 9) {
                System.out.println("\n🤝 It's a Draw! 🤝");
                gameOver = true;
            }
        }
    }
    
    public static boolean check(char[][] board, char sign) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == sign && board[i][1] == sign && board[i][2] == sign) {
                return true;
            }
        }
        
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == sign && board[1][i] == sign && board[2][i] == sign) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0] == sign && board[1][1] == sign && board[2][2] == sign) {
            return true;
        }
        
        if (board[0][2] == sign && board[1][1] == sign && board[2][0] == sign) {
            return true;
        }
        
        return false;
    }
    
    public static void print(char[][] board) {
        System.out.println("\n    0    1    2");
        System.out.println("  -------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("  -------------");
        }
    }
}