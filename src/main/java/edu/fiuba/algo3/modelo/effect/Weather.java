package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;


public abstract class Weather extends SpecialEffect  {

    public Weather(Section section) {
        super(section);
    }

    @Override
    public void apply(UnitCard card) {

    }

}