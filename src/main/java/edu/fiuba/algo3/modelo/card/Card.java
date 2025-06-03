package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.player.Player;

public interface Card {
    void play(Game game, Player player);
}
