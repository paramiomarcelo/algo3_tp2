package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.PointLegendary;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public class Legendary implements Ability {
    @Override
    public Player effect(Player player, UnitCard card, Board board) {
        card.setPoints(new PointLegendary(card.getPoints()));
        return player;
    }
}
