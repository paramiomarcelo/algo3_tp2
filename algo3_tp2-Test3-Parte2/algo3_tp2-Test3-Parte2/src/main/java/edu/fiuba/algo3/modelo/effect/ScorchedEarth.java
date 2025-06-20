package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScorchedEarth extends SpecialEffect  {

    public ScorchedEarth(Section section) {
        super(section);
    }

    @Override
    public void apply(UnitCard card) {

    }

    @Override
    public void apply(Board board, Player player){
        List<Player> targets = List.of(player, board.otherPlayer(player));

        for (Player applyPlayer : targets) {
            List<UnitCard> cards = board.getCardsRow(applyPlayer, this.section);

            List<UnitCard> allCards = new ArrayList<>();
            allCards.addAll(board.getCardsRow(applyPlayer, new Melee()));
            allCards.addAll(board.getCardsRow(applyPlayer, new Ranged()));
            allCards.addAll(board.getCardsRow(applyPlayer, new Siege()));

            // 3) Si hay cartas, quemo la de mayor puntaje
            UnitCard toBurn = Collections.max(allCards, Comparator.comparingInt(UnitCard::getPoints));

            board.removeCard(applyPlayer, toBurn);
            applyPlayer.discardCard(toBurn);
        }
    }

}
