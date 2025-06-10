package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.player.Player;

public class SpecialCard extends AbstractCard {
    private final SpecialEffect effect;

    public SpecialCard(String name, String description, SpecialEffect effect) {
        super(name, description);
        this.effect = effect;
    }

    public SpecialEffect getEffect() {
        return effect;
    }
}