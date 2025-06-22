package edu.fiuba.algo3.modelo.effect;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<UnitCard, Player> cardOwners = new HashMap<>();
        List<UnitCard> allCards = new ArrayList<>();
        
        for (Player applyPlayer : targets) {
            List<UnitCard> meleeCards = board.getCardsRow(applyPlayer, new Melee());
            List<UnitCard> rangedCards = board.getCardsRow(applyPlayer, new Ranged());
            List<UnitCard> siegeCards = board.getCardsRow(applyPlayer, new Siege());
            

            for (UnitCard card : meleeCards) {
                cardOwners.put(card, applyPlayer);
                allCards.add(card);
            }
            for (UnitCard card : rangedCards) {
                cardOwners.put(card, applyPlayer);
                allCards.add(card);
            }
            for (UnitCard card : siegeCards) {
                cardOwners.put(card, applyPlayer);
                allCards.add(card);
            }
        }
        
        if (allCards.isEmpty()) {
            return;
        }

        UnitCard cardHighestPoints = allCards.get(0);
        for(UnitCard card : allCards) {
            if (card.compareCardPoints(cardHighestPoints)) {
                cardHighestPoints = card;
            }
        }

        for(UnitCard card : allCards) {
            if (card.equalPoints(cardHighestPoints)) {
                Player cardOwner = cardOwners.get(card);
                board.removeCard(cardOwner, card);
                cardOwner.discardCard(card);
            }
        }
    }
}
