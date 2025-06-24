package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;

public abstract class SpecialEffect {

    protected final List<Section> section;

    public SpecialEffect(List<Section> section) {
        this.section = section;
    }

    public List<Section> getSection(){
        return section;
    }

    public abstract void apply(UnitCard card);

    public void apply(Board board, Player player){
        board.getPlayerSection(player).applyEffect(this);
    }
}