package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.player.Player;

public abstract class AbstractCard {
    protected String name;
    protected String description;

    public AbstractCard(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() { return name;}

    public abstract void play(Player player);

}
