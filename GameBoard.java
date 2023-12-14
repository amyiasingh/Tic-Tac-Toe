public class GameBoard {
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        initializeBoard();
    }

    // Initialize the board with empty cells
    void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void displayBoard() {
        char[][] board = getGameBoard(); 
    
        System.out.println("-------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    

    // Get the value of a cell
    public char getCell(int row, int col) {
        return board[row][col];
    }

    // Set the value of a cell
    public void setCell(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false; // If any cell is empty, the board is not full
                }
            }
        }
        return true; // If no empty cells are found, the board is full
    }
    public char[][] getGameBoard(){
        return board;
    }
    
}
