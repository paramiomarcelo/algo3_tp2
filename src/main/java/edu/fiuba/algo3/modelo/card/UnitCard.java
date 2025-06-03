package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.player.Player;

public class UnitCard extends AbstractCard implements ScorableCard {
    private Integer points;
    private final SectionType rowType;

    public UnitCard(String name, String description, Integer points, SectionType rowType) {
        super(name, description);
        this.points = points;
        this.rowType = rowType;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public Integer getPoints() {
        return points;
    }

    @Override
    public void play(Game game, Player player) {
        game.placeUnitCard(player, this, this.rowType);
    }



}
