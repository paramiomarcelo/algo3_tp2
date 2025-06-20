package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

public abstract class SpecialEffect {

    protected final Section section;

    public SpecialEffect(Section section) {
        this.section = section;
    }

    public Section getSection(){
        return section;
    }

    public abstract void apply(UnitCard card);

    public void apply(Board board, Player player){
        board.getPlayerSection(player).applyEffect(this);
    }
}