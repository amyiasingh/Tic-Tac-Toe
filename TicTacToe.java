import java.util.Scanner;

public class TicTacToe {
    private GameBoard gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private Scanner scanner;

    //private int[][] leaderboard = new int[2][2];

    public TicTacToe() {
        gameBoard = new GameBoard();
        playerOne = new Player();
        playerTwo = new Player();
        scanner = new Scanner(System.in);

        /*leaderboard[0][0] = 0; // Player One wins
        leaderboard[0][1] = 0; // Player Two wins
        leaderboard[1][0] = 0; // Player One losses
        leaderboard[1][1] = 0; // Player Two losses*/
    }

    public String getPlayerOneName() {
        return getPlayerOneName();
    }

    public String getPlayerTwoName() {
        return getPlayerTwoName();
    }

    public char getPlayerOneSymbol() {
        return getPlayerOneSymbol();
    }

    public char getPlayerTwoSymbol() {
        return getPlayerTwoSymbol();
    }

    public char[][] getGameBoard() {
        return gameBoard.getGameBoard();
    }

    // Method to make a move for a specific player and return whether the move was
    // valid
    public boolean makeMovePlayerOne(Player playerOne) {
        System.out.println(playerOne.getName() + "'s turn: ");
        System.out.print("Enter the row (0, 1, or 2): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column (0, 1, or 2): ");
        int col = scanner.nextInt();

        if (isValidMove(row, col)) {
            gameBoard.setCell(row, col, playerOne.getSymbol());
            gameBoard.displayBoard();
            return true;
        } else {
            System.out.println("Invalid move. Try again.");
            return false;
        }
    }

    public boolean makeMovePlayerTwo(Player playerTwo) {
        System.out.println(playerTwo.getName() + "'s turn: ");
        System.out.print("Enter the row (0, 1, or 2): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column (0, 1, or 2): ");
        int col = scanner.nextInt();

        if (isValidMove(row, col)) {
            gameBoard.setCell(row, col, playerTwo.getSymbol());
            gameBoard.displayBoard();
            return true;
        } else {
            System.out.println("Invalid move. Try again.");
            return false;
        }
    }

    // Check if the move is valid (i.e., the cell is empty)
    private boolean isValidMove(int row, int col) {
        return gameBoard.getCell(row, col) == ' ';
    }

    // Check if the game board is full
    public boolean isBoardFull() {
        return gameBoard.isBoardFull();
    }

    public boolean checkWin(Player playerOne, Player playerTwo) {
        char symbolOne = playerOne.getSymbol();
        char symbolTwo = playerTwo.getSymbol();

        //String winner = null;

        // Check rows for Player One
        for (int row = 0; row < 3; row++) {
            if (gameBoard.getCell(row, 0) == symbolOne &&
                    gameBoard.getCell(row, 1) == symbolOne &&
                    gameBoard.getCell(row, 2) == symbolOne) {
                System.out.println(playerOne.getName() + " wins horizontally!");
                //winner = playerOne.getName();
                return true; // Three in a row horizontally for Player One
            }
        }

        // Check columns for Player One
        for (int col = 0; col < 3; col++) {
            if (gameBoard.getCell(0, col) == symbolOne &&
                    gameBoard.getCell(1, col) == symbolOne &&
                    gameBoard.getCell(2, col) == symbolOne) {
                System.out.println(playerOne.getName() + " wins vertically!");
                //winner = playerOne.getName();
                return true; // Three in a row vertically for Player One
            }
        }

        // Check diagonals for Player One
        if ((gameBoard.getCell(0, 0) == symbolOne &&
                gameBoard.getCell(1, 1) == symbolOne &&
                gameBoard.getCell(2, 2) == symbolOne) ||
                (gameBoard.getCell(0, 2) == symbolOne &&
                        gameBoard.getCell(1, 1) == symbolOne &&
                        gameBoard.getCell(2, 0) == symbolOne)) {
            System.out.println(playerOne.getName() + " wins diagonally!");
            //winner = playerOne.getName();
            return true; // Three in a row diagonally for Player One
        }

        // Check rows for Player Two
        for (int row = 0; row < 3; row++) {
            if (gameBoard.getCell(row, 0) == symbolTwo &&
                    gameBoard.getCell(row, 1) == symbolTwo &&
                    gameBoard.getCell(row, 2) == symbolTwo) {
                System.out.println(playerTwo.getName() + " wins horizontally!");
                //winner = playerTwo.getName();
                return true; // Three in a row horizontally for Player Two
            }
        }

        // Check columns for Player Two
        for (int col = 0; col < 3; col++) {
            if (gameBoard.getCell(0, col) == symbolTwo &&
                    gameBoard.getCell(1, col) == symbolTwo &&
                    gameBoard.getCell(2, col) == symbolTwo) {
                System.out.println(playerTwo.getName() + " wins vertically!");
                //winner = playerTwo.getName();
                return true; // Three in a row vertically for Player Two
            }
        }

        // Check diagonals for Player Two
        if ((gameBoard.getCell(0, 0) == symbolTwo &&
                gameBoard.getCell(1, 1) == symbolTwo &&
                gameBoard.getCell(2, 2) == symbolTwo) ||
                (gameBoard.getCell(0, 2) == symbolTwo &&
                        gameBoard.getCell(1, 1) == symbolTwo &&
                        gameBoard.getCell(2, 0) == symbolTwo)) {
            System.out.println(playerTwo.getName() + " wins diagonally!");
            //winner = playerTwo.getName();
            return true;} /// Three in a row diagonally for Player Two
        return false;
                         }

        /*if(winner.equals(playerOne.getName())){
            leaderboard[0][0]++;
            leaderboard[1][1]++;
        } else {
            leaderboard[0][1]++;
            leaderboard[1][0]++;
        }*/

    public void playGame() {
        while (!this.isBoardFull()) {
            this.makeMovePlayerOne(playerOne);
            if (this.checkWin(playerOne, playerTwo)) {
                break;
            }
            if (this.isBoardFull()) {
                System.out.println("It's a draw! The game is a tie.");
                break;
            }
            this.makeMovePlayerTwo(playerTwo);
            if (this.checkWin(playerOne, playerTwo)) {
                System.out.println(playerTwo.getName() + " wins!");
                break;
            }
        }
        this.isBoardFull();

    }

    public boolean isGameDone() {
        while (true) {
            int choice;
            System.out.println("Enter 1 to play, enter 2 to choose new players, and 3 to stop..");
            choice = scanner.nextInt();

            if (choice == 1) {
                gameBoard.initializeBoard();
                playGame();
            } else if (choice == 2) {
                System.out.println("New game:");
                gameBoard = new GameBoard();
                playerOne = new Player();
                playerTwo = new Player();
                this.playGame();
                this.isGameDone();
            } else if (choice == 3) {
                System.out.println("Game is over.");
                //this.displayLeaderboard();
                return true;
            } else {
                System.out.println("Error.");
            }
        }
    }

    /*public void displayLeaderboard() {
        System.out.println("Leaderboard:");
        System.out.println(playerOne.getName() + ": " + leaderboard[0][0] + " wins, " + leaderboard[1][0] + " losses");
        System.out.println(playerTwo.getName() + ": " + leaderboard[0][1] + " wins, " + leaderboard[1][1] + " losses");
    } */

}
