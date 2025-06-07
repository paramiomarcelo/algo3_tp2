package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Bonded;
import edu.fiuba.algo3.modelo.card.*;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class BondedTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Deck deck;

    @Test
    void TestUseAbilityBonded(){
        List<Ability> bondedAbility = List.of(new Bonded(SectionType.SIEGE));
        UnitCard card0 = new UnitCard("Catapulta", "Bounded: unidad que duplica valor", 8, SectionType.SIEGE, bondedAbility);
        UnitCard card1 = new UnitCard("Catapulta", "Bounded: unidad que duplica valor", 8, SectionType.SIEGE, bondedAbility);
        UnitCard card3 = new UnitCard("Catapulta", "Bounded: unidad que duplica valor", 8, SectionType.SIEGE, bondedAbility);

        List<Card> cards = new ArrayList<>();
       /*cards.add(card0);
        cards.add(card1);
        cards.add(card3);

        deck = new Deck(cards);*/
        deck = new Deck(cards);

        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game = new Game();
        game.setPlayers(player1, player2);

        game.playCard(player1, card0);
        game.changeTurnForTest();
        game.playCard(player2, card1);
        game.changeTurnForTest();
        game.playCard(player1, card3);

        Assertions.assertEquals(16, card0.getPoints());
        Assertions.assertEquals(16, card1.getPoints());

        Assertions.assertEquals(48, player1.totalPointsRound(game.getBoard()));

    }



}
