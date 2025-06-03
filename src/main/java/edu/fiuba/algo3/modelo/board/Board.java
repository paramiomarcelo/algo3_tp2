package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.card.Card;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;
import java.util.List;
import java.util.ArrayList;


import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Player, Map<SectionType, Row>> sections;

    public Board() {
        this.sections = new HashMap<>();
    }

    public void addCard(Player player, UnitCard card, SectionType row) {
        sections.get(player).get(row).addCard(card);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(sections.keySet());
    }

    public void addPlayer(Player player) {
        Map<SectionType, Row> playerSections = new HashMap<>();
        for (SectionType type : SectionType.values()) {
            playerSections.put(type, new Row());
        }
        sections.put(player, playerSections);
    }

    public Row getRow(Player player, SectionType sectionType) {
        return sections.get(player).get(sectionType);
    }

}

