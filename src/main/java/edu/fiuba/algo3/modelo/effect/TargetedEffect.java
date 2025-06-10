package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.player.Player;

public abstract class TargetedEffect implements SpecialEffect {
    protected final String section;
    protected final Player player;

    public TargetedEffect(String section, Player player) {
        this.section = section;
        this.player = player;
    }
}