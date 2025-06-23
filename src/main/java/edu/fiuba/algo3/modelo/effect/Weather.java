package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.WeatherEffect.*;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;

import java.util.List;


public abstract class Weather extends SpecialEffect  {


    public Weather(List<Section> sections) {
        super(sections);

    }

    @Override
    public abstract void apply(UnitCard card);

    @Override
    public abstract void apply(Board board, Player player);

}