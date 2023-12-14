public class App {
    public static void main(String[] args) {
        System.out.println("This is a game of Tic Tac Toe");

        // get components
        TicTacToe game = new TicTacToe();
        GameBoard gameBoard = new GameBoard();

        //Player playerTwo = new Player();

        // display board 
        gameBoard.displayBoard();

        //play game
        game.playGame();

        //loop game
        game.isGameDone();
    }

}
