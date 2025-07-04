package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.player.Player;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;

    public Game() {
        this.board = Board.getInstance();
    }



    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;

        board.addPlayer(player1);
        board.addPlayer(player2);
    }



    public Player switchTurn(Player player) {
        return  (player == player1) ? player2 : player1;
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public void roundCompleted(){
        player1.clearRound(board);
        player2.clearRound(board);
        player1.resetTurn();
        player2.resetTurn();
    }

    public void reset() {
        if (player1 != null) {
            player1.reset();
        }
        if (player2 != null) {
            player2.reset();
        }
        board.reset();
        this.currentPlayer = player1;
    }




}
