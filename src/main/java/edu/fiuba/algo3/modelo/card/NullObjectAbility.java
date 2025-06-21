package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.player.Player;

public class NullObjectAbility implements Ability {


    @Override
    public Player effect(Player player, UnitCard card, Board board) {
        return player;
    }
}
