package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Agile;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgileTest {

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

    private Ability agile;

    @BeforeEach
    public void setUp() {

        List<AbstractCard> cards1 = new ArrayList<>();

        agile = new Agile();

        List<Section> section = new ArrayList<>();
        Section melee = new Melee();
        Section ranged = new Ranged();
        section.add(melee);
        section.add(ranged);

        card1 = new UnitCard("guerrero", "guerrero", new Point(10), section, agile);


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
    public void agileTestAddMelee(){

        Board board = Board.getInstance();
        player1.playCard(card1, 0);
        List<UnitCard> cardsInRow = board.getCardsRow(player1, new Melee());

        assertEquals(cardsInRow.get(0), card1);
    }

    @Test
    public void agileTestAddRanged(){

        Board board = Board.getInstance();
        player1.playCard(card1, 1);
        List<UnitCard> cardsInRow = board.getCardsRow(player1, new Ranged());

        assertEquals(cardsInRow.get(0), card1);
    }

}













