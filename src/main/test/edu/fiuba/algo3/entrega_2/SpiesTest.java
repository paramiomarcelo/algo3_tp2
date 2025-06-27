package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Spies;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Section;
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
            List<Section> section = new ArrayList<>();
            section.add(new Melee());

            spy = new Spies();


            card1 = new UnitCard("guerrero", "guerrero", new Point(10), section, spy);


            card2 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card3 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card4 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card5 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card6 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card7 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card8 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card9 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card10 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card11 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card12 = new UnitCard("guerrero", "guerrero", new Point(10), section);
            card13 = new UnitCard("guerrero", "guerrero", new Point(10), section);



            cards1.add(card11);
            cards1.add(card12);
            cards1.add(card13);



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


        }

        @Test
        public void espiaTest(){
            Board.getInstance().reset();
            game = new Game();
            game.setPlayers(player1, player2);
            int cantidadCartasInicial = 10;
            int puntajeOponenteInicial = player2.getPoints();

            player1.playCard(card1);

            assertTrue(player1.hasNumberOfCards(cantidadCartasInicial + 1));
            assertEquals(puntajeOponenteInicial+10, player2.getPoints());
        }

    }
