package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Spies;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;
import java.util.List;

public class SpiesTest {

        private Game game;
        private Player player1;
        private Player player2;
        private Deck deck;

        private UnitCard card1;
        private UnitCard card2;
        private UnitCard card3;
        private UnitCard card4;
        private UnitCard card5;
        private UnitCard card6;
        private UnitCard card7;
        private UnitCard card8;
        private UnitCard card9;
        private UnitCard card10;
        private UnitCard card11;
        private UnitCard card12;
        private UnitCard card13;

        private Ability spy;

        @BeforeEach
        public void setUp() {

            List<AbstractCard> cards1 = new ArrayList<>();

            spy = new Spies();


            card1 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee(), spy);


            card2 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card3 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card4 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card5 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card6 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card7 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card8 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card9 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card10 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card11 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card12 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());
            card13 = new UnitCard("guerrero", "guerrero", new Point(10), new Melee());



            cards1.add(card11);
            cards1.add(card12);
            cards1.add(card13);

            game = new Game();

            deck = new Deck(cards1);

            player1 = new Player("matias", deck);
            player2 = new Player("nicolas", deck);

            player1.addCard(card1);
            player1.addCard(card2);
            player1.addCard(card3);
            player1.addCard(card4);
            player1.addCard(card5);
            player1.addCard(card6);
            player1.addCard(card7);
            player1.addCard(card8);
            player1.addCard(card9);
            player1.addCard(card10);

            game.setPlayers(player1, player2);
        }

        @Test
        public void espiaTest(){
            int cantidadCartasInicial = 10;
            int puntajeOponenteInicial = player2.getPoints();

            player1.playCard(card1);

            assertTrue(player1.hasNumberOfCards(cantidadCartasInicial + 1));
            assertEquals(puntajeOponenteInicial+10, player2.getPoints());
        }

    }
