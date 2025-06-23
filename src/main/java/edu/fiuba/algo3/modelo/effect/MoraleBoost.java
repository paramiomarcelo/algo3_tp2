package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;


public class MoraleBoost extends SpecialEffect  {

    public MoraleBoost(List<Section> section) {
        super(section);
    }

    @Override
    public void apply(UnitCard card) {
        card.duplicatePoints();
    }

    @Override
    public void apply(Board board, Player player) {
        board.getPlayerSection(player).applyEffect(this);
    }

}

