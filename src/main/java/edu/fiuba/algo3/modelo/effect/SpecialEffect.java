package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.player.Player;

public interface SpecialEffect {
    void apply(Game game, Player player);
}
