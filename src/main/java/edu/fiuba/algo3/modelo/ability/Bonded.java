package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.ArrayList;
import java.util.List;

public class Bonded implements Ability {

    @Override
    public Player effect(Player player, UnitCard card, Board board, int parameter) {
        // Ignora el parámetro, usa la lógica original
        List<UnitCard> cards = board.getCardsRow(player, card.getRow());

        List<UnitCard> bonded = new ArrayList<>();
        for (UnitCard c : cards) {
            if (c.comparedName(card)) {
                bonded.add(c);
            }
        }
        if(bonded.size() >= 1){
            for (UnitCard c : bonded) {
                c.duplicatePoints();
            }
            card.duplicatePoints();
        }
        return player;
    }

}