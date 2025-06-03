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

        player.playCard(game.getBoard());
        player.playCard(game.getBoard());
        player.playCard(game.getBoard());
        player.playCard(game.getBoard());
        player.playCard(game.getBoard());

        Assert.assertEquals(player.getScore(), 16);

    }
}
