package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.List;

public class Bonded implements Ability {

    public Player effect(Player player, UnitCard unitCard) {
        Board.getInstance().effectModifierBonded(player, unitCard);
        return player;

    }
}
