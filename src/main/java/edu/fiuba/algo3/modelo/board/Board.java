package edu.fiuba.algo3.modelo.board;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.effect.ScorchedEarth;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;


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

    public void receiveEffect(SpecialEffect effect, Player player) {
        PlayerSection playerSection = playerSections.get(player);
        playerSection.applyEffect(effect);
    }

    public int getPoints(Player player) {
        PlayerSection playerSection = playerSections.get(player);
        return playerSection.getPoints();
    }

    public List<UnitCard> clearBoardRound(Player player) {
        PlayerSection playerSection = playerSections.get(player);
        return playerSection.clearBoardRound();
    }

}

