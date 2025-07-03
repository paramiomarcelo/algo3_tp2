package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.board.Board;
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
    void testChoosePlayer() {

        game.setPlayers(player1, player2);
        
        
        Player chosenPlayer = game.choosePlayer();
        
        
        assertTrue(chosenPlayer == player1 || chosenPlayer == player2);
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
} 