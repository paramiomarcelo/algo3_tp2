package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.ability.Spies;
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

    public void addCard(Player player, UnitCard card) {
        card.apply(player);

        Player applyPlayer = player;
        if (card.getAbility() instanceof Spies) {
            applyPlayer = this.getPlayers().stream().filter(p -> !p.equals(player)).findFirst().orElseThrow(() -> new RuntimeException("Need 2 players"));
            applyPlayer.addPoints(card.getBasePoints());
        }

        sections.get(applyPlayer).get(card.getRowType()).addCard(card);

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

    public List<UnitCard> clearBoardRound(Player player) {
        List<UnitCard> cards = new ArrayList<>();
        Map<String, Section> rows = sections.get(player);
        for (Section row : rows.values()) {
            cards.addAll(row.getCards());
        }
        rows.clear();
        return cards;
    }

    public void removeCard(Player player, UnitCard card) {
        for (String section : List.of("melee", "ranged", "siege")) {
            Section row = getRow(player, section);
            row.removeCard(card);
        }
    }
}

