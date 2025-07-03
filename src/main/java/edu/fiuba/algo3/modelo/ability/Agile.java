package edu.fiuba.algo3.modelo.ability;


import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

public class Agile implements Ability {

    @Override
    public Player effect(Player player, UnitCard card, Board board, int parameter) {
        // parameter es el índice de la sección (0 para melee, 1 para ranged)
        if (parameter >= 0 && parameter < card.getSection().size()) {
            card.chooseSection(parameter);
        } else {
            System.out.println("Invalid section index");
        }
        
        return player;
    }
}