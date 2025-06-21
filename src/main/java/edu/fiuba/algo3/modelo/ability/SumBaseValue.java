package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public class SumBaseValue implements Ability {



    public Player effect(Player player, UnitCard card) {
        Board.getInstance().effectModifierSum(player, card);
        return null;
    }

}
