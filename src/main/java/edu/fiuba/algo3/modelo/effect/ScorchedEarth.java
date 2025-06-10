package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;

public class ScorchedEarth extends GlobalEffect {

    @Override
    public void apply() {
        Board board = Board.getInstance();
        for (Player player : board.getPlayers()) {
            UnitCard maxCard = null;

            for (String section : List.of("melee", "ranged", "siege")) {
                Section row = board.getRow(player, section);
                UnitCard rowMax = row.maxPointCard();

                if (rowMax != null && (maxCard == null || rowMax.getPoints() > maxCard.getPoints())) {
                    maxCard = rowMax;
                }
            }

            if (maxCard != null) {
                board.removeCard(player, maxCard);
            }
        }
    }
}
