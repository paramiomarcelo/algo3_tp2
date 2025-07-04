package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.player.Player;

public class SpecialCard extends AbstractCard {
    private final SpecialEffect effect;

    public SpecialCard(String name, String description, SpecialEffect effect) {
        super(name, description);
        this.effect = effect;
    }

    @Override
    public void play(Player player, Board board){
        board.receiveEffect(effect, player);
    }

    @Override
    public void play(Player player, Board board, int parameter) {
        board.receiveEffect(effect, player);
    }

}