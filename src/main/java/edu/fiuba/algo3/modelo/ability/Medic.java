package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.vistas.OptionPlayer;

import java.util.List;

public class Medic implements Ability{

    @Override
    public Player effect(Player player, UnitCard card, Board board) {
        if(player.getDiscardPile().isEmpty()) {
            System.out.println("No discard pile");
        } else {
            List<UnitCard> discard = player.getDiscardPile();
            OptionPlayer o = OptionPlayer.getInstance();
            o.modifierMedic(discard, player);
//            board.addCard(player, discard.get(0));
        }
        return player;

    }
}