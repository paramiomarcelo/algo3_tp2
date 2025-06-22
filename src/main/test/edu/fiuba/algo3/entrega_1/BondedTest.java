package edu.fiuba.algo3.entrega_1;

//import com.tngtech.archunit.core.importer.LocationResolver;
import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Bonded;
import edu.fiuba.algo3.modelo.ability.Medic;
import edu.fiuba.algo3.modelo.ability.SumBaseValue;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;
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
    private UnitCard card0;
    private UnitCard card1;
    private UnitCard card2;
    private UnitCard card3;
    private UnitCard card4;

    List<Section> sectionMelee = new ArrayList<>();
    List<Section> sectionRanged = new ArrayList<>();
    List<Section> sectionSiege = new ArrayList<>();

    {
        sectionMelee.add(new Melee());
        sectionRanged.add(new Ranged());
        sectionSiege.add(new Siege());
    }

    @BeforeEach
    void setUp() {
        Ability bonded = new Bonded();
        Ability medic = new Medic();
        Ability sumBaseValue = new SumBaseValue();

        card0 = new UnitCard("Cow", "Vaca", new Point(1), sectionRanged);
        card1 = new UnitCard("Catapulta", "Bounded: unidad que duplica valor", new Point(8), sectionSiege, bonded);
        card3 = new UnitCard("Catapulta", "Bounded: unidad que duplica valor", new Point(8), sectionSiege, bonded);
        card2 = new UnitCard("Medic", "medico",new Point(5), sectionSiege, medic);
        card4 = new UnitCard("sumador","elQue suma",new Point(3), sectionSiege, sumBaseValue);

        cards = new ArrayList<>();
        cards.add(card0);
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        deck = new Deck(cards);


    }
    @Test
    void AddCardBoard() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1,player2);
        player1.playCard(card0);

        Assertions.assertEquals(1, player1.getPoints());
    }
    @Test
    void TestUseAbilityBonded(){
        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1);
        player1.playCard(card3);
        player1.playCard(card4);

        Board.getInstance().actualScore(player1);



        Assertions.assertEquals(37, player1.getPoints());

    }

    @Test
    void cardEffectMedicWithCardBonded() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1); //catapulta
        player1.playCard(card0);
        game.roundCompleted();
        player1.playCard(card3);//carta catapulta bonded
        player1.selectCard(1);
        player1.playCard(card2); // carta medico revive una carta de la ronda anterior

        // 8 + 8 + 5
        Assertions.assertEquals(21, player1.getPoints());
    }
    @Test
    void cardEffectMedicWithCardNeutral() {

        game = new Game();
        player1 = new Player("j1", deck);
        player2 = new Player("J2", deck);

        game.setPlayers(player1, player2);
        player1.playCard(card1);
        player1.playCard(card0);
        game.roundCompleted();


        player1.playCard(card1);//carta catapulta bonded
        player1.selectCard(0);// en la 0 esta la vaca en la 1 esta la catapulta
        player1.playCard(card2); // carta medico revive una carta de la ronda anterior

        Board.getInstance().actualScore(player1);
        // 8 + 5 -> 8 + 5 + 1 -> 8 + 1 + 5 = 14
        Assertions.assertEquals(14, player1.getPoints());

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

        player1.selectCard(1);// en la 0 esta la vaca en la 1 esta la catapulta
        player1.playCard(card2); // carta medico revive una carta de la ronda anterior

        // 5 + 8 = 13
        Assertions.assertEquals(13, player1.getPoints());

    }

}