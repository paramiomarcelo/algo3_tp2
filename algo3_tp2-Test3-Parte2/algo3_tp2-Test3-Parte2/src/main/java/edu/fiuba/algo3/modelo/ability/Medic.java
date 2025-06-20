package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.List;

public class Medic implements Ability{

    @Override
    public Player effect(Player player, UnitCard card, Board board) {
        List<UnitCard> discard = player.getDiscardPile();
        board.addCard(player, discard.get(player.indexSelectCards()));
        return player;
    }
}