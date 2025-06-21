package edu.fiuba.algo3.modelo.effect.WeatherEffect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

public class FogEffect extends SpecialEffect {

    public FogEffect(Section section) {
        super(section);
    }

    @Override
    public void apply(UnitCard card) {
        card.modifyPoints(1);
    }

    @Override
    public void apply(Board board, Player player) {
        super.apply(board, player); //quien la juega

        Player opponent = board.otherPlayer(player);
        board.getPlayerSection(opponent).applyEffect(this);
    }

}