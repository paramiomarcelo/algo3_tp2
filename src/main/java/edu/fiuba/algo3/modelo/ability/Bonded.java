package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;

public class Bonded implements Ability {

    @Override
    public Player effect(Player player, UnitCard card) {
        Board board = Board.getInstance();

        Section section = board.getRow(player, card.getRowType());

        List<UnitCard> cardsBonded = section.cardsBondedAbility(card);
        if(cardsBonded.size() >= 2 ) {
            for (UnitCard c : cardsBonded) {
                c.setPoints(c.getBasePoints() * 2);
            }
        }

        return player;
    }

}
