package edu.fiuba.algo3.modelo.visitors;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.board.Section;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.scene.control.Cell;

public interface Visitor {
    public int visit(Row row);
    public int visit(Section section);
    public void visit(Board board);

}
