package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.List;

public class Medic implements Ability{

    @Override
    public Player effect(Player player, UnitCard card, Board board, int parameter) {
        if(player.getDiscardPile().isEmpty()) {
            System.out.println("No discard pile");
            return player;
        }
        
        List<AbstractCard> discard = player.getDiscardPile();
        if (parameter >= 0 && parameter < discard.size()) {
            AbstractCard cardToRevive = discard.get(parameter);
            discard.remove(parameter);
            player.playCard(cardToRevive);
            System.out.println("Revived card: " + cardToRevive.getName());
        } else {
            System.out.println("Invalid index for discard pile");
        }
        
        return player;
    }
}