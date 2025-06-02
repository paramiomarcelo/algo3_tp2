package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;

public class Weather implements SpecialEffect {
    private final SectionType affectedSection;

    public Weather(SectionType affectedSection) {
        this.affectedSection = affectedSection;
    }

    @Override
    public void apply(Game game, Player player) {
        Board board = game.getBoard();
        for (Player p : board.getPlayers()) {
            Row row = board.getRow(p, affectedSection);
            row.applySnowEffect();
        }
    }
}
