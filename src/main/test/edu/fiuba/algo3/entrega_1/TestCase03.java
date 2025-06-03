package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.clases.*;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.clases.Section.*;

public class TestCase03 {
    @Test
    void testCaseAddCardInTheBoard() {
        Game game = new Game();
        Player player = new Player("gian");

        Deck mazo = new Deck();

        Cards card0 = new Unit("uno",2, melee, "melee");
        mazo.addCard(card0);
        Cards card1 = new Unit("dos",1, melee, "melee");
        mazo.addCard(card1);
        Cards card2 = new Unit("tres",3, melee, "melee");
        mazo.addCard(card2);
        Cards card3 = new Unit("cuatro",2, melee, "melee");
        mazo.addCard(card3);
        Cards card4 = new Unit("cinco",2, melee, "melee");
        mazo.addCard(card4);
        Cards card5 = new Unit("seis",8, melee, "melee");
        mazo.addCard(card5);
        Cards card6 = new Unit("siete",8, melee, "melee");
        mazo.addCard(card6);
        Cards card7 = new Unit("ocho",2, melee, "melee");
        mazo.addCard(card7);
        Cards card8 = new Unit("nueve",2, melee, "melee");
        mazo.addCard(card8);
        Cards card9 = new Unit("diez",2, melee, "melee");
        mazo.addCard(card9);

        game.setPlayerRound();
        player = game.getCurrentPlayer();
        player.distributeCards(mazo.getCards());

        player.playCard(game.getBoard(), 0);
        player.playCard(game.getBoard(),1);
        player.playCard(game.getBoard(),2);
        player.playCard(game.getBoard(),3);
        player.playCard(game.getBoard(),4);
        //tene en cuenta que se borran las cartas una vez usadas de la mano y la siguiente toma su posicion

        Assert.assertEquals(player.getScore(), 17);

    }
    @Test
    void TestCase06CartasUnidasduplicanValorConCartaSpecialSinSumarPuntos() {

        Game game = new Game();
        Deck mazo = new Deck();

        Unit Catapult = new Unit("Catapult", 8, siege, "Duplica si hay otra carta igual", new TightBond());
        mazo.addCard(Catapult);
        mazo.addCard(Catapult);
        mazo.addCard(Catapult);
        Unit Cow = new Unit("Cow", 0, range, "");
        mazo.addCard(Cow);
        mazo.addCard(Cow);
        Unit GeraltOfRivia = new Unit("Geralt of Rivia", 15, melee,"Superman");
        mazo.addCard(GeraltOfRivia);
        Unit Roach = new Unit("Roach", 4, melee, "");
        mazo.addCard(Roach);
        Unit Vesemir = new Unit("Catapult", 6, melee, "viejo fuerte");
        mazo.addCard(Vesemir);
        Unit Cockatrice = new Unit("Cockatrice", 4, melee, "Un cocodrilo que busca su gemelo", new TightBond());
        mazo.addCard(Cockatrice);
        //mazo.addCard(Cockatrice);
        //Unit Arachas = new Unit("Arachas", 4, melee, "");
        Specials Rain = new Specials("Rain", "lluviesita", new Weather());
        mazo.addCard(Rain);

        game.setPlayerRound();
        Player player = game.getCurrentPlayer();
        player.distributeCards(mazo.getCards());
        int total = player.getCardHand();

        for (int i = 0; i < total; i++) {
            player.playCard(game.getBoard(), 0);
        }

        Assert.assertEquals(player.getScore(), 77);
    }
    @Test
    void TestCase06agregarCartasAlTableroParaActivarEfectoCartaUnida() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Board board = new Board(player1, player2);

        Unit catapult1 = new Unit("Catapult", 8, siege, "Duplica si hay otra carta igual", new TightBond());
        Unit catapult2 = new Unit("Catapult", 8, siege, "Duplica si hay otra carta igual", new TightBond());
        Unit catapult3 = new Unit("Catapult", 8, siege, "Duplica si hay otra carta igual", new TightBond());

        catapult1.play(board, player1);
        catapult2.play(board, player1);
        catapult3.play(board, player1);

        Assert.assertEquals(board.scorePlayer(player1),48);
    }
}
