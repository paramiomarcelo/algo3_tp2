package edu.fiuba.algo3.clases;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    Board board;
    int roundNumber;
    boolean gameEnded;

    public Game() {
        this.roundNumber = 0;
        this.gameEnded = false;
        this.player1 = new Player("giansito");
        this.player2 = new Player("marcelito");
        this.board = new Board(player1, player2);
    }
    public void setPlayerRound() {
        this.currentPlayer = currentPlayer == player1? player2 : player1;
    }
    void playCard(Player player) {
        player1.playCard(board);
    }
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    public Board getBoard(){
        return this.board;
    }
}
