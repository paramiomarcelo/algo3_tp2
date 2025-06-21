package edu.fiuba.algo3.modelo.card;


import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.board.PlayerSection;
import edu.fiuba.algo3.modelo.player.Player;

public abstract class UnitCard extends AbstractCard {
    private Ability ability;
    private Point points;

    public UnitCard(String name, String description, Point points, Ability ability) {
        super(name, description);
        this.points = points;
        this.ability = ability;
    }

    public UnitCard(String name, String description, Point points) {
        super(name, description);
        this.points = points;
        this.ability = null;
    }
    public abstract void addCard(PlayerSection playerSection);
    //        section.addCardToSection(card, playerSection);

    @Override
    public void play(Player player) {
        Board.getInstance().addCard(player, this);

    }

    public Player apply(Player player, UnitCard unitCard) {
        Player pepe = player;
        if (this.ability != null){
            ability.effect(player, this);

        }
        return pepe;
    }

    public int getPoints(){
        return points.getPoints();
    }

    public void duplicatePoints() {
        points.incrementPoints();
    }
    public void sumaUNo(){
        points.incrementoUno();
    }
    public Point setPoints() {
        return points;
    }
}
