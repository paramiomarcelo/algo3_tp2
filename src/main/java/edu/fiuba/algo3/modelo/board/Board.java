package edu.fiuba.algo3.modelo.board;



import java.util.HashMap;
import java.util.Map;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.effect.ScorchedEarth;
import edu.fiuba.algo3.modelo.player.Player;



public class Board  {
    private final Map<Player, PlayerSection> playerSections;
    private static Board instance;

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private Board() {
        playerSections = new HashMap<>();
    }

    public void addPlayer(Player player) {
        playerSections.put(player, new PlayerSection());
    }


    public void addCard(Player player, UnitCard card) {
        card.play(playerSections.get(player));
    }

    public void receiveEffect(MoraleBoost moraleBoost, Player player) {
        PlayerSection playerSection = playerSections.get(player);
        playerSection.applyEffect(moraleBoost);
    }


    

//    public int getScoreRow(Player player) {
//        int score = 0;
//        Map<String, Section> rows = sections.get(player);
//        for (Section row : rows.values()) {
//            score += row.calculatePoints();
//        }
//        return score;
//    }

//    public List<UnitCard> clearBoardRound(Player player) {
//        List<UnitCard> cards = new ArrayList<>();
//        Map<String, Section> rows = sections.get(player);
//        for (Section row : rows.values()) {
//            cards.addAll(row.getCards());
//        }
//        rows.clear();
//        return cards;
//    }

}

