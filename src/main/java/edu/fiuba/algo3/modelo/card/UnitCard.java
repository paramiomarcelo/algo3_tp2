package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.ArrayList;
import java.util.List;

public class UnitCard extends AbstractCard implements ScorableCard {
    private Integer points;
    private Integer basePoints;
    private final SectionType rowType;
    private final List<Ability> abilities;

    public UnitCard(String name, String description, Integer points, SectionType rowType) {
        super(name, description);
        this.rowType = rowType;
        this.basePoints = points;
        this.points = basePoints;
        this.abilities = new ArrayList<>();
    }
    public UnitCard(String name, String description, Integer basePoints, SectionType rowType, List<Ability> abilities) {
        super(name, description);
        this.basePoints = basePoints;
        this.points = basePoints;
        this.rowType = rowType;
        this.abilities = new ArrayList<>(abilities);
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public Integer getPoints() {
        return points;
    }

    public Integer getBasePoints() {
        return basePoints;
    }

    @Override
    public void play(Game game, Player player) {
        game.placeUnitCard(player, this, this.rowType);
    }

    public void apply(Game game, Player player) {
        for (Ability a : abilities) {
            a.effect(game, player, this);
        }
    }
    public boolean hasAbility() { return (!this.abilities.isEmpty()); }

    public Integer getBasePoints() {
        return basePoints;
    }
}
