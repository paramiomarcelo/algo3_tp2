package edu.fiuba.algo3.modelo.effect.weatherEffects;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.effect.Weather;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;
import java.util.List;


public class ClearWeatherEffect extends Weather {
    public ClearWeatherEffect() {
        this.affectedSections = List.of(
            SectionType.MELEE, 
            SectionType.RANGED, 
            SectionType.SIEGE
        );
    }

    @Override
    public void effect(Game game, Player player) {
        Board board = game.getBoard();
        for (Player p : board.getPlayers()) {
            for (SectionType section : affectedSections) {
                Row row = board.getRow(p, section);
                row.applyClearWeatherEffect();
            }
        }
    }
}