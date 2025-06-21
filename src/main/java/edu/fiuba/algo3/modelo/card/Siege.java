package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import javax.smartcardio.Card;
import java.util.List;

public class Siege extends UnitCard {
    public Siege(String name,String description, Point points, Ability ability) {
        super(name, description, points, ability);
    }
    public Siege(String name, String description, Point points) {
        super(name, description,points);
    }

    @Override
    public void addCard(PlayerSection playerSection) {
        playerSection.addCardToSiege(this);
    }

    @Override
    public void play(Player player) {
        super.play(player);
    }
}
