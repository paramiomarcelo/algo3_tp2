package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.visitors.ModifierCards;

import java.util.List;

public class ScorchedEarth extends GlobalEffect {

    @Override
    public void apply() {
        Board board = Board.getInstance();
        ModifierCards modifierCards = new ModifierCards();
        UnitCard card1 = modifierCards.scorchedEarth(board.getSide1());
        UnitCard card2 = modifierCards.scorchedEarth(board.getSide2());

        if (card1 != null ) {
            board.getSide1().getRow(card1.getRowType()).getCards().remove(card1);
        }
        if (card2 != null ) {
            board.getSide2().getRow(card2.getRowType()).getCards().remove(card2);
        }

//        for (Player player : board.getPlayers()) {
//            UnitCard maxCard = null;
//
//            for (String section : List.of("melee", "ranged", "siege")) {
//                Section row = board.getRow(player, section);
//                UnitCard rowMax = row.maxPointCard();
//
//                if (rowMax != null && (maxCard == null || rowMax.getPoints() > maxCard.getPoints())) {
//                    maxCard = rowMax;
//                }
//            }
//
//            if (maxCard != null) {
//                board.removeCard(player, maxCard);
//            }
//        }
    }
}
