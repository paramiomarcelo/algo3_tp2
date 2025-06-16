package edu.fiuba.algo3.modelo.board;


import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.board.Section;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static Board board = new Board();
    private Section side1;
    private Section side2;

    private Board() {
    }

    public static Board getInstance() {
        return board;
    }

    public Section getSide(Player p) {
        return p.name().equals(side1.getName()) ? side1 : side2;
    }

    public Section counterSide(Player p) {
        return p.name().equals(side1.getName()) ? side2 : side1;
    }

    public Section getSide1() {
        return side1;
    }

    public Section getSide2() {
        return side2;
    }

    public void initSectionPlayer(Player p1, Player p2) {
        side1 = new Section(p1.name());
        side2 = new Section(p2.name());
    }

    public void addCard(Player player, UnitCard c) {
        c.play(player, this);
        c.apply(player);
    }

    public List<UnitCard> clearBoardRound(Player player) {
        Section section = getSide(player);
        return section.discardRound();
    }
}

