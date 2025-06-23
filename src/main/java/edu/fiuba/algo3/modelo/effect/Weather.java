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


public class Weather extends SpecialEffect  {


    public Weather(List<Section> sections) {
        super(sections);

    }

    @Override
    public void apply(UnitCard card){
        card.weatherPoints();
    }

    @Override
    public void apply(Board board, Player player){
        super.apply(board, player);

        Player opponent = board.otherPlayer(player);
        board.getPlayerSection(opponent).applyEffect(this);
    }

}