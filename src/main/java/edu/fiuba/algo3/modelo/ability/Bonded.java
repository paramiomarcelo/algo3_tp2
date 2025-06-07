package edu.fiuba.algo3.modelo.ability;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Row;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;

import java.util.List;

//public class Bonded implements Ability {
//
//    private final SectionType affectSection;
//
//    public Bonded(SectionType affectSection) {
//        this.affectSection = affectSection;
//    }
//
//    @Override
//    public void effect(Game game, Player player, UnitCard card) {
//        Row row = game.getBoard().getRow(player, affectSection);
//        List<UnitCard> cardsBonded = row.getCardsBondedAbility(card);
//        if(cardsBonded.size() >= 2 ) {
//            for (UnitCard c : cardsBonded) {
//                c.setPoints(c.getBasePoints() * 2);
//            }
//        }
//    }
//
//
//}
