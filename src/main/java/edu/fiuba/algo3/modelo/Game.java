package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.visitors.Visitor;

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

        board.initSectionPlayer(player1,player2);
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }
    public void actualScoreRound() {
        player1.setPoint();
        player2.setPoint();
    }

    public void roundCompleted(){
        player1.clearRound();
        player2.clearRound();
        setPlayers(player1, player2);
    }
    public void playTurn() {
        AbstractCard c = currentPlayer.getHand().get(0);
        currentPlayer.playCard(c);
    }

}
