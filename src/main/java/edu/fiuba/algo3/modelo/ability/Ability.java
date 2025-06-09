package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public interface Ability {
    public void effect(Player player, UnitCard card);
}
