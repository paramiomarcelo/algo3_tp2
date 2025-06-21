package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Bonded;
import edu.fiuba.algo3.modelo.ability.Medic;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.*;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.MeleeAffect;
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
    UnitCard card3;
    UnitCard card4;
    UnitCard card5;


    @BeforeEach
    void setUp() {
        List<Ability> bonded = List.of(new Bonded());
        List<Ability> medic = List.of(new Medic());
        card0 = new Ranged("Cow", "Vaca", new Point(1));
        card1 = new Siege("Catapulta", "Bounded: unidad que duplica valor",
                new Point(8), new Bonded());
        card4 = new Siege("Catapulta", "Bounded: unidad que duplica valor",
                new Point(8), new Bonded());
        card5 = new Siege("Catapulta", "Bounded: unidad que duplica valor",
                new Point(8), new Bonded());
        card2 = new Siege("Medic", "medico", new Point(5), new Medic());
        card3 = new Ranged("Arquero", "Unidad a distancia", new Point(5));

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
        player1.playCard(card0);

//        Assertions.assertEquals(1, player1.totalPointsRound(game.getBoard()));
    }
    @Test
    void TestUseAbilityBonded(){
        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1);
        player1.playCard(card4);
        player1.playCard(card5);

        game.actualScore();

        Assertions.assertEquals(48, player1.getScore().getScoreTotal());

    }

    @Test
    void cardEffectMedicWithCardBonded() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1);
        player1.playCard(card0);

        game.roundCompleted();

        player1.playCard(card4);//carta catapulta bonded
        player1.playCard(card2); // carta medico revive una carta de la ronda anterior

        // 8 + 5 -> 8 + 5 + 8 -> 16 + 16 + 5 = 37
//        Assertions.assertEquals(37, player1.totalPointsRound(game.getBoard()));

        game.actualScore();

        Assertions.assertEquals(37, player1.getScore().getScoreTotal());
    }
    @Test
    void cardEffectMedicWithCardNeutral() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card0);
        player1.playCard(card0);
        game.roundCompleted();
        player1.playCard(card4);//carta catapulta bonded
        player1.playCard(card2); // carta medico revive una carta de la ronda anterior

        // 8 + 5 -> 8 + 5 + 1 -> 8 + 1 + 5 = 14
//        Assertions.assertEquals(14, player1.totalPointsRound(game.getBoard()));
        game.actualScore();

        Assertions.assertEquals(14, player1.getScore().getScoreTotal());

    }
    @Test
    void cardEffectMedicWithCardNeutralWithoutBonded() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1);
        player1.playCard(card0);
        game.roundCompleted();

        //player1.selectCard(1);// en la 0 esta la vaca en la 1 esta la catapulta
        player1.playCard(card2); // carta medico revive una carta de la ronda anterior

        // 5 + 8 = 13
//        Assertions.assertEquals(13, player1.totalPointsRound(game.getBoard()));

        game.actualScore();

        Assertions.assertEquals(13, player1.getScore().getScoreTotal());

    }

}
