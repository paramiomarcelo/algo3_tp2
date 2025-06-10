package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.ArrayList;

public class UnitCard extends AbstractCard implements ScorableCard {
    private Integer points;
    private Integer basePoints;
    private final String rowType;
    private Ability ability;

    public UnitCard(String name, String description, Integer points, String rowType) {
        super(name, description);
        this.rowType = rowType;
        this.basePoints = points;
        this.points = basePoints;
    }

    public UnitCard(String name, String description, Integer basePoints, String rowType, Ability abilities) {
        super(name, description);
        this.basePoints = basePoints;
        this.points = basePoints;
        this.rowType = rowType;
        this.ability = abilities;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer getBasePoints() {
        return basePoints;
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
