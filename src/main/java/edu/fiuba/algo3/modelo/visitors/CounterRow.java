package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.board.Section;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;

public class CounterRow implements Visitor {

    @Override
    public int visit(Row row) {
        int point = 0;
        for (UnitCard c : row.getCards()) {
            point += c.getPoints();
        }
        return point;
    }

    @Override
    public int visit(Section section) {
        int point = 0;
        point += section.getRowMelee().visit(this);
        point += section.getRanged().visit(this);
        point += section.getRowSiege().visit(this);
        return point;
    }
    public void visit(Board board) {}

}