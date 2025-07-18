package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public interface Ability {
    Player effect(Player player, UnitCard card, Board board, int parameter);
}
