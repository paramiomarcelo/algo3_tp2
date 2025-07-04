package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {

    @Mock
    private Player player1;
    
    @Mock
    private Player player2;
    
    @Mock
    private Board board;
    
    private Game game;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        game = new Game();
        when(player1.getName()).thenReturn("Player 1");
        when(player2.getName()).thenReturn("Player 2");
    }

    @Test
    void testSetPlayers() {
        
        game.setPlayers(player1, player2);
        
        
        assertEquals(player1, game.getCurrentPlayer());
        assertNotNull(game.getBoard());
    }

    @Test
    void testSwitchTurn() {
        
        game.setPlayers(player1, player2);
        
        
        assertEquals(player2, game.switchTurn(player1));
        assertEquals(player1, game.switchTurn(player2));
    }

    @Test
    void testRoundCompleted() {
        
        game.setPlayers(player1, player2);
        
        
        game.roundCompleted();
        
        
        verify(player1, times(1)).clearRound(any(Board.class));
        verify(player2, times(1)).clearRound(any(Board.class));
        verify(player1, times(1)).resetTurn();
        verify(player2, times(1)).resetTurn();
    }

    @Test
    void testGetCurrentPlayer() {
        
        game.setPlayers(player1, player2);
        
        
        Player currentPlayer = game.getCurrentPlayer();
        
        
        assertEquals(player1, currentPlayer);
    }

    @Test
    void testGetBoard() {
        
        Board board = game.getBoard();
        
        
        assertNotNull(board);
    }

    @Test
    void testPlayerResetRealInstance() {
        Deck deck = new Deck(new java.util.ArrayList<>());
        Player realPlayer = new Player("RealPlayer", deck);
        realPlayer.substractLife();
        realPlayer.passTurn();
        realPlayer.getHand().add(null); 
        realPlayer.getDiscardPile().add(null);
        assertEquals(1, realPlayer.getLife());
        assertTrue(realPlayer.isPass());
        assertFalse(realPlayer.getHand().isEmpty());
        assertFalse(realPlayer.getDiscardPile().isEmpty());

        realPlayer.reset();
        assertEquals(2, realPlayer.getLife());
        assertFalse(realPlayer.isPass());
        assertTrue(realPlayer.getHand().isEmpty());
        assertTrue(realPlayer.getDiscardPile().isEmpty());
        assertEquals(0, realPlayer.getScore().getScoreTotal());
    }

    @Test
    void testGameResetRealInstance() {
        Deck deck1 = new Deck(new java.util.ArrayList<>());
        Deck deck2 = new Deck(new java.util.ArrayList<>());
        Player realPlayer1 = new Player("Real1", deck1);
        Player realPlayer2 = new Player("Real2", deck2);
        Game realGame = new Game();
        realGame.setPlayers(realPlayer1, realPlayer2);
        realPlayer1.substractLife();
        realPlayer2.substractLife();
        realPlayer1.passTurn();
        realPlayer2.passTurn();
        realPlayer1.getHand().add(null);
        realPlayer2.getHand().add(null);
        Board.getInstance().addPlayer(new Player("Extra", new Deck(new java.util.ArrayList<>())));

        realGame.reset();
        assertEquals(2, realPlayer1.getLife());
        assertEquals(2, realPlayer2.getLife());
        assertFalse(realPlayer1.isPass());
        assertFalse(realPlayer2.isPass());
        assertTrue(realPlayer1.getHand().isEmpty());
        assertTrue(realPlayer2.getHand().isEmpty());
        assertEquals(0, realPlayer1.getScore().getScoreTotal());
        assertEquals(0, realPlayer2.getScore().getScoreTotal());
        assertNull(Board.getInstance().getPlayerSection(new Player("Extra", new Deck(new java.util.ArrayList<>()))));
    }
} 