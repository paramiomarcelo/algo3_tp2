package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.ArrayList;

public class UnitCard extends AbstractCard {
    private final String rowType;
    private Ability ability;
    private Point points;

    public UnitCard(String name, Point points, String rowType) {
        super(name);
        this.rowType = rowType;
        this.points = points;
    }

    public UnitCard(String name, Point points, String rowType, Ability ability) {
        super(name);
        this.points = points;
        this.rowType = rowType;
        this.ability = ability;
    }

    public Player apply(Player player) {
        if (this.ability != null) {
            return this.ability.effect(player, this);
        }
        return player;
    }

    public String getRowType() {
        return rowType;
    }

    public void addAbility(Ability ability) {
        this.ability = ability;
    }

    public Ability getAbility() {
        return this.ability;
    }
}
