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
        playerSections.get(player).addCard(card);
    }

    public void receiveEffect(SpecialEffect effect, Player player) {
        effect.apply(this, player);
    }

    public int getPoints(Player player) {
        PlayerSection playerSection = playerSections.get(player);
        return playerSection.getPoints();
    }

    public List<UnitCard> clearBoardRound(Player player) {
        PlayerSection playerSection = playerSections.get(player);
        return playerSection.clearBoardRound();
    }

    public Player otherPlayer(Player player) {
        return playerSections.keySet().stream().filter(p -> !p.equals(player)).findFirst().orElseThrow(() -> new IllegalStateException("need 2 players to play"));
    }

    public List<UnitCard> getCardsRow(Player player, Section section) {
        PlayerSection playerSection = playerSections.get(player);
        return playerSection.getCards(section);
    }

    public PlayerSection getPlayerSection(Player player) {
        return playerSections.get(player);
    }

    public void removeCard(Player player, UnitCard card) {
        PlayerSection playerSection = playerSections.get(player);
        playerSection.removeCard(card);
    }
    public void actualScore(Player player) {
        PlayerSection playerSection = playerSections.get(player);
        playerSection.modifierScore(player);
    }
}

