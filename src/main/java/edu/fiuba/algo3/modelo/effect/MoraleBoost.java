package edu.fiuba.algo3.modelo.effect;


import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;


public class MoraleBoost extends SpecialCard  {

    public MoraleBoost(String name, String description) {
        super(name,description);
    }


    public void applyEffect(UnitCard unitCard) {
        unitCard.duplicatePoints();
    }

    @Override
    public void aplly(Player player) {
        Board board = Board.getInstance();
        board.receiveEffect(this,player);
    }

    @Override
    public void play(PlayerSection player) {
        Board board = Board.getInstance();
//        board.receiveEffect(this,);
    }
}
