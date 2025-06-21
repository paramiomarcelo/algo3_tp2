package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;

public class Bonded implements Ability {

    @Override
    public Player effect(Player player, UnitCard card, Board board) {

        List<UnitCard> cards = board.getCardsRow(player, card.getRow());

        for (UnitCard cardOnBoard : cards) {
            if (cardOnBoard.getName().equals(card.getName())) {
                cardOnBoard.duplicatePoints();
            }
        }

        return player;
    }

}