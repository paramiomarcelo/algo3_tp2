package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.player.Player;

public abstract class AbstractCard {
    protected String name;


    public AbstractCard(String name) {
        this.name = name;
    }

    public abstract void play(Player player);

}
