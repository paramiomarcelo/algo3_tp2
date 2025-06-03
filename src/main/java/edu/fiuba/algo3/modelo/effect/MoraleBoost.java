package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.player.Player;

public class MoraleBoost implements SpecialEffect {



    @Override
    public void apply(Game game, Player player) {
        System.out.println("Morale Boost applied to player: ");
    }


}
