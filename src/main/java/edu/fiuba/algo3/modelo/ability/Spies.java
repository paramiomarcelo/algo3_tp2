package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public class Spies implements Ability {
    @Override
    public void effect(Player player,  UnitCard card) {
        player.distributeCards(2);
    }
}