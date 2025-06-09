package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Bonded;
import edu.fiuba.algo3.modelo.ability.Medic;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class BondedTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Deck deck;

    private List<AbstractCard> cards;
    UnitCard card0;
    UnitCard card1;
    UnitCard card2;

    @BeforeEach
    void setUp() {
        List<Ability> bonded = List.of(new Bonded());
        List<Ability> medic = List.of(new Medic());
        card0 = new UnitCard("Cow", "Vaca", 1, "ranged");
        card1 = new UnitCard("Catapulta", "Bounded: unidad que duplica valor",
                8, "siege", bonded);
        card2 = new UnitCard("Medic", "medico",5,"siege", medic);

        cards = new ArrayList<>();
        cards.add(card0);
        cards.add(card1);
        cards.add(card2);

        deck = new Deck(cards);


    }
    @Test
    void AddCardBoard() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1,player2);
        player1.playCard(card0, card0.getRowType());

        Assertions.assertEquals(1, player1.totalPointsRound(game.getBoard()));
    }
    @Test
    void TestUseAbilityBonded(){
        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1, card1.getRowType());
        player1.playCard(card1, card1.getRowType());
        player1.playCard(card1, card1.getRowType());

        Assertions.assertEquals(48, player1.totalPointsRound(game.getBoard()));

    }

    @Test
    void cardEffectMedicWithCardBonded() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1, card1.getRowType());
        player1.playCard(card0, card0.getRowType());
        game.roundCompleted();
        player1.playCard(card1, card1.getRowType());//carta catapulta bonded
        player1.selectCard(1);
        player1.playCard(card2, card2.getRowType()); // carta medico revive una carta de la ronda anterior

        // 8 + 5 -> 8 + 5 + 8 -> 16 + 16 + 5 = 37
        Assertions.assertEquals(37, player1.totalPointsRound(game.getBoard()));
    }
    @Test
    void cardEffectMedicWithCardNeutral() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1, card1.getRowType());
        player1.playCard(card0, card0.getRowType());
        game.roundCompleted();
        player1.playCard(card1, card1.getRowType());//carta catapulta bonded
        player1.selectCard(0);// en la 0 esta la vaca en la 1 esta la catapulta
        player1.playCard(card2, card2.getRowType()); // carta medico revive una carta de la ronda anterior

        // 8 + 5 -> 8 + 5 + 1 -> 8 + 1 + 5 = 14
        Assertions.assertEquals(14, player1.totalPointsRound(game.getBoard()));

    }
    @Test
    void cardEffectMedicWithCardNeutralWithoutBonded() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1, card1.getRowType());
        player1.playCard(card0, card0.getRowType());
        game.roundCompleted();

        player1.selectCard(1);// en la 0 esta la vaca en la 1 esta la catapulta
        player1.playCard(card2, card2.getRowType()); // carta medico revive una carta de la ronda anterior

        // 5 + 8 = 13
        Assertions.assertEquals(13, player1.totalPointsRound(game.getBoard()));

    }

}
