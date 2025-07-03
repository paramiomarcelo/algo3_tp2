package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public class SumBaseValue implements Ability {

    @Override
    public Player effect(Player player, UnitCard card, Board board, int parameter) {
        for(UnitCard c : board.getCardsRow(player,card.getRow())) {
            c.sumOne();
        }
        return player;
    }
}
