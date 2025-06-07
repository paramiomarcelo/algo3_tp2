package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;
import java.util.List;

//public class Weather implements SpecialEffect {
//    protected List<String> affectedSections;
//
//    @Override
//    public void effect(Game game, Player player) {
//        Board board = game.getBoard();
//        for (Player p : board.getPlayers()) {
//            for (String section : affectedSections) {
//                Row row = board.getRow(p, section);
//                row.applyEffect();
//            }
//        }
//    }
//}