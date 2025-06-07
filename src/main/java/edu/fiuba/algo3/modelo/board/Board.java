package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;

import java.util.List;
import java.util.ArrayList;


import java.util.HashMap;
import java.util.Map;

public class Board  {
    private Map<Player, Map<String, Section>> sections;
    private static Board board = new Board();

    private Board() {
        this.sections = new HashMap<>();
    }

    public static Board getInstance() {
        return board;
    }

    public void addCard(Player player, UnitCard card, String section) {
        sections.get(player).get(section).addCard(card);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(sections.keySet());
    }

    public void addPlayer(Player player) {
        Map<String, Section> playerSections = new HashMap<>();

        playerSections.put("melee", new Melee());
        playerSections.put("ranged", new Ranged());
        playerSections.put("siege", new Siege());


        sections.put(player, playerSections);
    }

    public Section getRow(Player player, String sectionType) {
        return sections.get(player).get(sectionType);
    }

    public int getScoreRow(Player player) {
        int score = 0;
        Map<String, Section> rows = sections.get(player);
        for (Section row : rows.values()) {
            score += row.calculatePoints();
        }
        return score;
    }
}

