package edu.fiuba.algo3.modelo.effect.weatherEffects;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.effect.GlobalEffect;
import edu.fiuba.algo3.modelo.player.Player;

public class ClearWeatherEffect extends GlobalEffect {
    @Override
    public void apply() {
        Board board = Board.getInstance();
        for (Player player : board.getPlayers()) {
            board.getRow(player, "melee").applyClearWeatherEffect();
            board.getRow(player, "ranged").applyClearWeatherEffect();
            board.getRow(player, "siege").applyClearWeatherEffect();
        }
    }
}
