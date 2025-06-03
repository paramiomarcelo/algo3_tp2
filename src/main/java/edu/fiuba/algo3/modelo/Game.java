package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.Card;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
    }

    public void playCard(Player player, Card card) {
        if (player != currentPlayer) {
            throw new IllegalStateException("No es tu turno");
        }

        card.play(this, player);
        player.removeCardFromHand(card);
        this.switchTurn();
    }

    public void placeUnitCard(Player player, UnitCard card, SectionType row) {
        board.addCard(player, card, row);
        player.addPoints(card.getPoints());
    }

    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;

        board.addPlayer(player1);
        board.addPlayer(player2);
    }

    public void applySpecialEffect(Player player, SpecialCard card) {
        card.getEffect().apply(this, player);
        player.removeCardFromHand(card);
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
}
