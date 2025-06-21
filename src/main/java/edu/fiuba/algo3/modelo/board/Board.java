package edu.fiuba.algo3.modelo.board;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.player.Player;


public class Board {
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
        card.apply(player, card);
        card.addCard(playerSections.get(player));
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

    public void actualScore(Player player) {
        PlayerSection playerSection = playerSections.get(player);
        playerSection.modifierScore(player);
    }

    public void effectModifierBonded(Player player, UnitCard card) {
        playerSections.get(player).searchPairs(card);
    }
    public void effectModifierSum(Player player, UnitCard card) {
        playerSections.get(player).sumBase(card);
    }


}

