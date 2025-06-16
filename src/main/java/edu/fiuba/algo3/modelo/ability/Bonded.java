package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;


import java.util.ArrayList;
import java.util.List;

public class Bonded implements Ability {

    @Override
    public Player effect(Player player, UnitCard card) {
        Board board = Board.getInstance();
        Row row = board.getSide(player).getRow(card.getRowType());
        List<UnitCard> bondedCards = new ArrayList<>();

        for (UnitCard c : row.getCards()){
            if (c.getName().equals(card.getName())){
                bondedCards.add(c);
            }
        }

        if(bondedCards.size() >= 2 ) {
            for (UnitCard c : bondedCards) {
                c.setPoints(c.getBasePoints() * 2);
            }
        }
        return player;
    }


}
