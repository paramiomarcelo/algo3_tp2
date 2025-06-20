package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.scene.effect.Effect;

public abstract class SpecialCard extends AbstractCard {
    private String description;




    public SpecialCard(String name, String description) {
        super(name);
        this.description = description;
    }

    public abstract void aplly(Player player);


}