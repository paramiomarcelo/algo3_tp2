package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.ability.Medic;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MedicTest {

    @Mock
    private Player player;
    
    @Mock
    private UnitCard medicCard;
    
    @Mock
    private Board board;
    
    @Mock
    private AbstractCard cardToRevive;
    
    private Medic medicAbility;
    private List<AbstractCard> discardPile;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        medicAbility = new Medic();
        discardPile = new ArrayList<>();
        
        when(player.getDiscardPile()).thenReturn(discardPile);
        when(cardToRevive.getName()).thenReturn("Test Card");
    }

    @Test
    void testEffectWithEmptyDiscardPile() {
        
        discardPile.clear();
        
        
        Player result = medicAbility.effect(player, medicCard, board, 0);
        
        
        assertEquals(player, result);
        verify(player, times(1)).getDiscardPile();
        verify(player, never()).playCard(any(AbstractCard.class));
    }

    @Test
    void testEffectWithValidIndex() {
        
        discardPile.add(cardToRevive);
        discardPile.add(mock(AbstractCard.class));
        

        Player result = medicAbility.effect(player, medicCard, board, 0);
        
        
        assertEquals(player, result);
        assertEquals(1, discardPile.size());
        assertFalse(discardPile.contains(cardToRevive));
        verify(player, times(1)).playCard(cardToRevive);
    }


} 