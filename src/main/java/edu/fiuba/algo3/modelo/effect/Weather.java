package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;
import java.util.List;


public abstract class Weather extends GlobalEffect {
    protected abstract List<String> affectedSections();

    @Override
    public void apply() {
        Board board = Board.getInstance();
        for (Player player : board.getPlayers()) {
            for (String section : affectedSections()) {
                board.getRow(player, section).applyWeatherEffect();
            }
        }
    }
}