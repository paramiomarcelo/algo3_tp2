package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.card.Card;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private Map<Player, Map<SectionType, Row>> sections;

    public Board() {
        this.sections = new HashMap<>();
    }

    public void addCard(Player player, UnitCard card, SectionType row) {
        sections.get(player).get(row).addCard(card);
    }


}

