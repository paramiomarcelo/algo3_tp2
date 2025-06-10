package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.List;

public class Agile implements Ability {

    private List<String> allowedSections;

    public Agile(List<String> allowedSections) {
        this.allowedSections = allowedSections;
    }

    @Override
    public Player effect(Player player, UnitCard card) {
        return player;
    }

    public boolean canBePlayedIn(String section) {
        return allowedSections.contains(section);
    }

    public List<String> getAllowedSections() {
        return allowedSections;
    }
}
