package edu.fiuba.algo3.modelo.effect.weatherEffects;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.effect.GlobalEffect;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.visitors.ModifierCards;

public class ClearWeatherEffect extends GlobalEffect {
    @Override
    public void apply() {
//        Board board = Board.getInstance();
//        for (Player player : board.getPlayers()) {
//            board.getRow(player, "melee").applyClearWeatherEffect();
//            board.getRow(player, "ranged").applyClearWeatherEffect();
//            board.getRow(player, "siege").applyClearWeatherEffect();
//        }
        Board board = Board.getInstance();
        ModifierCards modifierCards = new ModifierCards();

        modifierCards.applyClearWeatherEffect(board.getSide1().getRowMelee());
        modifierCards.applyClearWeatherEffect(board.getSide1().getRanged());
        modifierCards.applyClearWeatherEffect(board.getSide1().getRowSiege());

        modifierCards.applyClearWeatherEffect(board.getSide2().getRowMelee());
        modifierCards.applyClearWeatherEffect(board.getSide2().getRanged());
        modifierCards.applyClearWeatherEffect(board.getSide2().getRowSiege());
    }
}
