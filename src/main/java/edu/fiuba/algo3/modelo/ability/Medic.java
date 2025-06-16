package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.List;

public class Medic implements Ability{

    @Override
    public Player effect(Player player, UnitCard card) {
        List<UnitCard> revivir = player.getDiscardPile();
        Board board = Board.getInstance();
        board.addCard(player, revivir.get(0));
        return player;
    }
}
