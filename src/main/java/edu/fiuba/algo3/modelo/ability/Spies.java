package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public class Spies implements Ability {
    @Override
    public Player effect(Player player, UnitCard card) {
        player.distributeCards(2);
        Board board = Board.getInstance();
        board.counterSide(player).getRow(card.getRowType()).getCards().add(card);
        board.getSide(player).getRow(card.getRowType()).getCards().remove(card);
//        Player applyPlayer = board.counterSide(player);
//        applyPlayer.addPoints(card.getBasePoints());
//        return applyPlayer;
        return player;
    }
}