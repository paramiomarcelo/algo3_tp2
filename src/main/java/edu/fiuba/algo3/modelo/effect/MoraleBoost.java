package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public class MoraleBoost extends TargetedEffect {
    public MoraleBoost(String section, Player player) {
        super(section, player);
    }

    @Override
    public void apply() {
        Board board = Board.getInstance();
        board.getRow(player, section).boostMorale();
    }
}
